package com.ruoyi.system.domain.pojo.user;

import com.ruoyi.system.domain.KeyLocation;
import lombok.Data;

import java.util.Map;

/**
 * 获取用户键位
 */
public class SetUserKeyPojo {

    @Data
    public static class Param {
        //键位列表
        private Map<String,KeyLocation> map;
    }
    @Data
    public static class OutPut {



    }

}
