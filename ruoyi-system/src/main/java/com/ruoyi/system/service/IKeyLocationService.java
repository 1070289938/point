package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.exception.LogicException;
import com.ruoyi.system.domain.KeyLocation;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.user.GetUserKeyPojo;
import com.ruoyi.system.domain.pojo.user.SetUserKeyPojo;

/**
 * 键位Service接口
 *
 * @author ruoyi
 * @date 2022-05-18
 */
public interface IKeyLocationService
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
     * 批量删除键位
     *
     * @param ids 需要删除的键位主键集合
     * @return 结果
     */
    public int deleteKeyLocationByIds(String ids);

    /**
     * 删除键位信息
     *
     * @param id 键位主键
     * @return 结果
     */
    public int deleteKeyLocationById(Integer id);

    /**
     * 获取用户键位
     * @param param
     * @return
     */
    GetUserKeyPojo.OutPut getUserKey(ParamPojo<GetUserKeyPojo.Param> param)throws LogicException;

    /**
     * 设置用户键位
     * @param param
     * @return
     */
    GetUserKeyPojo.OutPut setUserKey(ParamPojo<SetUserKeyPojo.Param> param)throws LogicException;

}
