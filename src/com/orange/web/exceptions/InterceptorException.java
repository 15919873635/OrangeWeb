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
public class InterceptorException extends AbstractWebException{
    
    public InterceptorException(String message) {
        super(message);
    }
    
    public InterceptorException(Throwable cause) {
        super(cause);
    }
    
    public InterceptorException(String message, Throwable cause) {
        super(message, cause);
    }
}
