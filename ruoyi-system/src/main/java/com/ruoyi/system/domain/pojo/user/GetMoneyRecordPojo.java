package com.ruoyi.system.domain.pojo.user;

import com.ruoyi.system.domain.AmountRecord;
import com.ruoyi.system.domain.pojo.vo.RecordVO;
import com.ruoyi.system.domain.pojo.vo.SongVO;
import lombok.Data;

import java.util.List;

public class GetMoneyRecordPojo {

    @Data
    public static class Param {
        //页数
        private Integer page;
        //每页数量
        private Integer size;


    }

    @Data
    public static class OutPut {

        List<RecordVO> recordVOList;



    }

}
