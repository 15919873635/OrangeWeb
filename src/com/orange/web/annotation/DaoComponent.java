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
public @interface DaoComponent {
    /**
     * 该dao的名称
     * @return 
     */
    String name();
    /**
     * 设置该类在实例化时是单例还是多例，默认是多例
     * @return 
     */
    SingletonMode singleton() default SingletonMode.MULTITON;
}
