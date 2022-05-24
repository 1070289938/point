package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.LogicException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.cache.KeyLocationCache;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.user.GetUserKeyPojo;
import com.ruoyi.system.domain.pojo.user.SetUserKeyPojo;
import com.ruoyi.system.domain.pojo.vo.KeyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.KeyLocationMapper;
import com.ruoyi.system.domain.KeyLocation;
import com.ruoyi.system.service.IKeyLocationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 键位Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-18
 */
@Service
public class KeyLocationServiceImpl implements IKeyLocationService {
    @Autowired
    private KeyLocationMapper keyLocationMapper;
    @Autowired
    private KeyLocationCache keyLocationCache;

    /**
     * 查询键位
     *
     * @param id 键位主键
     * @return 键位
     */
    @Override
    public KeyLocation selectKeyLocationById(Integer id) {
        return keyLocationMapper.selectKeyLocationById(id);
    }

    /**
     * 查询键位列表
     *
     * @param keyLocation 键位
     * @return 键位
     */
    @Override
    public List<KeyLocation> selectKeyLocationList(KeyLocation keyLocation) {
        return keyLocationMapper.selectKeyLocationList(keyLocation);
    }

    /**
     * 新增键位
     *
     * @param keyLocation 键位
     * @return 结果
     */
    @Override
    public int insertKeyLocation(KeyLocation keyLocation) {
        keyLocation.setCreateTime(DateUtils.getNowDate());
        return keyLocationMapper.insertKeyLocation(keyLocation);
    }

    /**
     * 修改键位
     *
     * @param keyLocation 键位
     * @return 结果
     */
    @Override
    public int updateKeyLocation(KeyLocation keyLocation) {
        keyLocation.setUpdateTime(DateUtils.getNowDate());
        return keyLocationMapper.updateKeyLocation(keyLocation);
    }

    /**
     * 批量删除键位
     *
     * @param ids 需要删除的键位主键
     * @return 结果
     */
    @Override
    public int deleteKeyLocationByIds(String ids) {
        return keyLocationMapper.deleteKeyLocationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除键位信息
     *
     * @param id 键位主键
     * @return 结果
     */
    @Override
    public int deleteKeyLocationById(Integer id) {
        return keyLocationMapper.deleteKeyLocationById(id);
    }

    @Override
    public GetUserKeyPojo.OutPut getUserKey(ParamPojo<GetUserKeyPojo.Param> param) throws LogicException {
        Map<String, KeyLocation> map = keyLocationCache.getKeyLocations(param.getUserId());
        GetUserKeyPojo.OutPut outPut = new GetUserKeyPojo.OutPut();
        outPut.setMap(KeyVO.iniKeyVoMap(map));
        return outPut;
    }

    @Override
    public GetUserKeyPojo.OutPut setUserKey(ParamPojo<SetUserKeyPojo.Param> param) throws LogicException {
        keyLocationCache.updateKeyLocations(param.getUserId(), param.getData().getMap());
        return new GetUserKeyPojo.OutPut();
    }
}
