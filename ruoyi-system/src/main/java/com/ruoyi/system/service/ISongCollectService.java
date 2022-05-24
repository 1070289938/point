package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SongCollect;

/**
 * 用户收藏列Service接口
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
public interface ISongCollectService 
{
    /**
     * 查询用户收藏列
     * 
     * @param id 用户收藏列主键
     * @return 用户收藏列
     */
    public SongCollect selectSongCollectById(Long id);

    /**
     * 查询用户收藏列列表
     * 
     * @param songCollect 用户收藏列
     * @return 用户收藏列集合
     */
    public List<SongCollect> selectSongCollectList(SongCollect songCollect);

    /**
     * 新增用户收藏列
     * 
     * @param songCollect 用户收藏列
     * @return 结果
     */
    public int insertSongCollect(SongCollect songCollect);

    /**
     * 修改用户收藏列
     * 
     * @param songCollect 用户收藏列
     * @return 结果
     */
    public int updateSongCollect(SongCollect songCollect);

    /**
     * 批量删除用户收藏列
     * 
     * @param ids 需要删除的用户收藏列主键集合
     * @return 结果
     */
    public int deleteSongCollectByIds(String ids);

    /**
     * 删除用户收藏列信息
     * 
     * @param id 用户收藏列主键
     * @return 结果
     */
    public int deleteSongCollectById(Long id);
}
