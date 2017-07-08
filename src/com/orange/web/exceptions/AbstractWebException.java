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
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6233017708117980892L;
	
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
