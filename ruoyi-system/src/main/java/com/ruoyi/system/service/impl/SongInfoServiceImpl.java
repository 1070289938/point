package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.page.PageMethod;
import com.ruoyi.common.enums.AmountRecordEnum;
import com.ruoyi.common.exception.LogicException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.cache.UserInfoCache;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.bean.SongInfoData;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.song.BuySongPojo;
import com.ruoyi.system.domain.pojo.song.CollectSongPojo;
import com.ruoyi.system.domain.pojo.song.LikeSongPojo;
import com.ruoyi.system.domain.pojo.song.QuerySongPojo;
import com.ruoyi.system.domain.pojo.vo.SongVO;
import com.ruoyi.system.domain.pojo.vo.UserVO;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.IAmountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.service.ISongInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 歌曲详情Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Service
public class SongInfoServiceImpl implements ISongInfoService {
    @Autowired
    private SongInfoMapper songInfoMapper;
    @Autowired
    private SongCodeMapper songCodeMapper;
    @Autowired
    private UserInfoCache userInfoCache;
    @Autowired
    private SongLikeMapper songLikeMapper;
    @Autowired
    private SongDownloadMapper songDownloadMapper;
    @Autowired
    private SongCollectMapper songCollectMapper;
    @Autowired
    private IAmountRecordService amountRecordService;

    /**
     * 查询歌曲详情
     *
     * @param id 歌曲详情主键
     * @return 歌曲详情
     */
    @Override
    public SongInfo selectSongInfoById(Long id) {
        return songInfoMapper.selectSongInfoById(id.intValue());
    }

    /**
     * 查询歌曲详情列表
     *
     * @param songInfo 歌曲详情
     * @return 歌曲详情
     */
    @Override
    public List<SongInfo> selectSongInfoList(SongInfo songInfo) {
        return songInfoMapper.selectSongInfoList(songInfo);
    }

    /**
     * 新增歌曲详情
     *
     * @param songInfo 歌曲详情
     * @return 结果
     */
    @Override
    public int insertSongInfo(SongInfoData songInfo) {

        SongInfo song = new SongInfo();
        song.initialize(songInfo);
        song.setCreateTime(DateUtils.getNowDate());
        songInfoMapper.insertSongInfo(song);

        SongCode songCode = new SongCode();
        songCode.initialize(songInfo, song.getId());
        songCode.setCreateTime(DateUtils.getNowDate());
        songCodeMapper.insertSongCode(songCode);
        return 1;
    }

    /**
     * 修改歌曲详情
     *
     * @param songInfo 歌曲详情
     * @return 结果
     */
    @Override
    public int updateSongInfo(SongInfo songInfo) {
        songInfo.setUpdateTime(DateUtils.getNowDate());
        return songInfoMapper.updateSongInfo(songInfo);
    }

    /**
     * 批量删除歌曲详情
     *
     * @param ids 需要删除的歌曲详情主键
     * @return 结果
     */
    @Override
    public int deleteSongInfoByIds(String ids) {
        return songInfoMapper.deleteSongInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除歌曲详情信息
     *
     * @param id 歌曲详情主键
     * @return 结果
     */
    @Override
    public int deleteSongInfoById(Long id) {
        return songInfoMapper.deleteSongInfoById(id);
    }

    @Override
    public QuerySongPojo.OutPut querySong(ParamPojo<QuerySongPojo.Param> param) throws LogicException {

        PageMethod.startPage(param.getData().getPage(), param.getData().getSize());
        //查询歌曲
        List<SongVO> songList = songInfoMapper.selectSongVOListAll();

        List<SongVO> songVOList = new ArrayList<>();
        for (SongVO songInfo : songList) {
            //写入用户
            UserInfo userInfo = userInfoCache.getUserInfo(songInfo.getUserId());
            UserVO userVO = new UserVO() {{
                setUserName(userInfo.getUserName());
                setUserNick(userInfo.getUserNick());
                setUserHead(userInfo.getUserHead());
            }};
            //查询当前用户是否点赞歌曲
            if (param.getUserId() != null || param.getUserId() != 0) {
                SongLike isLink = songLikeMapper.selectSongLikeIsLike(param.getUserId(), songInfo.getId());
                songInfo.setIsLink(isLink == null ? 0 : 1);
                //查询用户是否已下载
                SongDownload download = songDownloadMapper.selectDownloadIsDownload(param.getUserId(), songInfo.getId());
                songInfo.setIsDownload(download == null ? 0 : 1);
                //下载了才能收藏
                if (download != null) {
                    SongCollect songCollect = songCollectMapper.selectSongCollectIsCollect(param.getUserId(), songInfo.getId());
                    songInfo.setCollect(songCollect == null ? 0 : 1);
                }

            }
            songInfo.setUserVO(userVO);
            songVOList.add(songInfo);
        }
        QuerySongPojo.OutPut outPut = new QuerySongPojo.OutPut();
        outPut.setSongVOList(songVOList);

        return outPut;

    }

    @Override
    public LikeSongPojo.OutPut likeSong(ParamPojo<LikeSongPojo.Param> param) throws LogicException {
        int songId = param.getData().getSongId();

        SongLike songLike = songLikeMapper.selectSongLikeIsLike(param.getUserId(), songId);
        if (songLike != null) {
            songLike.setDeleteTime(new Date());
            songLikeMapper.updateSongLike(songLike);
        } else {
            songLike = new SongLike();
            songLike.setSongId(songId);
            songLike.setUserId(param.getUserId());
            songLike.setCreateTime(new Date());
            songLikeMapper.insertSongLike(songLike);
        }
        int like = songLikeMapper.selectSongLikeCount(songId);
        LikeSongPojo.OutPut outPut = new LikeSongPojo.OutPut();
        outPut.setLink(like);
        return outPut;
    }

    @Override
    public CollectSongPojo.OutPut collectSong(ParamPojo<CollectSongPojo.Param> param) throws LogicException {
        int songId = param.getData().getSongId();
        CollectSongPojo.OutPut outPut = new CollectSongPojo.OutPut();
        SongCollect songCollect = songCollectMapper.selectSongCollectIsCollect(param.getUserId(), songId);
        if (songCollect != null) {
            //原来是已收藏的
            songCollect.setDeleteTime(new Date());
            songCollectMapper.updateSongCollect(songCollect);
            outPut.setCollect(0);
            return outPut;
        } else {
            songCollect = new SongCollect();
            songCollect.setSongId(songId);
            songCollect.setUserId(param.getUserId());
            songCollect.setCreateTime(new Date());
            songCollectMapper.insertSongCollect(songCollect);
            outPut.setCollect(1);
            return outPut;
        }
    }

    @Override
    public BuySongPojo.OutPut buySong(ParamPojo<BuySongPojo.Param> param) throws LogicException {
        int songId = param.getData().getSongId();
        String payPassword = param.getData().getPayPassword();
        int userId = param.getUserId();

        UserInfo userInfo = userInfoCache.getUserInfo(userId);

        if (userInfo.getPaymentCode()==null){
            throw new LogicException(LogicException.Type.PARAM_ERROR, "未设置烛火密码!");
        }

        if (!userInfo.getPaymentCode().equals(Md5Utils.hash(payPassword))) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "烛火密码错误!");
        }

        SongDownload download = songDownloadMapper.selectDownloadIsDownload(userId,songId);
        if (download!=null){
            throw new LogicException(LogicException.Type.ERROR, "无法重复购买!");
        }
        //当前用户金额
        Long money = amountRecordService.getMoney(userId);
        SongInfo songInfo = songInfoMapper.selectSongInfoById(songId);
        money = money - songInfo.getPrice();
        if (money < 0) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "烛火不足!");
        }
        amountRecordService.addAmountRecord(userId, -songInfo.getPrice(), AmountRecordEnum.BUY_SONG, "购买:" + songInfo.getName());

        download = new SongDownload();
        download.setSongId(songId);
        download.setUserId(userId);
        download.setCreateTime(new Date());
        songDownloadMapper.insertSongDownload(download);
        BuySongPojo.OutPut outPut = new BuySongPojo.OutPut();
        outPut.setMoney(money);
        return outPut;
    }

    @Override
    public QuerySongPojo.OutPut queryMySong(ParamPojo<QuerySongPojo.Param> param) throws LogicException {


        return null;
    }
}
