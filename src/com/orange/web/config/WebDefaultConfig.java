/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.config;
import com.orange.web.annotation.Configuration;

/**
 *
 * @author lining
 */
@Configuration(prefix = "ow", location = "default.properties")
public class WebDefaultConfig {
    /**
     * Web Server的端口
     */
    private Integer server_port;
    /**
     * 是否跨域
     * 前端在访问和调试时往往会遇到跨域问题，跨域访问是浏览器的一种安全策略。
     * 这里提供一个跨域的开关，灵活的使跨域问题得到解决
     */
    private Boolean cross_domain;
    /**
     * 静态文件(html、javascript、css、json)的存储目录
     */
    private String resource_path;

    public Integer getServer_port() {
        return server_port;
    }

    public void setServer_port(Integer server_port) {
        this.server_port = server_port;
    }

    public Boolean getCross_domain() {
        return cross_domain;
    }

    public void setCross_domain(Boolean cross_domain) {
        this.cross_domain = cross_domain;
    }

    public String getResource_path() {
        return resource_path;
    }

    public void setResource_path(String resource_path) {
        this.resource_path = resource_path;
    }
}
