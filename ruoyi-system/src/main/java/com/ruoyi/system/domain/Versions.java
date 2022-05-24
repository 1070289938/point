package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 版本管理器对象 versions
 *
 * @author ruoyi
 * @date 2022-05-20
 */
public class Versions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 版本 */
    @Excel(name = "版本")
    private String versions;

    /** 下载路径 */
    @Excel(name = "下载路径")
    private String path;


    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setVersions(String versions)
    {
        this.versions = versions;
    }

    public String getVersions()
    {
        return versions;
    }
    public void setPath(String path)
    {
        this.path = path;
    }

    public String getPath()
    {
        return path;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("versions", getVersions())
            .append("path", getPath())
            .toString();
    }
}
