package com.ruoyi.system.domain;

import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.common.utils.uuid.IdUtils;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.rmi.server.UID;
import java.util.Date;

/**
 * 用户详情对象 user_info
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Data
public class UserInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private int id;

    /**
     * 用户名
     */
    @Excel(name = "用户名")
    private String userName;

    /**
     * 用户昵称
     */
    @Excel(name = "用户昵称")
    private String userNick;

    /**
     * 用户头像
     */
    @Excel(name = "用户头像")
    private String userHead;

    /**
     * 用户密码
     */
    @Excel(name = "用户密码")
    private String password;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String mail;

    /**
     * 手机号
     */
    @Excel(name = "手机号")
    private String phone;

    /**
     * qq号
     */
    @Excel(name = "qq号")
    private String QQ;

    /**
     * 父级推荐码
     */
    @Excel(name = "父级推荐码")
    private String parentRecommendCode;

    /**
     * 推荐码
     */
    @Excel(name = "推荐码")
    private String recommendCode;

    /**
     * 支付密码
     */
    @Excel(name = "支付密码")
    private String paymentCode;

    //初始化一个用户，注册用到
    public void initialize(String userName,String password,String recommendCode,String parentRecommendCode,String qq) {

        this.userName =userName;
        this.userNick = "无名氏";
        this.userHead = "";
        this.QQ=qq;
        this.password = Md5Utils.hash(password);
        this.recommendCode = IdUtils.fastSimpleUUID().substring(0,10);
        this.parentRecommendCode = parentRecommendCode;
        setCreateTime(new Date());
    }


}
