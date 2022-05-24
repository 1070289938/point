package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.domain.pojo.user.LoginPojo;
import org.apache.ibatis.annotations.Param;

/**
 * 用户详情Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface UserInfoMapper
{
    /**
     * 查询用户详情
     *
     * @param id 用户详情主键
     * @return 用户详情
     */
    public UserInfo selectUserInfoById(int id);

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
     * 删除用户详情
     *
     * @param id 用户详情主键
     * @return 结果
     */
    public int deleteUserInfoById(Long id);

    /**
     * 批量删除用户详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserInfoByIds(String[] ids);

    /**
     * 登录用户 返回用户详情
     * @param param 账号密码对象
     * @return 用户详情
     */
    UserInfo login(LoginPojo.Param param);

    //根据手机号查询用户是否存在
    UserInfo selectUserInfoPhone(@Param("phone") String phone);

    /**
     * 根据用户名查询用户
     * @param userName 用户名
     * @return
     */
    UserInfo selectUserByUserName(@Param("userName") String userName);

    /**
     * 根据与推荐码查询用户
     * @param recommendCode 推荐码
     * @return
     */
    UserInfo selectUserByRecommendCode(@Param("recommendCode") String recommendCode);


}
