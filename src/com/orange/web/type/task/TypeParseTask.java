/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type.task;

import com.orange.web.annotation.DaoComponent;
import com.orange.web.annotation.RequestMapping;
import com.orange.web.annotation.ServiceComponent;
import com.orange.web.parser.DaoComponentParser;
import com.orange.web.parser.RequestMappingParser;
import com.orange.web.parser.ServiceComponentParser;
import com.orange.web.parser.SimpleParserFactory;
import java.util.concurrent.Callable;

/**
 *
 * @author lining
 */
public class TypeParseTask {
    
    public class DaoComponentParseTask implements Callable<Boolean>{
        private Class<?> thisClass;

        public DaoComponentParseTask(Class<?> thisClass){
            this.thisClass = thisClass;
        }
        @Override
        public Boolean call() throws Exception {
            DaoComponent daoComponent = thisClass.getAnnotation(DaoComponent.class);
            DaoComponentParser daoComponentParser = (DaoComponentParser)SimpleParserFactory.getParser(daoComponent);
            daoComponentParser.parse(daoComponent, thisClass);
            return true;
        }
    }
    
    public class ServiceComponentParseTask implements Callable<Boolean>{
        private Class<?> thisClass;
        
        public ServiceComponentParseTask(Class<?> thisClass){
            this.thisClass = thisClass;
        }
        @Override
        public Boolean call() throws Exception {

            ServiceComponent serviceComponent = thisClass.getAnnotation(ServiceComponent.class);
            ServiceComponentParser serviceComponentParser = (ServiceComponentParser)SimpleParserFactory.getParser(serviceComponent);
            serviceComponentParser.parse(serviceComponent, thisClass);
            return true;
        }
    }
    
    public class RequestMappingParseTask implements Callable<Boolean>{
        private Class<?> thisClass;

        public RequestMappingParseTask(Class<?> thisClass){
            this.thisClass = thisClass;
        }
        @Override
        public Boolean call() throws Exception {

            RequestMapping requestMapping = thisClass.getAnnotation(RequestMapping.class);
            RequestMappingParser requestMappingParser = (RequestMappingParser)SimpleParserFactory.getParser(requestMapping);
            requestMappingParser.parse(requestMapping, thisClass);
            return true;
        }
    }
}


