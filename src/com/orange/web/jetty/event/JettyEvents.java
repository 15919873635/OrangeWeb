/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.jetty.event;

/**
 *
 * @author lining
 */
public interface JettyEvents {
    public void onStart();
    public void onLoading();
    public void onClosing();
    public void onClosed();
}
