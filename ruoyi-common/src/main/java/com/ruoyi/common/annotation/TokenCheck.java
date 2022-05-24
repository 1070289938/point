package com.ruoyi.common.annotation;

import java.lang.annotation.*;

/**
 * 校验用户id与token
 * 实现类:{@link com.tengxin.interceptor.tokencheck.TokenCheckAspect}
 */
@Documented
@Inherited
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {

}
