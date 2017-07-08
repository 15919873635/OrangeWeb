/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.dao;

/**
 *
 * @author lining
 */
public enum SupportedType {
    /**
     * 目前和计划支持的数据库类型
     */
    MYSQL,ORACLE,MANGODB,
    /**
     * 查询字段的排序
     */
    ASC,DESC,
    /**
     * DB操作的类型
     */
    SAVE,DELETE,UPDATE,QUERY;
}
