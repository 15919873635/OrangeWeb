/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.parser;

import com.orange.web.annotation.OrangeWebAnnotation;
import com.orange.web.util.CommonUtil;
import com.orange.web.util.WebContextUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lining
 */
public final class WebAnnotationParser extends AbstractAnnotationParser<OrangeWebAnnotation>{

    @Override
    public Object parse(OrangeWebAnnotation webAnnotation, Object... objList) {
        if(webAnnotation.scanBasePackage() != null 
                && webAnnotation.scanBasePackage().length > 0){
//            if(!checkOrangePack(webAnnotation.scanBasePackage())){
                List<Class<?>> classList = new ArrayList<Class<?>>();
                for(String basePack : webAnnotation.scanBasePackage()){
                    List<Class<?>> classZZList = CommonUtil.getClasses(basePack);
                    classList.addAll(classZZList);
                }
                WebContextUtil.execuParseTypeTask(classList);
//            }
        }
        return null;
    }
}
