/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.parser;

import java.lang.annotation.Annotation;

/**
 * 使用简单工厂模式生成Parser
 * @author lining
 */
public final class SimpleParserFactory {
    public static <A extends Annotation> AnnotationParser getParser(A annotation){
        switch(annotation.annotationType().getName()){
            case "com.orange.web.annotation.APIDocument": return new APIDocumentParser();
            case "com.orange.web.annotation.Configuration" : return new ConfigurationParser();
            case "com.orange.web.annotation.FieldMapper" : return new FieldMapperParser();
            case "com.orange.web.annotation.LoggingComponent" : return new FieldMapperParser();
            case "com.orange.web.annotation.PathVariable" : return new PathVariableParser();
            case "com.orange.web.annotation.RequestMapping" : return new RequestMappingParser();
            case "com.orange.web.annotation.OrangeWebAnnotation" : return new WebAnnotationParser();
            default:return null;
        }
    }; 
}
