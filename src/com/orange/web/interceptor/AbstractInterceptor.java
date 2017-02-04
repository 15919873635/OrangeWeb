/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.interceptor;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
/**
 *
 * @author lining
 */
public abstract class AbstractInterceptor implements BasicDefaultInterceptor{
    public abstract boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception;
    public abstract void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception;
    public abstract void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
    throws Exception;
}
