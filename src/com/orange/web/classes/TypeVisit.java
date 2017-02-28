/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.classes;

/**
 *
 * @author lining
 */
public class TypeVisit {
    /**
     * 类的最低版本
     */
    private int version;
    /**
     * 类前面的修饰符(关键字)
     */
    private int access;
    /**
     * 类的名称
     */
    private String name;
    /**
     * 类的签名，如果不需要签名可以为null
     */
    private String signature;
    /**
     * 类的父类的名称，对于接口而言父类是对象
     */
    private String superName;
    /**
     * 类的接口
     */
    private String[] interfaces;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String[] interfaces) {
        this.interfaces = interfaces;
    }
}
