package com.ruoyi.system.cache;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.cache.utils.RedisUtil;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserInfoCache {

    private static final String CACHE_NAME = "UserInfoList:";
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 更新userInfo
     *
     * @param userInfo 用户对象
     */
    public void updateUserInfo(UserInfo userInfo) {
        //更新数据库
        userInfoMapper.updateUserInfo(userInfo);
        //更新redis
        redisUtil.set(CACHE_NAME + userInfo.getId(), JSON.toJSONString(userInfo));
    }


    /**
     * 获取userInfo
     */
    public UserInfo getUserInfo(Integer userId) {
        String userJson = (String) redisUtil.get(CACHE_NAME + userId);
        if (userJson == null) {
            UserInfo info = userInfoMapper.selectUserInfoById(userId);
            if (info==null){
                return null;
            }
            redisUtil.set(CACHE_NAME + info.getId(), JSON.toJSONString(info));
            return info;
        }
        return JSON.parseObject(userJson, UserInfo.class);
    }


}
