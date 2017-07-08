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
public class AbstractLoggerFactory implements DefaultLoggerFactory{
    
    @Override
    public Logger getLogging(Class<?> classzz){
        Logger log = new Logger();
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
    
    public static AbstractLoggerFactory builder(){
        return new AbstractLoggerFactory();
    }
}
