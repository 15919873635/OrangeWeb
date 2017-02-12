/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.dao;

import java.util.List;

/**
 *
 * @author lining
 * @param <T>
 */
public abstract class AbstractDataSourceTemplate<T extends MapperObject> {
    /**
    * 数据库新增操作
    * @param t
    * @return
    */
    protected abstract boolean save(T t);
    /**
     * 数据库更新操作
     * @param t
     * @return
     */
    protected abstract boolean update(T t);
    /**
     * 数据库删除操作
     * @param t
     * @return
     */
    protected abstract boolean delete(T t);
    /**
     * 数据库查询操作
     * @param t
     * @return
     */
    protected abstract List<T> queryList(T t);

    /**
     * 查询单个数据操作
     * @param t
     * @return
     */
    protected abstract T query(T t);
}
