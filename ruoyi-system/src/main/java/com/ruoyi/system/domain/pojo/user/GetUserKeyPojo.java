package com.ruoyi.system.domain.pojo.user;

import com.ruoyi.system.domain.KeyLocation;
import com.ruoyi.system.domain.pojo.vo.KeyVO;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 获取用户键位
 */
public class GetUserKeyPojo {

    public static class Param {

    }
    @Data
    public static class OutPut {
        //键位列表
        private Map<String, KeyVO> map;


    }

}
