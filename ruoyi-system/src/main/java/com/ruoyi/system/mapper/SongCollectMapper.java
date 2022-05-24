package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SongCollect;
import org.apache.ibatis.annotations.Param;

/**
 * 用户收藏列Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-23
 */
public interface SongCollectMapper
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
     * 删除用户收藏列
     *
     * @param id 用户收藏列主键
     * @return 结果
     */
    public int deleteSongCollectById(Long id);

    /**
     * 批量删除用户收藏列
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSongCollectByIds(String[] ids);

    /**
     * 查询用户是否已收藏
     * @param userId
     * @param id
     * @return
     */
    SongCollect selectSongCollectIsCollect(@Param("userId") Integer userId,@Param("songId") int songId);

}
