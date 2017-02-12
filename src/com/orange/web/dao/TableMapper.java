/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.dao;

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
public @interface TableMapper {
    /**
     * 数据库名称，可以为空，如果为空则默认使用数据库连接池(c3p0)配置中的jdbcurl的数据库名称
     * @return 
     */
    String dbname() default "";
    /**
     * 数据库表名称，不为空
     * @return 
     */
    String table();
}
