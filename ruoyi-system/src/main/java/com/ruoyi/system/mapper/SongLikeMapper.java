package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SongLike;
import org.apache.ibatis.annotations.Param;

/**
 * 歌曲点赞Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface SongLikeMapper
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
     * 删除歌曲点赞
     *
     * @param id 歌曲点赞主键
     * @return 结果
     */
    public int deleteSongLikeById(Long id);

    /**
     * 批量删除歌曲点赞
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSongLikeByIds(String[] ids);

    /**
     * 查询歌曲点赞数量
     * @param id
     * @return
     */
    int selectSongLikeCount(@Param("id") Integer id);

    /**
     * 查询这个用户是否给这个歌曲点赞
     * @param userId
     * @param id
     * @return
     */
    SongLike selectSongLikeIsLike(@Param("userId") Integer userId,@Param("songId") int id);

}
