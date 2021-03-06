/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type.task;

import com.orange.web.annotation.ControllerComponent;
import com.orange.web.annotation.DaoComponent;
import com.orange.web.annotation.ServiceComponent;
import com.orange.web.parser.ControllerComponentParser;
import com.orange.web.parser.DaoComponentParser;
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
    
    public class ControllerComponentParseTask implements Callable<Boolean>{
        private Class<?> thisClass;

        public ControllerComponentParseTask(Class<?> thisClass){
            this.thisClass = thisClass;
        }
        @Override
        public Boolean call() throws Exception {
            ControllerComponent controllerComponent = thisClass.getAnnotation(ControllerComponent.class);
            ControllerComponentParser controllerComponentParser = (ControllerComponentParser)SimpleParserFactory.getParser(controllerComponent);
            controllerComponentParser.parse(controllerComponent, thisClass);
            return true;
        }
    }
}


