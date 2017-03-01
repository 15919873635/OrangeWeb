/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type.bean;

/**
 *
 * @author lining
 */
public class InnerClassVisit {
    /**
     * 内部类的名称
     */
    private String name;
    /**
     * 该内部类所属类的名称，如果不是成员类，可为空
     */
    private String outerName;
    /**
     * 该内部类在封闭它的类中的名称。匿名的内部类可以为空
     */
    private String innerName;
    /**
     * 类前面的修饰符(关键字)
     */
    private int access;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOuterName() {
        return outerName;
    }

    public void setOuterName(String outerName) {
        this.outerName = outerName;
    }

    public String getInnerName() {
        return innerName;
    }

    public void setInnerName(String innerName) {
        this.innerName = innerName;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
    
    
}
