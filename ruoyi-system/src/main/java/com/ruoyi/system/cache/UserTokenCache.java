package com.ruoyi.system.cache;

import com.ruoyi.system.cache.utils.RedisUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.domain.UserInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserTokenCache {


    private static final String CACHE_NAME = "UserTokenList:";
    @Resource
    private RedisUtil redisUtil;

    /**
     * 更新token
     *
     * @param userInfo 用户对象
     * @return 当前的新token
     */
    public String updateToken(UserInfo userInfo) {
        //token生成方式 = 用户id+用户密码+当前时间戳+随机值
        String token = Md5Utils.hash(userInfo.getId() + userInfo.getPassword() + System.currentTimeMillis() + Math.random());
        redisUtil.set(CACHE_NAME + userInfo.getId(), token);
        return token;
    }

    /**
     * 判断token是否正确
     *
     * @param userId 用户id
     * @param token  token
     * @return true 正确
     */
    public boolean isToken(int userId, String token) {
        String isToken = (String) redisUtil.get(CACHE_NAME + userId);
        if (token.equals(isToken)) {
            return true;
        }
        return false;
    }

    /**
     * 删除token
     *
     * @param userId 用户id
     */
    public void removeToken(Integer userId) {
        redisUtil.del(CACHE_NAME + userId);
    }


}
