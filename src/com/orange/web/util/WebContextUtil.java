/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.util;

import com.orange.web.annotation.DaoComponent;
import com.orange.web.annotation.RequestMapping;
import com.orange.web.annotation.ServiceComponent;
import com.orange.web.type.task.TypeParseTask;
import com.orange.web.type.task.TypeParseTask.DaoComponentParseTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author lining
 */
public class WebContextUtil {
    /**
     * 存储配置项和值的Map
     */
    public static Map<String,Object> configMap;
    
    /**
     * 存储bean的map
     */
    public static Map<String,Object> beanMap;
    
    private static void execuParseDaoComponentTask(List<Class<?>> typeList){
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<Boolean>> list = new ArrayList<>();
        for(Class<?> classZZ : typeList){
            DaoComponent daoComponent = classZZ.getAnnotation(DaoComponent.class);
            if(daoComponent != null){
                TypeParseTask typeParseTask = new TypeParseTask();
                TypeParseTask.DaoComponentParseTask parseTask = typeParseTask.new DaoComponentParseTask(classZZ);
                Future<Boolean> result = executor.submit(parseTask);
                list.add(result);
            }
        }
        while(true){
            if(list.size() == typeList.size())
                break;
        }
        executor.shutdown();
    }
    
    private static void execuParseServiceComponentTask(List<Class<?>> typeList){
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<Boolean>> list = new ArrayList<>();
        for(Class<?> classZZ : typeList){
            ServiceComponent serviceComponent = classZZ.getAnnotation(ServiceComponent.class);
            if(serviceComponent != null){
                TypeParseTask typeParseTask = new TypeParseTask();
                TypeParseTask.ServiceComponentParseTask parseTask = typeParseTask.new ServiceComponentParseTask(classZZ);
                Future<Boolean> result = executor.submit(parseTask);
                list.add(result);
            }
        }
        while(true){
            if(list.size() == typeList.size())
                break;
        }
        executor.shutdown();
    }
    
    private static void execuParseRequestMappingTask(List<Class<?>> typeList){
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<Boolean>> list = new ArrayList<>();
        for(Class<?> classZZ : typeList){
            RequestMapping requestMapping = classZZ.getAnnotation(RequestMapping.class);
            if(requestMapping != null){
                TypeParseTask typeParseTask = new TypeParseTask();
                TypeParseTask.RequestMappingParseTask parseTask = typeParseTask.new RequestMappingParseTask(classZZ);
                Future<Boolean> result = executor.submit(parseTask);
                list.add(result);
            }
        }
        while(true){
            if(list.size() == typeList.size())
                break;
        }
        executor.shutdown();
    }
    
    public static void execuParseTypeTask(List<Class<?>> typeList){
        execuParseDaoComponentTask(typeList);
        execuParseServiceComponentTask(typeList);
        execuParseRequestMappingTask(typeList);
    }
}
