package com.ruoyi.system.domain.pojo.user;

import lombok.Data;

public class SendSmsCodePojo {
    @Data
    public static class Param {
        //手机号
        private String phone;
    }

}
