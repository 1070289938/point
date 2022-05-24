package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SongCollectMapper;
import com.ruoyi.system.domain.SongCollect;
import com.ruoyi.system.service.ISongCollectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户收藏列Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
@Service
public class SongCollectServiceImpl implements ISongCollectService 
{
    @Autowired
    private SongCollectMapper songCollectMapper;

    /**
     * 查询用户收藏列
     * 
     * @param id 用户收藏列主键
     * @return 用户收藏列
     */
    @Override
    public SongCollect selectSongCollectById(Long id)
    {
        return songCollectMapper.selectSongCollectById(id);
    }

    /**
     * 查询用户收藏列列表
     * 
     * @param songCollect 用户收藏列
     * @return 用户收藏列
     */
    @Override
    public List<SongCollect> selectSongCollectList(SongCollect songCollect)
    {
        return songCollectMapper.selectSongCollectList(songCollect);
    }

    /**
     * 新增用户收藏列
     * 
     * @param songCollect 用户收藏列
     * @return 结果
     */
    @Override
    public int insertSongCollect(SongCollect songCollect)
    {
        songCollect.setCreateTime(DateUtils.getNowDate());
        return songCollectMapper.insertSongCollect(songCollect);
    }

    /**
     * 修改用户收藏列
     * 
     * @param songCollect 用户收藏列
     * @return 结果
     */
    @Override
    public int updateSongCollect(SongCollect songCollect)
    {
        return songCollectMapper.updateSongCollect(songCollect);
    }

    /**
     * 批量删除用户收藏列
     * 
     * @param ids 需要删除的用户收藏列主键
     * @return 结果
     */
    @Override
    public int deleteSongCollectByIds(String ids)
    {
        return songCollectMapper.deleteSongCollectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户收藏列信息
     * 
     * @param id 用户收藏列主键
     * @return 结果
     */
    @Override
    public int deleteSongCollectById(Long id)
    {
        return songCollectMapper.deleteSongCollectById(id);
    }
}
