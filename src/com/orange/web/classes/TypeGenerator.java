/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.classes;

import jdk.internal.org.objectweb.asm.ClassWriter;

/**
 *
 * @author lining
 */
public interface TypeGenerator {
    public void generator(ClassWriter classWriter);
}
