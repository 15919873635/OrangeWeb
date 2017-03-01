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
public class TypeFragmentation {
    private AnnotationVisit annotationVisit;
    private TypeVisit typeVisit;
    private FieldVisit fieldVisit;
    private MethodVisit methodVisit;
    private InnerClassVisit innerClassVisit;
    private OuterClassVisit outerClassVisit;

    public AnnotationVisit getAnnotationVisit() {
        return annotationVisit;
    }

    public void setAnnotationVisit(AnnotationVisit annotationVisit) {
        this.annotationVisit = annotationVisit;
    }

    public TypeVisit getTypeVisit() {
        return typeVisit;
    }

    public void setTypeVisit(TypeVisit typeVisit) {
        this.typeVisit = typeVisit;
    }

    public FieldVisit getFieldVisit() {
        return fieldVisit;
    }

    public void setFieldVisit(FieldVisit fieldVisit) {
        this.fieldVisit = fieldVisit;
    }

    public MethodVisit getMethodVisit() {
        return methodVisit;
    }

    public void setMethodVisit(MethodVisit methodVisit) {
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
