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
        AnnotationParser parser = null;
        switch(annotation.annotationType().getName()){
            case "com.orange.web.annotation.APIDocument": 
                parser =  new APIDocumentParser();
                break;
            case "com.orange.web.annotation.Configuration" : 
                parser = new ConfigurationParser();
                break;
            case "com.orange.web.annotation.FieldMapper" :
                parser = new FieldMapperParser();
                break;
            case "com.orange.web.annotation.LoggingComponent" :
                parser = new FieldMapperParser();
                break;
            case "com.orange.web.annotation.PathVariable" :
                parser = new PathVariableParser();
                break;
            case "com.orange.web.annotation.RequestMapping" :
                parser = new RequestMappingParser();
                break;
            case "com.orange.web.annotation.ServiceComponent" :
                parser = new ServiceComponentParser();
                break;
            case "com.orange.web.annotation.OrangeWebAnnotation" :
                parser = new WebAnnotationParser();
                break;
            default:
                break;
        }
        return parser;
    }; 
}
