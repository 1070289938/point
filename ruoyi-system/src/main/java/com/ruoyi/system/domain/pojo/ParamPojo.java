package com.ruoyi.system.domain.pojo;

import lombok.Data;

@Data
public class ParamPojo<T> {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * token
     */
    private String token;

    /**
     * 内容
     */
    private T data;



}
