/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type.bean;

import java.util.Set;

/**
 *
 * @author lining
 */
public class FieldVisit {
    /**
     * 字段前面的修饰符(关键字)
     */
    private int access;
    /**
     * 字段的名称
     */
    private String name;
    /**
     * 字段的描述符
     */
    private String desc;
    /**
     * 字段的签名，如果字段类型不是泛型类型则可为null
     */
    private String signature;
    /**
     * 字段的默认值
     */
    private Object value;
    /**
     * 注释Visit的聚合
     */
    private Set<AnnotationVisit> annotationSet;

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

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Set<AnnotationVisit> getAnnotationSet() {
        return annotationSet;
    }

    public void setAnnotationSet(Set<AnnotationVisit> annotationSet) {
        this.annotationSet = annotationSet;
    }
    
}
