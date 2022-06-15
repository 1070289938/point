package com.ruoyi.system.domain.pojo.song;

import com.ruoyi.system.domain.pojo.vo.SongVO;
import lombok.Data;

import java.util.List;

public class QuerySongPojo {
    @Data
    public static class Param {
        //页数
        private Integer page;
        //每页数量
        private Integer size;
        //是否收藏
        private Boolean collect;
        //推荐歌曲
        private Boolean  recommend;
        //用户id
        private Integer userId;
        //是否付费
        private Boolean isPay;
        //是否免费
        private Boolean free;
        //模糊查询歌曲名称
        private String name;
    }

    @Data
    public static class OutPut {

        List<SongVO> songVOList;

    }

}
