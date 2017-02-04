/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.logs;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lining
 */
public class Logging extends AbstractLogging{
    
    @Override
    public void debug(String debugStr) {
        try {
            super.writeLoggingFile(debugStr);
        } catch (IOException ex) {
            Logger.getLogger(Logging.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public void info(String infoString) {
        
    }

    @Override
    public void warn(String warnString) {
        
    }

    @Override
    public void error(String errorString) {
        
    }

    @Override
    public void fatal(String fatalString) {
        
    }
}
