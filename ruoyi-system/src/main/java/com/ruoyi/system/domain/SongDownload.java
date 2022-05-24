package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 歌曲下载对象 song_download
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Data
public class SongDownload extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 歌曲id */
    @Excel(name = "歌曲id")
    private Integer songId;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

}
