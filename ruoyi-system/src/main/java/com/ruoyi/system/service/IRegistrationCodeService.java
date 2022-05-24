package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RegistrationCode;

/**
 * 注册码绑定Service接口
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
public interface IRegistrationCodeService 
{
    /**
     * 查询注册码绑定
     * 
     * @param id 注册码绑定主键
     * @return 注册码绑定
     */
    public RegistrationCode selectRegistrationCodeById(Long id);

    /**
     * 查询注册码绑定列表
     * 
     * @param registrationCode 注册码绑定
     * @return 注册码绑定集合
     */
    public List<RegistrationCode> selectRegistrationCodeList(RegistrationCode registrationCode);

    /**
     * 新增注册码绑定
     * 
     * @param registrationCode 注册码绑定
     * @return 结果
     */
    public int insertRegistrationCode(RegistrationCode registrationCode);

    /**
     * 修改注册码绑定
     * 
     * @param registrationCode 注册码绑定
     * @return 结果
     */
    public int updateRegistrationCode(RegistrationCode registrationCode);

    /**
     * 批量删除注册码绑定
     * 
     * @param ids 需要删除的注册码绑定主键集合
     * @return 结果
     */
    public int deleteRegistrationCodeByIds(String ids);

    /**
     * 删除注册码绑定信息
     * 
     * @param id 注册码绑定主键
     * @return 结果
     */
    public int deleteRegistrationCodeById(Long id);
}
