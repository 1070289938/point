package com.ruoyi.system.domain.pojo.song;

import com.ruoyi.system.domain.pojo.vo.SongVO;
import lombok.Data;

import java.util.List;

public class QueryKeywordPojo {


    @Data
    public static class OutPut{

        /**
         * 歌曲代码
         */
        private List<String> keyWord;


    }

}
