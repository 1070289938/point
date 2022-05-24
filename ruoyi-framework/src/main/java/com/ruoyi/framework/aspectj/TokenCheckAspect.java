package com.ruoyi.framework.aspectj;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.cache.UserTokenCache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TokenCheckAspect {
    @Autowired
    UserTokenCache userTokenCache;


    @Pointcut("@annotation(com.ruoyi.common.annotation.TokenCheck)")
    public void annotationPointcut() {
    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
    }

    @Around("annotationPointcut()")
    public Object afterPointcut(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();

        JSONObject object = null;
        if (isString(args[0])) {
            object = JSON.parseObject(args[0].toString());
            //log.info("请求接口: {}\n请求参数: {}", joinPoint.getSignature().toString(), args[0].toString());
        } else {
            String json = JSON.toJSONString(args[0]);
            //log.info("请求接口: {}\n请求参数: {}", joinPoint.getSignature().toString(), json);
            object = JSON.parseObject(json);
        }

        Integer userId = object.getInteger("userId");
        String token = object.getString("token");

        // 签名验证
        if (StringUtils.isEmpty(token)) {
            return AjaxResult.error("您的请求信息有误");
        }
        if (userId == null) {
            return AjaxResult.error("您的请求信息有误");
        }
        boolean flag = userTokenCache.isToken(userId, token);
        if (!flag) {
            log.info("tokenCheck error");
            return AjaxResult.error("令牌验证失败");
        }
        return joinPoint.proceed();
    }


    @AfterReturning("annotationPointcut()")
    public void doAfterReturning(JoinPoint joinPoint) {

    }


    private boolean isString(Object obj) {
        boolean flag = false;
        if (obj instanceof String) {
            flag = true;
        }
        return flag;
    }

}
