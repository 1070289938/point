package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 注册码绑定对象 registration_code
 *
 * @author ruoyi
 * @date 2022-05-20
 */
@Data
public class RegistrationCode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** qq */
    @Excel(name = "qq")
    private String qq;

    /** 注册码 */
    @Excel(name = "注册码")
    private String code;

    /** 注册的用户id */
    @Excel(name = "注册的用户id")
    private Integer userId;

    /** 注册码使用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册码使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hoursUse;



}
