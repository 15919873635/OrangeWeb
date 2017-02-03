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
public class NonOverLappingException extends AbstractWebException{
    
    public NonOverLappingException(String message) {
        super(message);
    }
    
    public NonOverLappingException(Throwable cause) {
        super(cause);
    }
    
    public NonOverLappingException(String message, Throwable cause) {
        super(message, cause);
    }
}
