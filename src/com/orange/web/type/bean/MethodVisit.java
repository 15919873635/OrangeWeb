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
public class MethodVisit {
    /**
     * 方法前面的修饰符(关键字)
     */
    private int access;
    /**
     * 方法的名称
     */
    private String name;
    /**
     * 方法的描述符
     */
    private String desc;
    /**
     * 方法的签名，如果不需要签名可以为null
     */
    private String signature;
    /**
     * 要抛出的异常的类名
     */
    private String[] exceptions;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String[] getExceptions() {
        return exceptions;
    }

    public void setExceptions(String[] exceptions) {
        this.exceptions = exceptions;
    }
}
