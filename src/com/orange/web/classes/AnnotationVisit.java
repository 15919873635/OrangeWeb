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
public class AnnotationVisit {
    /**
     * 注解类的类描述符
     */
    private String desc;
    /**
     * 如果注解在运行时可见，则返回true
     */
    private boolean visible;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
