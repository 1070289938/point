package com.ruoyi.system.cache;

import com.ruoyi.system.cache.utils.RedisUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RequestIpLimitCache {
    private static final String CACHE_NAME = "RequestLimits:";
    @Resource
    public RedisUtil redisUtil;
    public void add(String key , String value ,  long t){
        redisUtil.set(CACHE_NAME + key, value, t);
    }

    public long addAndReturnCount(String key, Long time, Object... value) {
        redisUtil.sSetAndTime(key, time, value);
        return redisUtil.sGetSetSize(key);
    }
    public int count(String key ){
        return redisUtil.keys(CACHE_NAME + key+"*" ).size();
    }
    public String get(String key){
        return (String) redisUtil.get(CACHE_NAME + key);
    }
}
