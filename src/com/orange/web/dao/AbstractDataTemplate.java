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
public abstract class AbstractDataTemplate<T extends DBMapperModel> {
    /**
    * 数据库新增操作
    * @param t
    * @return
    */
    protected abstract boolean saveData(T t);
    /**
     * 数据库更新操作
     * @param t
     * @return
     */
    protected abstract boolean updateData(T t);
    /**
     * 数据库删除操作
     * @param t
     * @return
     */
    protected abstract boolean deleteData(T t);
    /**
     * 数据库查询操作
     * @param t
     * @return
     */
    protected abstract List<T> queryDatas(T t);

    /**
     * 查询单个数据操作
     * @param t
     * @return
     */
    protected abstract T queryData(T t);
}
