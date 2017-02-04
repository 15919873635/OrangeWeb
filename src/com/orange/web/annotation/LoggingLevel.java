/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.annotation;

/**
 *
 * @author lining
 */
public enum LoggingLevel {
    /**
     * DEBUG Level表明细粒度信息事件对调试应用程序是非常有帮助的
     * INFO level表明消息在粗粒度级别上突出强调应用程序的运行过程
     * WARN level表明会出现潜在错误的情形
     * ERROR level指出虽然发生错误事件，但仍然不影响系统的继续运行
     * FATAL level指出每个严重的错误事件将会导致应用程序的退出
     */
    DEBUG,INFO,WARN,ERROR,FATAL
}
