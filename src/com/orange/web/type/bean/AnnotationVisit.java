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
public class AnnotationVisit {
    /**
     * 注解类的类描述符
     */
    private String desc;
    /**
     * 如果注解在运行时可见，则返回true
     */
    private boolean visible;
    
    private Set<AnnotationPlainWrap> plainWrapSet;
    
    private Set<AnnotationEnumWrap> enumWrapSet;
    
    private Set<AnnotationAnnotationWrap> annotationWrapSet;
    
    private Set<AnnotationArrayWrap> arrayWrapSet;
    
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

    public Set<AnnotationPlainWrap> getPlainWrapSet() {
        return plainWrapSet;
    }

    public void setPlainWrapSet(Set<AnnotationPlainWrap> plainWrapSet) {
        this.plainWrapSet = plainWrapSet;
    }

    public Set<AnnotationEnumWrap> getEnumWrapSet() {
        return enumWrapSet;
    }

    public void setEnumWrapSet(Set<AnnotationEnumWrap> enumWrapSet) {
        this.enumWrapSet = enumWrapSet;
    }

    public Set<AnnotationAnnotationWrap> getAnnotationWrapSet() {
        return annotationWrapSet;
    }

    public void setAnnotationWrapSet(Set<AnnotationAnnotationWrap> annotationWrapSet) {
        this.annotationWrapSet = annotationWrapSet;
    }

    public Set<AnnotationArrayWrap> getArrayWrapSet() {
        return arrayWrapSet;
    }

    public void setArrayWrapSet(Set<AnnotationArrayWrap> arrayWrapSet) {
        this.arrayWrapSet = arrayWrapSet;
    }
    
    public class AnnotationPlainWrap{
        private String plainName;
        private Object plainValue;

        public String getPlainName() {
            return plainName;
        }

        public void setPlainName(String plainName) {
            this.plainName = plainName;
        }

        public Object getPlainValue() {
            return plainValue;
        }

        public void setPlainValue(String plainValue) {
            this.plainValue = plainValue;
        }
    }
    
    public class AnnotationEnumWrap{
        private String enumName; 
        private String enumDesc; 
        private String enumValue;

        public String getEnumName() {
            return enumName;
        }

        public void setEnumName(String enumName) {
            this.enumName = enumName;
        }

        public String getEnumDesc() {
            return enumDesc;
        }

        public void setEnumDesc(String enumDesc) {
            this.enumDesc = enumDesc;
        }

        public String getEnumValue() {
            return enumValue;
        }

        public void setEnumValue(String enumValue) {
            this.enumValue = enumValue;
        }
        
    }
    
    public class AnnotationAnnotationWrap{
        private String annotationName; 
        private String annotationDesc;

        public String getAnnotationName() {
            return annotationName;
        }

        public void setAnnotationName(String annotationName) {
            this.annotationName = annotationName;
        }

        public String getAnnotationDesc() {
            return annotationDesc;
        }

        public void setAnnotationDesc(String annotationDesc) {
            this.annotationDesc = annotationDesc;
        }
    }
    
    public class AnnotationArrayWrap{
        private String arrayValue;

        public String getArrayValue() {
            return arrayValue;
        }

        public void setArrayValue(String arrayValue) {
            this.arrayValue = arrayValue;
        }
        
    }
}

