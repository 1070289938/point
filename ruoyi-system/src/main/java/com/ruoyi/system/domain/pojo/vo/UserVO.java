package com.ruoyi.system.domain.pojo.vo;

import com.ruoyi.system.domain.UserInfo;
import lombok.Data;

@Data
public class UserVO {
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String userNick;
    /**
     * 剩余更改账号次数
     */
    private Integer changeAccount;
    /**
     * 用户头像
     */
    private String userHead;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 手机号
     */
    private String phone;

    /**
     * qq号
     */
    private String QQ;
    /**
     * 推荐码
     */
    private String recommendCode;

    public static UserVO getUserVo(UserInfo info) {
        UserVO userVO = new UserVO();
        userVO.setUserName(info.getUserName());
        userVO.setUserNick(info.getUserNick());
        userVO.setUserHead(info.getUserHead());
        userVO.setMail(info.getMail());
        userVO.setPhone(info.getPhone());
        userVO.setQQ(info.getQQ());
        userVO.setRecommendCode(info.getRecommendCode());
        userVO.setChangeAccount(info.getChangeAccount());
        return userVO;
    }


}
