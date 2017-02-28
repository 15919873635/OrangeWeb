/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.classes.bean;

/**
 *
 * @author lining
 */
public class OuterClassVisit {
    /**
     * 封闭该类的类的名称
     */
    private String owner;
    /**
     * 包含该类的方法的名称，如果该类不包含在其封闭类的方法中，则为null。
     */
    private String name;
    /**
     * 包含该类的方法的描述符，如果该类不包含在其封闭类的方法中，则为null。
     */
    private String desc;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
    
}
