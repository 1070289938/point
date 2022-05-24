package com.ruoyi.web.controller.app;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.annotation.RequestLimits;
import com.ruoyi.common.annotation.TokenCheck;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.LogicException;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.song.QuerySongPojo;
import com.ruoyi.system.domain.pojo.user.*;
import com.ruoyi.system.service.IAmountRecordService;
import com.ruoyi.system.service.IKeyLocationService;
import com.ruoyi.system.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/user")
public class UserController {
    /**
     * 用户实现类
     */
    @Autowired
    private IUserInfoService userInfoService;
    /**
     * 键位实现类
     */
    @Autowired
    private IKeyLocationService keyLocationService;

    /**
     * 金额记录实现类
     */
    @Autowired
    private IAmountRecordService amountRecordService;


    /**
     * 发送验证码
     *
     * @param param 传入参数
     * @return 返回用户内容
     */
    @PostMapping("sendSmsCode")
    @RequestLimits(t = 10, count = 1)
    public AjaxResult sendSmsCode(@RequestBody SendSmsCodePojo.Param param) {
        try {
            return userInfoService.sendSmsCode(param);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }


    /**
     * 用户注册
     *
     * @param param 传入参数
     * @return 返回用户内容
     */
    @PostMapping("registered")
    @RequestLimits(t = 10, count = 10)
    public AjaxResult registered(@RequestBody RegisteredPojo.Param param) {
        try {
            RegisteredPojo.OutPut outPut = userInfoService.registered(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 用户修改密码
     *
     * @param param
     * @return
     */
    @PostMapping("changePassword")
    @RequestLimits(t = 10, count = 10)
    public AjaxResult changePassword(@RequestBody ChangePasswordPojo.Param param) {
        try {
            ChangePasswordPojo.OutPut outPut = userInfoService.changePassword(param);
            return AjaxResult.success();
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }


    /**
     * 用户登录
     *
     * @param param 传入参数
     * @return 返回用户内容
     */
    @PostMapping("login")
    @RequestLimits(t = 10, count = 10)
    public AjaxResult login(@RequestBody LoginPojo.Param param) {
        try {
            LoginPojo.OutPut outPut = userInfoService.login(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 查询用户
     *
     * @param param
     * @return
     */
    @PostMapping("query/user")
    @RequestLimits(t = 10, count = 10)
    public AjaxResult queryUser(@RequestBody ParamPojo<QueryUserPojo> param) {
        try {
            if (param == null) {
                return AjaxResult.error(401, "登录状态过期");
            }
            if (param.getToken() == null) {
                return AjaxResult.error(401, "登录状态过期");
            }
            if (param.getUserId() == null) {
                return AjaxResult.error(401, "登录状态过期");
            }
            LoginPojo.OutPut outPut = userInfoService.queryUser(param);
            if (outPut == null) {
                return AjaxResult.error(401, "登录状态过期");
            }
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 修改用户基本信息
     *
     * @param param
     * @return
     */
    @PostMapping("edit/personal")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult editPersonal(@RequestBody ParamPojo<EditPersonalPojo.Param> param) {
        try {
            EditPersonalPojo.OutPut outPut = userInfoService.editPersonal(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 用户获取键位
     *
     * @param param
     * @return
     */
    @PostMapping("get/user/key")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult getUserKey(@RequestBody ParamPojo<GetUserKeyPojo.Param> param) {
        try {
            GetUserKeyPojo.OutPut outPut = keyLocationService.getUserKey(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 用户设置键位
     *
     * @param param
     * @return
     */
    @PostMapping("set/user/key")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult setUserKey(@RequestBody ParamPojo<SetUserKeyPojo.Param> param) {
        try {
            GetUserKeyPojo.OutPut outPut = keyLocationService.setUserKey(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 获取用户金额
     *
     * @param param
     * @return
     */
    @PostMapping("get/money")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult getMoney(@RequestBody ParamPojo<Object> param) {
        Long money = amountRecordService.getMoney(param.getUserId());
        return AjaxResult.success(money);
    }

    /**
     * 获取零钱记录
     * @param param
     * @return
     */
    @PostMapping("get/money/record")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult getMoneyRecord(@RequestBody ParamPojo<GetMoneyRecordPojo.Param> param) {
        try {
            GetMoneyRecordPojo.OutPut outPut = amountRecordService.getMoneyRecordList(param);
            return AjaxResult.success(outPut);
        } catch (LogicException e) {
            return AjaxResult.error(e.getCode(), e.getMessage());
        }
    }

    /**
     * 判断是否设置支付密码
     * @param param
     * @return
     */
    @PostMapping("isPayPassword")
    @RequestLimits(t = 10, count = 10)
    @TokenCheck
    public AjaxResult isPayPassword(@RequestBody ParamPojo<Object> param){
        return AjaxResult.success(userInfoService.isPayPassword(param));
    }










}
