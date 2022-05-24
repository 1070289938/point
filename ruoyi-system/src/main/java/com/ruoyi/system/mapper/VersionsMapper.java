package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Versions;

/**
 * 版本管理器Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-20
 */
public interface VersionsMapper
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
     * 删除版本管理器
     *
     * @param id 版本管理器主键
     * @return 结果
     */
    public int deleteVersionsById(Long id);

    /**
     * 批量删除版本管理器
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVersionsByIds(String[] ids);

    Versions selectVersionsByNew();


}
