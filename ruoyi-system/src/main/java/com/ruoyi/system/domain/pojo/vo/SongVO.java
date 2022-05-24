package com.ruoyi.system.domain.pojo.vo;

import com.ruoyi.system.domain.SongInfo;
import lombok.Data;

import java.util.Date;

@Data
public class SongVO {

    private int id;//id
    private String name;//歌曲名字
    private String img;//歌曲图片
    private int price;//价格
    private String details;//详情
    private Date createTime;//创建时间


    private Integer userId;


    private UserVO userVO;//上传用户

    private int link;//点赞数量
    private Integer isLink;//当前用户是否点赞

    private int download;//下载
    private Integer isDownload;

    private int collect;//是否收藏此歌曲

    private String code;//歌曲节奏代码
    private double speed = 1;//歌曲速度倍数
    private Integer longTime;//长延迟
    private Integer defaultTime;//默认延迟
    private Integer shortTime;//短延迟
    private Integer veryShortTime;//超短延迟

    public void setSong(SongInfo song) {
        this.id = song.getId().intValue();
        this.createTime = song.getCreateTime();
        this.details = song.getDetails();
        this.price = song.getPrice().intValue();
        this.img = song.getHeadImg();
        this.name = song.getName();
    }


}
