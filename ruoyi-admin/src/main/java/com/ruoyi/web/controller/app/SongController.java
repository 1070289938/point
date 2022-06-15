package com.ruoyi.web.controller.app;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.page.PageMethod;
import com.ruoyi.common.annotation.RequestLimits;
import com.ruoyi.common.annotation.TokenCheck;
import com.ruoyi.common.config.CodeConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.LogicException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.system.domain.QueryKeyword;
import com.ruoyi.system.domain.SongInfo;
import com.ruoyi.system.domain.bean.SongInfoData;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.song.*;
import com.ruoyi.system.domain.pojo.user.LoginPojo;
import com.ruoyi.system.domain.pojo.user.QueryUserPojo;
import com.ruoyi.system.service.IQueryKeywordService;
import com.ruoyi.system.service.ISongInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * 歌曲相关
 */
@RestController
@RequestMapping("app/song")
public class SongController {
    @Autowired
    private ISongInfoService songInfoService;
    @Autowired
    private IQueryKeywordService queryKeywordService;

    /**
     * 分页查询歌曲
     *
     * @param param
     * @return
     */
    @PostMapping("query/song")
    @RequestLimits(t = 10, count = 10)
    public AjaxResult querySong(@RequestBody ParamPojo<QuerySongPojo.Param> param) {
        try {
            QuerySongPojo.OutPut outPut = songInfoService.querySong(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 点赞歌曲
     *
     * @param param
     * @return
     */
    @PostMapping("/like/song")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult likeSong(@RequestBody ParamPojo<LikeSongPojo.Param> param) {
        try {
            LikeSongPojo.OutPut outPut = songInfoService.likeSong(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }


    /**
     * 收藏歌曲
     *
     * @param param
     * @return
     */
    @PostMapping("/collect/song")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult collectSong(@RequestBody ParamPojo<CollectSongPojo.Param> param) {
        try {
            CollectSongPojo.OutPut outPut = songInfoService.collectSong(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 购买歌曲
     *
     * @param param
     * @return
     */
    @PostMapping("buySong")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult buySong(@RequestBody ParamPojo<BuySongPojo.Param> param) {


        try {
            BuySongPojo.OutPut outPut = songInfoService.buySong(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }

    }


    /**
     * 分页查询我的歌曲
     *
     * @param param
     * @return
     */
    @PostMapping("query/my/song")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult queryMySong(@RequestBody ParamPojo<QuerySongPojo.Param> param) {
        try {
            QuerySongPojo.OutPut outPut = songInfoService.queryMySong(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 查询歌曲代码
     *
     * @param param
     * @return
     */
    @PostMapping("queryCodeSong")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult queryCodeSong(@RequestBody ParamPojo<QueryCodeSongPojo.Param> param) {
        try {
            param.getData().setUserId(param.getUserId());
            QueryCodeSongPojo.OutPut outPut = songInfoService.queryCodeSong(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 查询歌曲搜索关键词
     *
     * @param param
     * @return
     */
    @PostMapping("queryKeyword")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult queryKeyword(@RequestBody ParamPojo<QueryKeywordPojo> param) {

        try {
            QueryKeywordPojo.OutPut outPut = queryKeywordService.queryHotKeyword();
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }


//    @PostMapping("addSong")
//    public AjaxResult addSong() throws Exception {
//
//
//        for (int i = 0; i < list.length; i++) {
//            int id = i+1;
//            SongInfo songInfo = songInfoService.selectSongInfobyDetails(id + ".php");
//            if (songInfo==null){
//                continue;
//            }
//            System.out.println(id + "--" + list[i]);
//            songInfo.setName(list[i]);
//            songInfoService.updateSongInfo(songInfo);
//        }
//
//
//
//
//        return AjaxResult.success();
//    }

}
