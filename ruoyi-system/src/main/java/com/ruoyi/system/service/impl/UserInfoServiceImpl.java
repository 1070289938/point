package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.AmountRecordEnum;
import com.ruoyi.common.exception.LogicException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.system.cache.SmsCodeCache;
import com.ruoyi.system.cache.UserInfoCache;
import com.ruoyi.system.cache.UserTokenCache;
import com.ruoyi.system.domain.RegistrationCode;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.user.*;
import com.ruoyi.system.domain.pojo.vo.UserVO;
import com.ruoyi.system.mapper.RegistrationCodeMapper;
import com.ruoyi.system.service.IAmountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserInfoMapper;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.service.IUserInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户详情Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserTokenCache userTokenCache;
    @Autowired
    private SmsCodeCache smsCodeCache;
    @Autowired
    private UserInfoCache userInfoCache;
    @Autowired
    private RegistrationCodeMapper registrationCodeMapper;
    @Autowired
    private IAmountRecordService amountRecordService;

    /**
     * 查询用户详情
     *
     * @param id 用户详情主键
     * @return 用户详情
     */
    @Override
    public UserInfo selectUserInfoById(Long id) {
        return userInfoMapper.selectUserInfoById(Math.toIntExact(id));
    }

    /**
     * 查询用户详情列表
     *
     * @param userInfo 用户详情
     * @return 用户详情
     */
    @Override
    public List<UserInfo> selectUserInfoList(UserInfo userInfo) {
        return userInfoMapper.selectUserInfoList(userInfo);
    }

    /**
     * 新增用户详情
     *
     * @param userInfo 用户详情
     * @return 结果
     */
    @Override
    public int insertUserInfo(UserInfo userInfo) {
        userInfo.setCreateTime(DateUtils.getNowDate());
        return userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 修改用户详情
     *
     * @param userInfo 用户详情
     * @return 结果
     */
    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * 批量删除用户详情
     *
     * @param ids 需要删除的用户详情主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByIds(String ids) {
        return userInfoMapper.deleteUserInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户详情信息
     *
     * @param id 用户详情主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoById(Long id) {
        return userInfoMapper.deleteUserInfoById(id);
    }

    /**
     * 登录用户
     *
     * @param param
     * @return
     */
    @Override
    public LoginPojo.OutPut login(LoginPojo.Param param) throws LogicException {

        if (StringUtils.isEmpty(param.getAccount())) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "请输入账号");
        }
        if (StringUtils.isEmpty(param.getPassword())) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "请输入密码");
        }

        //密码进行md5 hash加密
        param.setPassword(Md5Utils.hash(param.getPassword()));
        UserInfo userInfo = userInfoMapper.login(param);
        if (userInfo == null) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "用户名密码错误");
        }
        //更新token
        String token = userTokenCache.updateToken(userInfo);

        return new LoginPojo.OutPut(token, userInfo);
    }

    /**
     * 用户登录
     *
     * @param param
     * @return
     */
    @Override
    public LoginPojo.OutPut queryUser(ParamPojo<QueryUserPojo> param) throws LogicException {
        if (!userTokenCache.isToken(param.getUserId(), param.getToken())) {
            return null;
        }
        UserInfo info = userInfoMapper.selectUserInfoById(param.getUserId());
        return new LoginPojo.OutPut(param.getToken(), info);
    }


    @Override
    public RegisteredPojo.OutPut registered(RegisteredPojo.Param param) throws LogicException {

        if (!param.getAccount().matches("^[A-Za-z0-9]+$")) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "账号只能由字母或数字组成!");
        }

        //判断账号是否存在
        UserInfo userInfo = userInfoMapper.selectUserByUserName(param.getAccount());

        if (userInfo != null) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "这个账号已经被注册过啦!");
        }
        //判断注册码是否正确
        RegistrationCode code = registrationCodeMapper.selectRegistrationCodeByCode(param.getCode());

        if (code == null) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "注册码不存在!");
        }

        if (code.getUserId() != null) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "注册码已被使用!");
        }


        userInfo = new UserInfo();
        String recommendCode = "null";
        userInfo.initialize(param.getAccount(), param.getPassword(), recommendCode, param.getParentRecommendCode(), code.getQq());
        userInfoMapper.insertUserInfo(userInfo);
        code.setUserId(userInfo.getId());
        code.setHoursUse(new Date());
        registrationCodeMapper.updateRegistrationCode(code);
        UserVO userVO = UserVO.getUserVo(userInfo);
        String token = userTokenCache.updateToken(userInfo);

        return new RegisteredPojo.OutPut(userVO, token, userInfo.getId());
    }

    @Override
    public AjaxResult sendSmsCode(SendSmsCodePojo.Param param) throws LogicException {
        Integer code = (int) (Math.random() * 9000) + 1000;
        smsCodeCache.setCode(param.getPhone(), code.toString(), 60L * 5);

        return AjaxResult.success();
    }

    @Override
    public ChangePasswordPojo.OutPut changePassword(ChangePasswordPojo.Param param) throws LogicException {

        //判断账号是否存在
        UserInfo userInfo = userInfoMapper.selectUserInfoPhone(param.getPhone());
        if (userInfo == null) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "账号不存在!");
        }

        String code = smsCodeCache.getCode(userInfo.getPhone());
        if (!param.getCode().equals(code)) {
            throw new LogicException(LogicException.Type.PARAM_ERROR, "验证码错误!");
        }

        //更改密码
        userInfo.setPassword(Md5Utils.hash(param.getPassword()));
        userInfoCache.updateUserInfo(userInfo);

        return new ChangePasswordPojo.OutPut();
    }

    @Override
    public EditPersonalPojo.OutPut editPersonal(ParamPojo<EditPersonalPojo.Param> param) throws LogicException {

        UserInfo userInfo = userInfoCache.getUserInfo(param.getUserId());
        EditPersonalPojo.Param newData = param.getData();
        if (!StringUtils.isEmpty(newData.getUserHead())) {
            userInfo.setUserHead(newData.getUserHead());
        }
        if (!StringUtils.isEmpty(newData.getAccount())) {
            if (!newData.getAccount().matches("^[A-Za-z0-9]+$")) {
                throw new LogicException(LogicException.Type.PARAM_ERROR, "账号只能由字母或数字组成!");
            }
            if (userInfo.getChangeAccount() == 0) {
                throw new LogicException(LogicException.Type.ERROR, "账号只能修改一次!");
            }
            if (userInfoMapper.selectUserByUserName(newData.getAccount()) != null) {
                throw new LogicException(LogicException.Type.PARAM_ERROR, "这个账号已经被注册过啦!");
            }

            userInfo.setUserName(newData.getAccount());
            userInfo.setChangeAccount(0);
        }
        if (!StringUtils.isEmpty(newData.getNickName())) {
            userInfo.setUserNick(newData.getNickName());
        }
        userInfoCache.updateUserInfo(userInfo);
        EditPersonalPojo.OutPut outPut = new EditPersonalPojo.OutPut() {{
            setUser(UserVO.getUserVo(userInfo));
        }};
        return outPut;
    }

    @Override
    public Integer isPayPassword(ParamPojo<Object> param) {

        UserInfo userInfo = userInfoCache.getUserInfo(param.getUserId());
        if (StringUtils.isEmpty(userInfo.getPaymentCode())) {
            return 0;
        }
        return 1;
    }


}
