package com.ruoyi.system.domain.pojo.user;


import lombok.Data;

public class ChangePasswordPojo {

    @Data
    public static class Param{
        //手机号
        private String phone;
        //短信验证码
        private String code;
        //密码
        private String password;

    }

    @Data
    public static class OutPut{

    }


}
