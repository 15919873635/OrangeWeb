/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web;

import com.orange.web.annotation.OrangeWebAnnotation;
import com.orange.web.parser.SimpleParserFactory;
import com.orange.web.parser.WebAnnotationParser;

/**
 *
 * @author lining
 */
public class WebApplication {
    public static void run(Class<?> classzz,String[] args){
        OrangeWebAnnotation webAnnotation = classzz.getAnnotation(OrangeWebAnnotation.class);
        if(webAnnotation != null){
            WebAnnotationParser webAnnotationParser = (WebAnnotationParser)SimpleParserFactory.getParser(webAnnotation);
            webAnnotationParser.parse(webAnnotation, classzz);
        }
    };
}
