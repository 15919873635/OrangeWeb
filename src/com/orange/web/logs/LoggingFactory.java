/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.logs;

/**
 *
 * @author lining
 */
public class LoggingFactory {

    public static Logging getLogging(Class<?> classzz) {
        return AbstractLoggingFactory.builder().getLogging(classzz);
    }
    
}