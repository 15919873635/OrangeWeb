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
public abstract class AbstractAnnotationParser<A extends Annotation> implements AnnotationParser<A>{
    protected boolean checkOrangePack(String[] packs){
        boolean hasOrangePack = false;
        for(String basePack : packs){
            if(basePack.contains(ORANGE_PACK)){
                hasOrangePack = true;
                break;
            }
        }
        return hasOrangePack;
    }
}
