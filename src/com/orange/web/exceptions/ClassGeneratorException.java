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
public class ClassGeneratorException extends AbstractWebException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 91046835177881915L;

	public ClassGeneratorException(String message) {
        super(message);
    }
    
    public ClassGeneratorException(Throwable cause) {
        super(cause);
    }
    
    public ClassGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }
}
