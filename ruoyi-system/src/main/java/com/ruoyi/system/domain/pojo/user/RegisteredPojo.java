package com.ruoyi.system.domain.pojo.user;

import com.ruoyi.system.domain.pojo.vo.UserVO;
import lombok.Data;

public class RegisteredPojo {
    @Data
    public static class Param {
        //手机号
        private String account;
        //密码
        private String password;
        //验证码
        private String code;
        //邀请码
        private String parentRecommendCode;

    }

    @Data
    public static class OutPut {

        private UserVO user;

        private String token;

        private Integer userId;
        public OutPut(UserVO userVO,String token,Integer userId){
            this.user=userVO;
            this.token=token;
            this.userId = userId;
        }

    }

}
