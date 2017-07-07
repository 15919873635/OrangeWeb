/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.parser;

import com.orange.web.annotation.ServiceComponent;

/**
 *
 * @author lining
 */
public class ServiceComponentParser extends AbstractAnnotationParser<ServiceComponent>{

    @Override
    public Object parse(ServiceComponent annotation, Object... objList) {
        if(objList[0] instanceof Class<?>){
            Class<?> objClass = (Class<?>)objList[0];
            return objList[0];
        }
        return null;
    }
}
