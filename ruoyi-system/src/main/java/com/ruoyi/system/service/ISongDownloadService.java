package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SongDownload;

/**
 * 歌曲下载Service接口
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
public interface ISongDownloadService 
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
     * 批量删除歌曲下载
     * 
     * @param ids 需要删除的歌曲下载主键集合
     * @return 结果
     */
    public int deleteSongDownloadByIds(String ids);

    /**
     * 删除歌曲下载信息
     * 
     * @param id 歌曲下载主键
     * @return 结果
     */
    public int deleteSongDownloadById(Long id);
}
