package com.ruoyi.system.domain.pojo.user;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.vo.UserVO;
import lombok.Data;

/**
 * 登录参数
 */
public class LoginPojo{

    /**
     * 传入参数
     */
    @Data
    public static class Param {
        /**
         * 账号
         */
        private String account;
        /**
         * 密码
         */
        private String password;

    }

    /**
     * 返回参数
     */
    @Data
    public static class OutPut {

        /**
         * 用户id
         */
        private int userId;
        /**
         * 用户token
         */
        private String token;
        /**
         * 用户对外对象
         */
        private UserVO userVO;


        public OutPut(String token, UserInfo info) {
            this.userId = info.getId();
            this.token = token;
            this.userVO = UserVO.getUserVo(info);
        }
    }


}
