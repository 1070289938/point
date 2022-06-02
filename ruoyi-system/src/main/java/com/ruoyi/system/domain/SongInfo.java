package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.domain.bean.SongInfoData;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 歌曲详情对象 song_info
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Data
public class SongInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 歌曲id */
    private Integer id;

    /** 歌曲名称 */
    @Excel(name = "歌曲名称")
    private String name;

    /** 歌曲图片 */
    @Excel(name = "歌曲图片")
    private String headImg;

    /** 发布用户id */
    @Excel(name = "发布用户id")
    private Long userId;

    /** 标价（积分） */
    @Excel(name = "标价", readConverterExp = "积=分")
    private Long price;

    /** 详情 */
    @Excel(name = "详情")
    private String details;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;



    public void initialize(SongInfoData songInfoData){
        this.name = songInfoData.getName();
        this.headImg=songInfoData.getHeadImg();
        this.userId=Long.valueOf(songInfoData.getUserId());
        this.price=Long.valueOf(songInfoData.getPrice());
        this.details=songInfoData.getDetails();
    }




}
