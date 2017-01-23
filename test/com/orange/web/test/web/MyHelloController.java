/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.test.web;

import com.orange.web.annotation.APIDocument;
import com.orange.web.annotation.ControllerComponent;
import com.orange.web.annotation.PathVariable;
import com.orange.web.annotation.RequestMapping;
import com.orange.web.annotation.RequestMethod;
import com.orange.web.annotation.RequestMode;

/**
 *
 * @author lining
 */
@ControllerComponent(name = "helloController", type = RequestMode.REST)
public class MyHelloController {
    @APIDocument(name = "",title = "",info = "")
    @RequestMapping(name = "userLogin",path = "/userName/{hello}/{mytest}/{get}",method = {RequestMethod.GET,RequestMethod.POST})
    public void userLogin(@PathVariable(name = "hello") String hello){
        System.out.println(hello);
    }
}
