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
public class NotSupportedDBTypeException extends AbstractWebException{
    
    public NotSupportedDBTypeException(String message) {
        super(message);
    }
    
    public NotSupportedDBTypeException(Throwable cause) {
        super(cause);
    }
    
    public NotSupportedDBTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
