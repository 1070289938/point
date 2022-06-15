package com.ruoyi.system.domain.pojo.song;

import com.ruoyi.system.domain.SongCode;
import com.ruoyi.system.domain.pojo.vo.SongVO;
import lombok.Data;

public class QueryCodeSongPojo {

    @Data
    public static class Param{
        //歌曲id
        private Integer songId;
        //类型 1.查询当前歌曲  2.查询下一首 3.随机查询 4.查询上一首
        private Integer type;
        //是否是收藏
        private boolean collect;
        //推荐歌曲
        private Boolean  recommend;
        //用户id
        private Integer userId;
    }

    @Data
    public static class OutPut{

        /**
         * 歌曲代码
         */
        private SongVO songVO;


        public OutPut(SongVO songVO){
            this.songVO=songVO;
        }

        public OutPut(){}

    }


}
