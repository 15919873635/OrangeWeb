/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.parser;

import com.orange.web.annotation.RequestMapping;

/**
 *
 * @author lining
 */
public final class RequestMappingParser extends AbstractAnnotationParser<RequestMapping>{

    @Override
    public Object parse(RequestMapping requestMapping, Object... objList) {
        if(objList[0] instanceof Class<?>){
            Class<?> objClass = (Class<?>)objList[0];
        }
        return objList[0];
    }
}
