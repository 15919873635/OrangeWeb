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
@Target(ElementType.TYPE)
@Component
public @interface InterceptorComponent {
    /**
     * 必填项
     * 设置需要拦截的url的地址
     * @return 
     */
    String[] path();
    /**
     * 设置拦截器的执行顺序
     * 当存在多个拦截器时，按照index值从小到大开始执行,index值越小越早执行。
     * 当存在多个相同的index值时，按随机顺序执行。
     * @return 
     */
    int index() default 0;
    /**
     * 设置该类在实例化时是单例还是多例，默认是多例
     * @return 
     */
    SingletonMode singleton() default SingletonMode.MULTITON;
}
