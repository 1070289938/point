package com.ruoyi.system.cache;

import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.cache.utils.RedisUtil;
import com.ruoyi.system.domain.UserInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SmsCodeCache {

    private static final String CACHE_NAME = "SmsCodeList:";
    @Resource
    private RedisUtil redisUtil;

    /**
     * 写入验证码
     *
     * @param phone 手机号
     * @param code  验证码
     * @param time  过期时间 秒
     */
    public void setCode(String phone, String code, Long time) {
        redisUtil.set(CACHE_NAME+phone,code, time );
    }

    /**
     * 获取验证码
     *
     * @param phone 手机号
     * @return 验证码
     */
    public String getCode(String phone) {
        return (String) redisUtil.get(CACHE_NAME+phone);
    }

    /**
     * 删除验证码
     *
     * @param phone 手机号
     */
    public void delCode(String phone) {
        redisUtil.del(CACHE_NAME+phone);
    }


}
