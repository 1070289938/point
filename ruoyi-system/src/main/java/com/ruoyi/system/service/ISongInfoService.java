package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.exception.LogicException;
import com.ruoyi.system.domain.SongInfo;
import com.ruoyi.system.domain.bean.SongInfoData;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.song.BuySongPojo;
import com.ruoyi.system.domain.pojo.song.CollectSongPojo;
import com.ruoyi.system.domain.pojo.song.LikeSongPojo;
import com.ruoyi.system.domain.pojo.song.QuerySongPojo;
import com.ruoyi.system.domain.pojo.user.QueryUserPojo;

/**
 * 歌曲详情Service接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface ISongInfoService
{
    /**
     * 查询歌曲详情
     *
     * @param id 歌曲详情主键
     * @return 歌曲详情
     */
    public SongInfo selectSongInfoById(Long id);

    /**
     * 查询歌曲详情列表
     *
     * @param songInfo 歌曲详情
     * @return 歌曲详情集合
     */
    public List<SongInfo> selectSongInfoList(SongInfo songInfo);

    /**
     * 新增歌曲详情
     *
     * @param songInfo 歌曲详情
     * @return 结果
     */
    public int insertSongInfo(SongInfoData songInfo);

    /**
     * 修改歌曲详情
     *
     * @param songInfo 歌曲详情
     * @return 结果
     */
    public int updateSongInfo(SongInfo songInfo);

    /**
     * 批量删除歌曲详情
     *
     * @param ids 需要删除的歌曲详情主键集合
     * @return 结果
     */
    public int deleteSongInfoByIds(String ids);

    /**
     * 删除歌曲详情信息
     *
     * @param id 歌曲详情主键
     * @return 结果
     */
    public int deleteSongInfoById(Long id);

    /**
     * 分页查询歌曲
     * @param param
     * @return
     */
    QuerySongPojo.OutPut querySong(ParamPojo<QuerySongPojo.Param> param) throws LogicException;


    /**
     * 给歌曲点赞
     * @param param
     * @return
     */
    LikeSongPojo.OutPut likeSong(ParamPojo<LikeSongPojo.Param> param) throws LogicException;


    /**
     * 收藏当前歌曲
     * @param param
     * @return
     */
    CollectSongPojo.OutPut collectSong(ParamPojo<CollectSongPojo.Param> param) throws LogicException;


    /**
     * 购买歌曲
     * @param param
     * @return
     */
    BuySongPojo.OutPut buySong(ParamPojo<BuySongPojo.Param> param)throws LogicException;

    /**
     * 查询我的已购歌曲
     * @param param
     * @return
     * @throws LogicException
     */
    QuerySongPojo.OutPut queryMySong(ParamPojo<QuerySongPojo.Param> param)throws LogicException;


}
