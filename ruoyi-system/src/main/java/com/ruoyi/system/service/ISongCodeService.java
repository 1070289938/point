package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SongCode;

/**
 * 歌曲代码Service接口
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
public interface ISongCodeService 
{
    /**
     * 查询歌曲代码
     * 
     * @param id 歌曲代码主键
     * @return 歌曲代码
     */
    public SongCode selectSongCodeById(Long id);

    /**
     * 查询歌曲代码列表
     * 
     * @param songCode 歌曲代码
     * @return 歌曲代码集合
     */
    public List<SongCode> selectSongCodeList(SongCode songCode);

    /**
     * 新增歌曲代码
     * 
     * @param songCode 歌曲代码
     * @return 结果
     */
    public int insertSongCode(SongCode songCode);

    /**
     * 修改歌曲代码
     * 
     * @param songCode 歌曲代码
     * @return 结果
     */
    public int updateSongCode(SongCode songCode);

    /**
     * 批量删除歌曲代码
     * 
     * @param ids 需要删除的歌曲代码主键集合
     * @return 结果
     */
    public int deleteSongCodeByIds(String ids);

    /**
     * 删除歌曲代码信息
     * 
     * @param id 歌曲代码主键
     * @return 结果
     */
    public int deleteSongCodeById(Long id);
}
