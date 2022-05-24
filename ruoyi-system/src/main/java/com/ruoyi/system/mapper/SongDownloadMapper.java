package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SongDownload;
import org.apache.ibatis.annotations.Param;

/**
 * 歌曲下载Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface SongDownloadMapper
{
    /**
     * 查询歌曲下载
     *
     * @param id 歌曲下载主键
     * @return 歌曲下载
     */
    public SongDownload selectSongDownloadById(Long id);

    /**
     * 查询歌曲下载列表
     *
     * @param songDownload 歌曲下载
     * @return 歌曲下载集合
     */
    public List<SongDownload> selectSongDownloadList(SongDownload songDownload);

    /**
     * 新增歌曲下载
     *
     * @param songDownload 歌曲下载
     * @return 结果
     */
    public int insertSongDownload(SongDownload songDownload);

    /**
     * 修改歌曲下载
     *
     * @param songDownload 歌曲下载
     * @return 结果
     */
    public int updateSongDownload(SongDownload songDownload);

    /**
     * 删除歌曲下载
     *
     * @param id 歌曲下载主键
     * @return 结果
     */
    public int deleteSongDownloadById(Long id);

    /**
     * 批量删除歌曲下载
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSongDownloadByIds(String[] ids);

    /**
     * 查询歌曲下载数量
     * @param id
     * @return
     */
    int selectDownloadCount(@Param("id") Long id);

    /**
     * 查询用户是否下载此歌曲
     * @param userId
     * @param id
     * @return
     */
    SongDownload selectDownloadIsDownload(@Param("userId") Integer userId,@Param("songId") int id);

}
