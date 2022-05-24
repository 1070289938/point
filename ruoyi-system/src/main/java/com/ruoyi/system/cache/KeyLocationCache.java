package com.ruoyi.system.cache;

import com.alibaba.fastjson.JSON;
import com.ruoyi.system.cache.utils.RedisUtil;
import com.ruoyi.system.domain.KeyLocation;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.mapper.KeyLocationMapper;
import com.ruoyi.system.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.security.Key;
import java.util.*;

@Component
public class KeyLocationCache {


    private static final String CACHE_NAME = "KeyLocation:";
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private KeyLocationMapper keyLocationMapper;


    /**
     * 更新键位
     *
     * @param userInfo 用户对象
     */
    public void updateKeyLocations(Integer userId, Map<String, KeyLocation> keyLocations) {
        KeyLocation keyLocation;
        Map<String,String> map = new HashMap<>();
        for (String key : keyLocations.keySet()) {
            keyLocation = keyLocations.get(key);
            keyLocation.setUpdateTime(new Date());
            keyLocationMapper.updateKeyLocation(keyLocation);
            map.put(key,JSON.toJSONString(keyLocations.get(key)));
        }
        redisUtil.hmset(CACHE_NAME + userId, map);
    }


    /**
     * 获取键位
     */
    public Map<String, KeyLocation> getKeyLocations(Integer userId) {
        Map<String, KeyLocation> retMap = new HashMap<>();
        Map<Object, Object> map = redisUtil.hmget(CACHE_NAME + userId);
        if (map.size()==0) {
            List<KeyLocation> list = keyLocationMapper.selectKeyLocationListByUserId(userId);
            if (list.size() == 0) {
                //初始化一个键位值
                list = iniKeyLocationList(userId);
                for (KeyLocation keyLocation : list) {
                    keyLocation.setCreateTime(new Date());
                    keyLocationMapper.insertKeyLocation(keyLocation);
                }
            }
            for (KeyLocation location : list) {
                map.put(location.getKey().toString(), JSON.toJSONString(location));
            }
            redisUtil.hmset(CACHE_NAME + userId, map);
        }
        //map转换
        for (Object o : map.keySet()) {
            retMap.put(o.toString(), JSON.parseObject(map.get(o).toString(), KeyLocation.class));
        }
        return retMap;
    }


    public List<KeyLocation> iniKeyLocationList(Integer userId) {
        List<KeyLocation> list = new ArrayList<>();
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(1);
            setX(new BigDecimal(686));
            setY(new BigDecimal(166));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(2);
            setX(new BigDecimal(899));
            setY(new BigDecimal(166));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(3);
            setX(new BigDecimal(1127));
            setY(new BigDecimal(166));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(4);
            setX(new BigDecimal(1343));
            setY(new BigDecimal(166));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(5);
            setX(new BigDecimal(1571));
            setY(new BigDecimal(166));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(6);
            setX(new BigDecimal(683));
            setY(new BigDecimal(389));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(7);
            setX(new BigDecimal(905));
            setY(new BigDecimal(389));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(8);
            setX(new BigDecimal(1122));
            setY(new BigDecimal(389));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(9);
            setX(new BigDecimal(1346));
            setY(new BigDecimal(389));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(10);
            setX(new BigDecimal(1566));
            setY(new BigDecimal(389));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(11);
            setX(new BigDecimal(681));
            setY(new BigDecimal(600));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(12);
            setX(new BigDecimal(910));
            setY(new BigDecimal(600));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(13);
            setX(new BigDecimal(1127));
            setY(new BigDecimal(600));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(14);
            setX(new BigDecimal(1345));
            setY(new BigDecimal(600));
        }});
        list.add(new KeyLocation() {{
            setUserId(userId);
            setKey(15);
            setX(new BigDecimal(1565));
            setY(new BigDecimal(600));
        }});
        return list;
    }


}
