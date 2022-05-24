package com.ruoyi.common.exception;

import com.alibaba.fastjson.JSONObject;

public class LogicException extends Throwable {

    public enum Type {

        /**
         * 成功
         */
        SUCCESS(0, "成功"),
        /**
         * 参数错误
         */
        PARAM_ERROR(403, "参数错误"),

        /**
         * 错误
         */
        ERROR(500, "系统错误");

        private final int value;
        private final String remark;

        Type(int value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public int value() {
            return this.value;
        }

        public String getRemark() {
            return remark;
        }
    }


    private Integer code = 500;

    private Object data;

    public LogicException(String msg) {
        super(msg);
    }

    public LogicException(LogicException.Type type, String msg) {
        super(msg);
        this.code = type.value;
    }

    public LogicException(LogicException.Type type) {
        super(type.remark);
        this.code = type.value;
    }

    public LogicException(LogicException.Type type, String msg, Object data) {
        super(msg);
        this.code = type.value;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public <T> T getData(Class<T> clazz) {
        return JSONObject.parseObject(JSONObject.toJSONString(data), clazz);
    }

    public Object getData() {
        return data;
    }
}
