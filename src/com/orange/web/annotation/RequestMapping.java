/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
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
@Inherited
public @interface RequestMapping {
    /**
     * 请求名称
     * @return 
     */
    String name();
    /**
     * 设定的servlet 路径
     * @return 
     */
    String path();
    /**
     *  请求时的HTTP Method
     * @return 
     */
    RequestMethod[] method() default {RequestMethod.GET};
    /**
     * 响应时的媒体类型
     * @return 
     */
    MediaType consumes() default MediaType.TEXT_HTML;
    /**
     * 请求时的媒体类型
     * @return 
     */
    MediaType produces() default MediaType.TEXT_HTML;
}
