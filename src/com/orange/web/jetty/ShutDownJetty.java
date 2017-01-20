/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.jetty;

import com.orange.web.util.StringUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;

/**
 *
 * @author lining
 * 关闭Jetty服务器
 * 使用http请求
 */
public class ShutDownJetty {
    public static void main(String[] args) {
        try {
            StringBuilder shutDownUrl = new StringBuilder("http://localhost");
            if(!StringUtil.isEmpty(args[0]))
                shutDownUrl.append(args[0]);
            shutDownUrl.append("/shutdown");
            if(!StringUtil.isEmpty(args[1]))
                shutDownUrl.append("?token=").append(args[1]);
            URL url = new URL(shutDownUrl.toString());
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.getResponseCode();
        } catch (SocketException e) {
            // Okay - the server is not running
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
