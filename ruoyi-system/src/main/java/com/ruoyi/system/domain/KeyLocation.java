package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 键位对象 key_location
 * 
 * @author ruoyi
 * @date 2022-05-18
 */
public class KeyLocation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 键位id */
    @Excel(name = "键位id")
    private Integer key;

    /** x轴位置 */
    @Excel(name = "x轴位置")
    private BigDecimal x;

    /** y轴位置 */
    @Excel(name = "y轴位置")
    private BigDecimal y;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setKey(Integer key) 
    {
        this.key = key;
    }

    public Integer getKey() 
    {
        return key;
    }
    public void setX(BigDecimal x) 
    {
        this.x = x;
    }

    public BigDecimal getX() 
    {
        return x;
    }
    public void setY(BigDecimal y) 
    {
        this.y = y;
    }

    public BigDecimal getY() 
    {
        return y;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("key", getKey())
            .append("x", getX())
            .append("y", getY())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
