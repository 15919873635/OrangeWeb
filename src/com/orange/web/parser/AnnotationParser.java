/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.parser;

import java.lang.annotation.Annotation;

/**
 *
 * @author lining
 * @param <A>
 */
public interface AnnotationParser<A extends Annotation> {
    public static final String ORANGE_PACK = "com.orange.web";
    
    public  Object parse(A annotation, Object... objList);
}
