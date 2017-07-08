/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.logs;

import com.orange.web.annotation.LoggingComponent;
import com.orange.web.util.StringUtil;
import java.io.File;

/**
 *
 * @author lining
 */
public class AbstractLoggingFactory implements DefaultLoggingFactory{
    
    @Override
    public Logging getLogging(Class<?> classzz){
        Logging log = new Logging();
        LoggingComponent loggingAnnotation = classzz.getAnnotation(LoggingComponent.class);
        if(loggingAnnotation != null){
            if(!StringUtil.isEmpty(loggingAnnotation.filePath())){
                log.loggingFile = new File(loggingAnnotation.filePath());
                log.loggingFormat = loggingAnnotation.format();
                log.loggingLevels = loggingAnnotation.level();
                log.maxFileSize = loggingAnnotation.maxFileSize() >= 0 ? loggingAnnotation.maxFileSize() : 0;
            }
        }
        return log;
    }
    
    public static AbstractLoggingFactory builder(){
        return new AbstractLoggingFactory();
    }
}
