package com.ruoyi.system.domain.pojo.user;

import com.ruoyi.system.domain.pojo.vo.UserVO;
import lombok.Data;

/**
 * 修改个人信息对象
 */
public class EditPersonalPojo {

    @Data
    public static class Param {
        //用户头像
        private String userHead;
        //用户账号
        private String account;
        //用户昵称
        private String nickName;

    }


    @Data
    public static class OutPut {
        //新的用户对象
        private UserVO user;
    }

}
