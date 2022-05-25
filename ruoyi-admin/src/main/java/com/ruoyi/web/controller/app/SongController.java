package com.ruoyi.web.controller.app;


import com.github.pagehelper.page.PageMethod;
import com.ruoyi.common.annotation.RequestLimits;
import com.ruoyi.common.annotation.TokenCheck;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.LogicException;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.song.BuySongPojo;
import com.ruoyi.system.domain.pojo.song.CollectSongPojo;
import com.ruoyi.system.domain.pojo.song.LikeSongPojo;
import com.ruoyi.system.domain.pojo.song.QuerySongPojo;
import com.ruoyi.system.domain.pojo.user.LoginPojo;
import com.ruoyi.system.domain.pojo.user.QueryUserPojo;
import com.ruoyi.system.service.ISongInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 歌曲相关
 */
@RestController
@RequestMapping("app/song")
public class SongController {
    @Autowired
    private ISongInfoService songInfoService;

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
     * @param param
     * @return
     */
    @PostMapping("buySong")
    @RequestLimits(t = 10,count = 10)
    @TokenCheck
    public AjaxResult buySong(@RequestBody ParamPojo<BuySongPojo.Param> param){


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



}
