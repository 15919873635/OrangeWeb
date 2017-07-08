/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.exceptions;

import com.orange.web.constants.NonOverLappingConstant;

/**
 *
 * @author lining
 */
public class NonOverLappingException extends AbstractWebException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2926424384852237850L;

	public NonOverLappingException() {
        super(NonOverLappingConstant.COMPONENT_NON_OVER_LAPPING);
    }
    
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
