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
public abstract class AbstractLoggingFactory implements LoggingFactory{
    @Override
    public Logging getLogging(){
        return null;
    }
    public abstract void debug(String debugString);
    public abstract void info(String infoString);
    public abstract void warn(String warnString);
    public abstract void error(String errorString);
    public abstract void fatal(String fatalString);
}
