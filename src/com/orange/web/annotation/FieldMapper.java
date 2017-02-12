/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.annotation;

import com.orange.web.dao.SupportedType;
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
@Target(ElementType.FIELD)
public @interface FieldMapper {
    /**
     * 数据库的字段名
     * @return 
     */
    String field();
    /**
     * 查询语句的排序顺序(升序或降序)
     * @return 
     */
    SupportedType orderby() default SupportedType.ASC;
    /**
     * 顺序的权重值，用于组织查询语句
     * @return 
     */
    int orderindex() default 0;
}
