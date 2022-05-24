package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RegistrationCodeMapper;
import com.ruoyi.system.domain.RegistrationCode;
import com.ruoyi.system.service.IRegistrationCodeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 注册码绑定Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
@Service
public class RegistrationCodeServiceImpl implements IRegistrationCodeService 
{
    @Autowired
    private RegistrationCodeMapper registrationCodeMapper;

    /**
     * 查询注册码绑定
     * 
     * @param id 注册码绑定主键
     * @return 注册码绑定
     */
    @Override
    public RegistrationCode selectRegistrationCodeById(Long id)
    {
        return registrationCodeMapper.selectRegistrationCodeById(id);
    }

    /**
     * 查询注册码绑定列表
     * 
     * @param registrationCode 注册码绑定
     * @return 注册码绑定
     */
    @Override
    public List<RegistrationCode> selectRegistrationCodeList(RegistrationCode registrationCode)
    {
        return registrationCodeMapper.selectRegistrationCodeList(registrationCode);
    }

    /**
     * 新增注册码绑定
     * 
     * @param registrationCode 注册码绑定
     * @return 结果
     */
    @Override
    public int insertRegistrationCode(RegistrationCode registrationCode)
    {
        registrationCode.setCreateTime(DateUtils.getNowDate());
        return registrationCodeMapper.insertRegistrationCode(registrationCode);
    }

    /**
     * 修改注册码绑定
     * 
     * @param registrationCode 注册码绑定
     * @return 结果
     */
    @Override
    public int updateRegistrationCode(RegistrationCode registrationCode)
    {
        return registrationCodeMapper.updateRegistrationCode(registrationCode);
    }

    /**
     * 批量删除注册码绑定
     * 
     * @param ids 需要删除的注册码绑定主键
     * @return 结果
     */
    @Override
    public int deleteRegistrationCodeByIds(String ids)
    {
        return registrationCodeMapper.deleteRegistrationCodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除注册码绑定信息
     * 
     * @param id 注册码绑定主键
     * @return 结果
     */
    @Override
    public int deleteRegistrationCodeById(Long id)
    {
        return registrationCodeMapper.deleteRegistrationCodeById(id);
    }
}
