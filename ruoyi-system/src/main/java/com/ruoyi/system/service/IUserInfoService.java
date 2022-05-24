package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.LogicException;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.user.*;

/**
 * 用户详情Service接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface IUserInfoService
{
    /**
     * 查询用户详情
     *
     * @param id 用户详情主键
     * @return 用户详情
     */
    public UserInfo selectUserInfoById(Long id);

    /**
     * 查询用户详情列表
     *
     * @param userInfo 用户详情
     * @return 用户详情集合
     */
    public List<UserInfo> selectUserInfoList(UserInfo userInfo);

    /**
     * 新增用户详情
     *
     * @param userInfo 用户详情
     * @return 结果
     */
    public int insertUserInfo(UserInfo userInfo);

    /**
     * 修改用户详情
     *
     * @param userInfo 用户详情
     * @return 结果
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 批量删除用户详情
     *
     * @param ids 需要删除的用户详情主键集合
     * @return 结果
     */
    public int deleteUserInfoByIds(String ids);

    /**
     * 删除用户详情信息
     *
     * @param id 用户详情主键
     * @return 结果
     */
    public int deleteUserInfoById(Long id);

    //用户登录方法
    LoginPojo.OutPut login(LoginPojo.Param param) throws LogicException;

    //查询用户详情
    LoginPojo.OutPut queryUser(ParamPojo<QueryUserPojo> param) throws LogicException;

    //用户注册方法
    RegisteredPojo.OutPut registered(RegisteredPojo.Param param) throws LogicException;

    //发送验证码
    AjaxResult sendSmsCode(SendSmsCodePojo.Param param) throws LogicException;

    /**
     * 用户修改密码
     * @param param
     * @return
     */
    ChangePasswordPojo.OutPut changePassword(ChangePasswordPojo.Param param)throws LogicException;

    /**
     * 修改用户基本数据
     * @param param
     * @return
     */
    EditPersonalPojo.OutPut editPersonal(ParamPojo<EditPersonalPojo.Param> param)throws LogicException;

    /**
     * 判断是否设置支付密码
     * @param param
     * @return
     */
    Integer isPayPassword(ParamPojo<Object> param);


}
