package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.pojo.versions.GetThisVersionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VersionsMapper;
import com.ruoyi.system.domain.Versions;
import com.ruoyi.system.service.IVersionsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 版本管理器Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-20
 */
@Service
public class VersionsServiceImpl implements IVersionsService {
    @Autowired
    private VersionsMapper versionsMapper;

    /**
     * 查询版本管理器
     *
     * @param id 版本管理器主键
     * @return 版本管理器
     */
    @Override
    public Versions selectVersionsById(Long id) {
        return versionsMapper.selectVersionsById(id);
    }

    /**
     * 查询版本管理器列表
     *
     * @param versions 版本管理器
     * @return 版本管理器
     */
    @Override
    public List<Versions> selectVersionsList(Versions versions) {
        return versionsMapper.selectVersionsList(versions);
    }

    /**
     * 新增版本管理器
     *
     * @param versions 版本管理器
     * @return 结果
     */
    @Override
    public int insertVersions(Versions versions) {
        return versionsMapper.insertVersions(versions);
    }

    /**
     * 修改版本管理器
     *
     * @param versions 版本管理器
     * @return 结果
     */
    @Override
    public int updateVersions(Versions versions) {
        return versionsMapper.updateVersions(versions);
    }

    /**
     * 批量删除版本管理器
     *
     * @param ids 需要删除的版本管理器主键
     * @return 结果
     */
    @Override
    public int deleteVersionsByIds(String ids) {
        return versionsMapper.deleteVersionsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除版本管理器信息
     *
     * @param id 版本管理器主键
     * @return 结果
     */
    @Override
    public int deleteVersionsById(Long id) {
        return versionsMapper.deleteVersionsById(id);
    }

    @Override
    public GetThisVersionPojo.OutPut getThisVersion() {
        Versions versions = versionsMapper.selectVersionsByNew();
        GetThisVersionPojo.OutPut outPut = new GetThisVersionPojo.OutPut();
        outPut.setVersions(versions);
        return outPut;
    }
}
