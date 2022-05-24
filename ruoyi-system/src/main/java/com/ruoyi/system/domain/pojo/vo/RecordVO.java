package com.ruoyi.system.domain.pojo.vo;

import com.ruoyi.system.domain.AmountRecord;
import lombok.Data;

import java.util.Date;

@Data
public class RecordVO {
    //详情
    private String details;
    //金额
    private Long money;
    //创建时间
    private Date createTime;


    public RecordVO(AmountRecord record) {
        this.details = record.getDetails();
        this.money = record.getMoney();
        this.createTime = record.getCreateTime();
    }

}
