package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SongLikeMapper;
import com.ruoyi.system.domain.SongLike;
import com.ruoyi.system.service.ISongLikeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 歌曲点赞Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
@Service
public class SongLikeServiceImpl implements ISongLikeService 
{
    @Autowired
    private SongLikeMapper songLikeMapper;

    /**
     * 查询歌曲点赞
     * 
     * @param id 歌曲点赞主键
     * @return 歌曲点赞
     */
    @Override
    public SongLike selectSongLikeById(Long id)
    {
        return songLikeMapper.selectSongLikeById(id);
    }

    /**
     * 查询歌曲点赞列表
     * 
     * @param songLike 歌曲点赞
     * @return 歌曲点赞
     */
    @Override
    public List<SongLike> selectSongLikeList(SongLike songLike)
    {
        return songLikeMapper.selectSongLikeList(songLike);
    }

    /**
     * 新增歌曲点赞
     * 
     * @param songLike 歌曲点赞
     * @return 结果
     */
    @Override
    public int insertSongLike(SongLike songLike)
    {
        songLike.setCreateTime(DateUtils.getNowDate());
        return songLikeMapper.insertSongLike(songLike);
    }

    /**
     * 修改歌曲点赞
     * 
     * @param songLike 歌曲点赞
     * @return 结果
     */
    @Override
    public int updateSongLike(SongLike songLike)
    {
        return songLikeMapper.updateSongLike(songLike);
    }

    /**
     * 批量删除歌曲点赞
     * 
     * @param ids 需要删除的歌曲点赞主键
     * @return 结果
     */
    @Override
    public int deleteSongLikeByIds(String ids)
    {
        return songLikeMapper.deleteSongLikeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除歌曲点赞信息
     * 
     * @param id 歌曲点赞主键
     * @return 结果
     */
    @Override
    public int deleteSongLikeById(Long id)
    {
        return songLikeMapper.deleteSongLikeById(id);
    }
}
