package com.ruoyi.system.domain.pojo.song;

import lombok.Data;

public class CollectSongPojo {

    @Data
    public static class Param {

        private Integer songId;//歌曲id


    }

    @Data
    public static class OutPut {

        private int collect;//当前是否收藏


    }


}
