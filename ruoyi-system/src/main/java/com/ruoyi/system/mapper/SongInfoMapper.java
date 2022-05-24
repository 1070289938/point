package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SongInfo;
import com.ruoyi.system.domain.pojo.vo.SongVO;

/**
 * 歌曲详情Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface SongInfoMapper
{
    /**
     * 查询歌曲详情
     *
     * @param id 歌曲详情主键
     * @return 歌曲详情
     */
    public SongInfo selectSongInfoById(Integer id);

    /**
     * 查询歌曲详情列表
     *
     * @param songInfo 歌曲详情
     * @return 歌曲详情集合
     */
    public List<SongInfo> selectSongInfoList(SongInfo songInfo);

    /**
     * 新增歌曲详情
     *
     * @param songInfo 歌曲详情
     * @return 结果
     */
    public int insertSongInfo(SongInfo songInfo);

    /**
     * 修改歌曲详情
     *
     * @param songInfo 歌曲详情
     * @return 结果
     */
    public int updateSongInfo(SongInfo songInfo);

    /**
     * 删除歌曲详情
     *
     * @param id 歌曲详情主键
     * @return 结果
     */
    public int deleteSongInfoById(Long id);

    /**
     * 批量删除歌曲详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSongInfoByIds(String[] ids);

    /**
     * 查询歌曲vo详情
     * @param songInfo
     * @return
     */
    List<SongVO> selectSongVOListAll();

}