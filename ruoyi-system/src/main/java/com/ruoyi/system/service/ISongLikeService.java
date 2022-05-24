package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SongLike;

/**
 * 歌曲点赞Service接口
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
public interface ISongLikeService 
{
    /**
     * 查询歌曲点赞
     * 
     * @param id 歌曲点赞主键
     * @return 歌曲点赞
     */
    public SongLike selectSongLikeById(Long id);

    /**
     * 查询歌曲点赞列表
     * 
     * @param songLike 歌曲点赞
     * @return 歌曲点赞集合
     */
    public List<SongLike> selectSongLikeList(SongLike songLike);

    /**
     * 新增歌曲点赞
     * 
     * @param songLike 歌曲点赞
     * @return 结果
     */
    public int insertSongLike(SongLike songLike);

    /**
     * 修改歌曲点赞
     * 
     * @param songLike 歌曲点赞
     * @return 结果
     */
    public int updateSongLike(SongLike songLike);

    /**
     * 批量删除歌曲点赞
     * 
     * @param ids 需要删除的歌曲点赞主键集合
     * @return 结果
     */
    public int deleteSongLikeByIds(String ids);

    /**
     * 删除歌曲点赞信息
     * 
     * @param id 歌曲点赞主键
     * @return 结果
     */
    public int deleteSongLikeById(Long id);
}
