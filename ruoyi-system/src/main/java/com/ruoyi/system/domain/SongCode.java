package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.domain.bean.SongInfoData;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 歌曲代码对象 song_code
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Data
public class SongCode extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 代码名称
     */
    @Excel(name = "代码名称")
    private String name;

    /**
     * 歌曲id
     */
    @Excel(name = "歌曲id")
    private Long songId;

    /**
     * 歌曲代码
     */
    @Excel(name = "歌曲代码")
    private String code;

    /**
     * 代码类型
     */
    @Excel(name = "代码类型")
    private String codeType;

    /**
     * 歌曲播放倍率
     */
    @Excel(name = "歌曲播放倍率")
    private BigDecimal speed;

    /**
     * 长延迟
     */
    @Excel(name = "长延迟")
    private Long longTime;

    /**
     * 默认延迟
     */
    @Excel(name = "默认延迟")
    private Long defaultTime;

    /**
     * 短延迟
     */
    @Excel(name = "短延迟")
    private Long shortTime;

    /**
     * 超短延迟
     */
    @Excel(name = "超短延迟")
    private Long veryShortTime;

    /**
     * 删除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;


    public void initialize(SongInfoData songInfoData, Long id) {
        this.name = songInfoData.getName();
        this.songId = id;
        this.code = songInfoData.getCode();
        this.codeType = songInfoData.getCodeType();
        this.speed = new BigDecimal(songInfoData.getSpeed());
        this.longTime = Long.getLong(songInfoData.getLongTime());
        this.defaultTime = Long.getLong(songInfoData.getDefaultTime());
        this.shortTime = Long.getLong(songInfoData.getShortTime());
        this.veryShortTime = Long.getLong(songInfoData.getShortTime());

    }


}
