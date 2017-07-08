/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type.bean;

import java.util.Iterator;

/**
 *
 * @author lining
 */
public class TypeFragmentation {
    private Iterator<AnnotationVisit> annotationVisit;
    private TypeVisit typeVisit;
    private Iterator<FieldVisit> fieldVisit;
    private Iterator<MethodVisit> methodVisit;
    private InnerClassVisit innerClassVisit;
    private OuterClassVisit outerClassVisit;

    public Iterator<AnnotationVisit> getAnnotationVisit() {
        return annotationVisit;
    }

    public void setAnnotationVisit(Iterator<AnnotationVisit> annotationVisit) {
        this.annotationVisit = annotationVisit;
    }

    public TypeVisit getTypeVisit() {
        return typeVisit;
    }

    public void setTypeVisit(TypeVisit typeVisit) {
        this.typeVisit = typeVisit;
    }

    public Iterator<FieldVisit> getFieldVisit() {
        return fieldVisit;
    }

    public void setFieldVisit(Iterator<FieldVisit> fieldVisit) {
        this.fieldVisit = fieldVisit;
    }

    public Iterator<MethodVisit> getMethodVisit() {
        return methodVisit;
    }

    public void setMethodVisit(Iterator<MethodVisit> methodVisit) {
        this.methodVisit = methodVisit;
    }

    public InnerClassVisit getInnerClassVisit() {
        return innerClassVisit;
    }

    public void setInnerClassVisit(InnerClassVisit innerClassVisit) {
        this.innerClassVisit = innerClassVisit;
    }

    public OuterClassVisit getOuterClassVisit() {
        return outerClassVisit;
    }

    public void setOuterClassVisit(OuterClassVisit outerClassVisit) {
        this.outerClassVisit = outerClassVisit;
    }
    
    
}
