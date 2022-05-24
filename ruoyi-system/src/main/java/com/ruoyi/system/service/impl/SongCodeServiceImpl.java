package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SongCodeMapper;
import com.ruoyi.system.domain.SongCode;
import com.ruoyi.system.service.ISongCodeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 歌曲代码Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
@Service
public class SongCodeServiceImpl implements ISongCodeService 
{
    @Autowired
    private SongCodeMapper songCodeMapper;

    /**
     * 查询歌曲代码
     * 
     * @param id 歌曲代码主键
     * @return 歌曲代码
     */
    @Override
    public SongCode selectSongCodeById(Long id)
    {
        return songCodeMapper.selectSongCodeById(id);
    }

    /**
     * 查询歌曲代码列表
     * 
     * @param songCode 歌曲代码
     * @return 歌曲代码
     */
    @Override
    public List<SongCode> selectSongCodeList(SongCode songCode)
    {
        return songCodeMapper.selectSongCodeList(songCode);
    }

    /**
     * 新增歌曲代码
     * 
     * @param songCode 歌曲代码
     * @return 结果
     */
    @Override
    public int insertSongCode(SongCode songCode)
    {
        songCode.setCreateTime(DateUtils.getNowDate());
        return songCodeMapper.insertSongCode(songCode);
    }

    /**
     * 修改歌曲代码
     * 
     * @param songCode 歌曲代码
     * @return 结果
     */
    @Override
    public int updateSongCode(SongCode songCode)
    {
        songCode.setUpdateTime(DateUtils.getNowDate());
        return songCodeMapper.updateSongCode(songCode);
    }

    /**
     * 批量删除歌曲代码
     * 
     * @param ids 需要删除的歌曲代码主键
     * @return 结果
     */
    @Override
    public int deleteSongCodeByIds(String ids)
    {
        return songCodeMapper.deleteSongCodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除歌曲代码信息
     * 
     * @param id 歌曲代码主键
     * @return 结果
     */
    @Override
    public int deleteSongCodeById(Long id)
    {
        return songCodeMapper.deleteSongCodeById(id);
    }
}
