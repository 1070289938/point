package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RegistrationCode;
import org.apache.ibatis.annotations.Param;

/**
 * 注册码绑定Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-20
 */
public interface RegistrationCodeMapper
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
     * 删除注册码绑定
     *
     * @param id 注册码绑定主键
     * @return 结果
     */
    public int deleteRegistrationCodeById(Long id);

    /**
     * 批量删除注册码绑定
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRegistrationCodeByIds(String[] ids);

    /**
     * 获取注册码对象
     * @param code
     * @return
     */
    RegistrationCode selectRegistrationCodeByCode(@Param("code") String code);

}
