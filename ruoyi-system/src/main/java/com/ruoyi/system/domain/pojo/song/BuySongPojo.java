package com.ruoyi.system.domain.pojo.song;

import lombok.Data;

public class BuySongPojo {


    @Data
    public static class Param {

        private Integer songId;//歌曲id

        private String payPassword;//支付密码
    }

    @Data
    public static class OutPut {

        private Long money;//剩余烛火数量


    }


}
