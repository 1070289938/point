package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.KeyLocation;
import org.apache.ibatis.annotations.Param;

/**
 * 键位Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-18
 */
public interface KeyLocationMapper
{
    /**
     * 查询键位
     *
     * @param id 键位主键
     * @return 键位
     */
    public KeyLocation selectKeyLocationById(Integer id);

    /**
     * 查询键位列表
     *
     * @param keyLocation 键位
     * @return 键位集合
     */
    public List<KeyLocation> selectKeyLocationList(KeyLocation keyLocation);

    /**
     * 新增键位
     *
     * @param keyLocation 键位
     * @return 结果
     */
    public int insertKeyLocation(KeyLocation keyLocation);

    /**
     * 修改键位
     *
     * @param keyLocation 键位
     * @return 结果
     */
    public int updateKeyLocation(KeyLocation keyLocation);

    /**
     * 删除键位
     *
     * @param id 键位主键
     * @return 结果
     */
    public int deleteKeyLocationById(Integer id);

    /**
     * 批量删除键位
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKeyLocationByIds(String[] ids);

    //在数据库根据用户id查询键位
    List<KeyLocation> selectKeyLocationListByUserId(@Param("userId") Integer userId);


}
