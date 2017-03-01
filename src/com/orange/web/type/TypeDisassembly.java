/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type;

import com.orange.web.type.bean.TypeFragmentation;
import jdk.internal.org.objectweb.asm.ClassReader;

/**
 * 类的拆解类或者接口
 * @author lining
 */
public interface TypeDisassembly {
    public TypeFragmentation dismantle(ClassReader classReader);
}
