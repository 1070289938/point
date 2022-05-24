package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Versions;
import com.ruoyi.system.domain.pojo.versions.GetThisVersionPojo;

/**
 * 版本管理器Service接口
 *
 * @author ruoyi
 * @date 2022-05-20
 */
public interface IVersionsService
{
    /**
     * 查询版本管理器
     *
     * @param id 版本管理器主键
     * @return 版本管理器
     */
    public Versions selectVersionsById(Long id);

    /**
     * 查询版本管理器列表
     *
     * @param versions 版本管理器
     * @return 版本管理器集合
     */
    public List<Versions> selectVersionsList(Versions versions);

    /**
     * 新增版本管理器
     *
     * @param versions 版本管理器
     * @return 结果
     */
    public int insertVersions(Versions versions);

    /**
     * 修改版本管理器
     *
     * @param versions 版本管理器
     * @return 结果
     */
    public int updateVersions(Versions versions);

    /**
     * 批量删除版本管理器
     *
     * @param ids 需要删除的版本管理器主键集合
     * @return 结果
     */
    public int deleteVersionsByIds(String ids);

    /**
     * 删除版本管理器信息
     *
     * @param id 版本管理器主键
     * @return 结果
     */
    public int deleteVersionsById(Long id);

    GetThisVersionPojo.OutPut getThisVersion();


}
