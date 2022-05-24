package com.ruoyi.system.domain.pojo.song;

import com.ruoyi.system.domain.pojo.vo.SongVO;
import lombok.Data;

import java.util.List;

public class LikeSongPojo {

    @Data
    public static class Param {

        private Integer songId;//歌曲id


    }

    @Data
    public static class OutPut {

        private int link;//点赞数量


    }


}
