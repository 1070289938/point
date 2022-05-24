package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long userId;

    /** 注册码使用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册码使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hoursUse;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setHoursUse(Date hoursUse) 
    {
        this.hoursUse = hoursUse;
    }

    public Date getHoursUse() 
    {
        return hoursUse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("qq", getQq())
            .append("code", getCode())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("hoursUse", getHoursUse())
            .toString();
    }
}
