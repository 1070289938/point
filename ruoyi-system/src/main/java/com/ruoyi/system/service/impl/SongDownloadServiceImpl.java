package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SongDownloadMapper;
import com.ruoyi.system.domain.SongDownload;
import com.ruoyi.system.service.ISongDownloadService;
import com.ruoyi.common.core.text.Convert;

/**
 * 歌曲下载Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
@Service
public class SongDownloadServiceImpl implements ISongDownloadService 
{
    @Autowired
    private SongDownloadMapper songDownloadMapper;

    /**
     * 查询歌曲下载
     * 
     * @param id 歌曲下载主键
     * @return 歌曲下载
     */
    @Override
    public SongDownload selectSongDownloadById(Long id)
    {
        return songDownloadMapper.selectSongDownloadById(id);
    }

    /**
     * 查询歌曲下载列表
     * 
     * @param songDownload 歌曲下载
     * @return 歌曲下载
     */
    @Override
    public List<SongDownload> selectSongDownloadList(SongDownload songDownload)
    {
        return songDownloadMapper.selectSongDownloadList(songDownload);
    }

    /**
     * 新增歌曲下载
     * 
     * @param songDownload 歌曲下载
     * @return 结果
     */
    @Override
    public int insertSongDownload(SongDownload songDownload)
    {
        songDownload.setCreateTime(DateUtils.getNowDate());
        return songDownloadMapper.insertSongDownload(songDownload);
    }

    /**
     * 修改歌曲下载
     * 
     * @param songDownload 歌曲下载
     * @return 结果
     */
    @Override
    public int updateSongDownload(SongDownload songDownload)
    {
        return songDownloadMapper.updateSongDownload(songDownload);
    }

    /**
     * 批量删除歌曲下载
     * 
     * @param ids 需要删除的歌曲下载主键
     * @return 结果
     */
    @Override
    public int deleteSongDownloadByIds(String ids)
    {
        return songDownloadMapper.deleteSongDownloadByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除歌曲下载信息
     * 
     * @param id 歌曲下载主键
     * @return 结果
     */
    @Override
    public int deleteSongDownloadById(Long id)
    {
        return songDownloadMapper.deleteSongDownloadById(id);
    }
}
