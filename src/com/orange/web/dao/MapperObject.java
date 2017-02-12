/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.dao;

import java.io.Serializable;

/**
 * 用于TableMapper所标注的类继承
 * @author lining
 */
public class MapperObject implements Serializable{
    private int limitIndex;
    private int limitCount;

    public int getLimitIndex() {
        return limitIndex;
    }

    public void setLimitIndex(int limitIndex) {
        this.limitIndex = limitIndex;
    }

    public int getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(int limitCount) {
        this.limitCount = limitCount;
    }
}
