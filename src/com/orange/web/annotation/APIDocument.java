/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author lining
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface APIDocument {
    String name();
    /**
     * api接口标题
     * @return 
     */
    String title() default "";
    /**
     * 说明信息
     * @return 
     */
    String info() default "";
    /**
     * 是否允许调试接口
     * @return 
     */
    boolean debugg() default true;
    /**
     * 返回的数据实体类
     * @return 
     */
    Class<?> responseBody() default Object.class;
}
