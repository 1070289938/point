package com.ruoyi.framework.aspectj;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.RequestLimits;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.cache.RequestBlacklistCache;
import com.ruoyi.system.cache.RequestIpLimitCache;
import com.ruoyi.system.domain.pojo.ParamPojo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
@Slf4j
public class RequestLimitsAspect {

    @Autowired
    private RequestIpLimitCache requestIpLimitCache;
    @Autowired
    private RequestBlacklistCache requestBlacklistCache;


    @Pointcut(value = "@annotation(com.ruoyi.common.annotation.RequestLimits)")
    public void requestLimitPointCut() {


    }

    @Around(value = "requestLimitPointCut())")
    public Object requestLimitAround(ProceedingJoinPoint pjp) {
        // 说明：此方法将个接口的时间根据周期t去余数存储到数组中，再对数组设置过期时间。eg.间隔为5秒时，时间戳1600000000000到1600000004999会存放在1600000000000这个数组中。
        // 缺点：如规定间隔为5秒可点击5次，会导致一个周期快结束的时候连点五下，不久后到下一个周期时又可以点击五下，达到5.01秒可以点10下的效果。建议将时间间隔设置的较小一些

        long start = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        RequestLimits limit = methodSignature.getMethod().getAnnotation(RequestLimits.class);

        // 限制访问次数
        int count = limit.count();

        // 获取 request ， 然后获取访问 ip
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestIp = RequestLimitsAspect.getRequestIp(request);
        if (StringUtils.isEmpty(requestIp)) {
            return AjaxResult.error("非法访问！ip不能为空！");
        }

        String uri = request.getRequestURI();

        Integer userId = 0;
        Object str = null;
        if (pjp.getArgs().length != 0) {
            str = pjp.getArgs()[0];
            try {
                if (str instanceof ParamPojo) {
                    if (((ParamPojo) str).getUserId() != null) {
                        userId = ((ParamPojo) str).getUserId();
                    }
                }
            } catch (Exception ex) {
                log.warn("未能获取到用户id，以ip进行访问限制");
            }
        }


        if (userId != null && userId != 0) {
            long requestBlacklistEndDate = requestBlacklistCache.get(userId, uri);
            LocalDateTime endDate = LocalDateTime.ofEpochSecond(requestBlacklistEndDate / 1000, 0, ZoneOffset.ofHours(8));
            if (requestBlacklistEndDate > 0 && endDate.compareTo(LocalDateTime.now()) > 0) {
                return AjaxResult.error(503, "您被限制此操作，限制结束时间：" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(endDate));
            }
        }

        long denominator = 0;
        switch (limit.timeUnit()) {
            case SECONDS:
                denominator = limit.t() * 1000;
                break;
            case DAYS:
                denominator = limit.t() * 1000 * 60 * 60 * 24;
                break;
            case HOURS:
                denominator = limit.t() * 1000 * 60 * 60;
                break;
            case MINUTES:
                denominator = limit.t() * 1000 * 60;
                break;
            case NANOSECONDS:
                denominator = limit.t() / 1000 / 1000;
                break;
            case MICROSECONDS:
                denominator = limit.t() / 1000;
                break;
            case MILLISECONDS:
                denominator = limit.t();
                break;
            default:
                denominator = 60 * 1000;
                break;
        }

        String key = String.format("RequestLimit:%s:%s:%d",
                ObjectUtils.isEmpty(userId) ? requestIp : userId,
                uri,
                System.currentTimeMillis() - (System.currentTimeMillis() % denominator));
        long a = requestIpLimitCache.addAndReturnCount(key, limit.t(), System.currentTimeMillis());
        if (a > count) {
            return AjaxResult.error(503, "您的操作过于频繁，请稍后再试");
        }
        //获取传入目标方法的参数
        Object[] args = pjp.getArgs();
        Object result = null;
        try {
            log.info("调用接口:{}", uri);
            log.info("请求参数:{}", JSON.toJSONString(str));
            // 执行访问并返回数据
            result = pjp.proceed(args);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return AjaxResult.error("请求错误");
        } finally {
            log.info("返回值：{}", JSONObject.toJSONString(result));
            log.info("接口用时：{}ms", System.currentTimeMillis() - start);
        }
    }

    public static String getRequestIp(HttpServletRequest request) {
        // 获取请求IP
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) || "null".equals(ip)) {
            ip = "" + request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) || "null".equals(ip)) {
            ip = "" + request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) || "null".equals(ip)) {
            ip = "" + request.getRemoteAddr();
        }

        return ip;
    }
}
