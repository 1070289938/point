package com.ruoyi.system.domain.pojo.versions;

import com.ruoyi.system.domain.Versions;
import lombok.Data;

public class GetThisVersionPojo {
    @Data
    public static class OutPut{
        /**
         * 当前版本
         */
        private Versions versions;


    }

}
