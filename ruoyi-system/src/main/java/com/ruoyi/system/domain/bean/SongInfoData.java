package com.ruoyi.system.domain.bean;

import lombok.Data;

@Data
public class SongInfoData{
    //歌曲名称
    private String name;
    //歌曲图片
    private String headImg;
    //发布用户id
    private String userId;
    //标价
    private String price;
    //详情
    private String details;
    //歌曲代码
    private String code;
    //代码类型
    private String codeType;
    //歌曲播放倍率
    private String speed;
    //长延迟
    private String longTime;
    //默认延迟
    private String defaultTime;
    //短延迟
    private String shortTime;
    //超短延迟
    private String veryShortTime;
}
