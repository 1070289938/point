package com.ruoyi.system.cache;

import com.ruoyi.system.cache.utils.RedisUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xian
 */
@Component
public class RequestBlacklistCache {
    private static final String CACHE_NAME = "RequestBlacklist:";
    @Resource
    public RedisUtil redisUtil;

    public void add(String userId, String uri, long endDate, long t) {
        redisUtil.set(CACHE_NAME + userId + ":" + uri, endDate, t);
    }

    public long get(Integer userId, String uri) {
        Object object = redisUtil.get(CACHE_NAME + userId + ":" + uri);
        return object == null ? 0 : (long)object;
    }

    public void remove(String userId, String uri) {
        redisUtil.del(CACHE_NAME + userId + ":" + uri);
    }
}
