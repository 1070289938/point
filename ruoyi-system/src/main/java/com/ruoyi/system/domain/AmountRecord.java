package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消费记录对象 amount_record
 *
 * @author ruoyi
 * @date 2022-05-21
 */
@Data
public class AmountRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderId;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 金额 */
    @Excel(name = "金额")
    private Long money;

    /** 详情 */
    @Excel(name = "详情")
    private String details;

    /** 类型 */
    @Excel(name = "类型")
    private Integer type;


}
