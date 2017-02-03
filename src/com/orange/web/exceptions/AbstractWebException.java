/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.exceptions;

/**
 *
 * @author lining
 */
public class AbstractWebException extends Throwable{
    
    public AbstractWebException(String message){
        super(message);
    }
    public AbstractWebException(Throwable cause){
        super(cause);
    }
    public AbstractWebException(String message,Throwable cause){
        super(message, cause);
    }
    
}
