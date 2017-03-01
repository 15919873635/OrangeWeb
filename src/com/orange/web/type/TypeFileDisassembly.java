/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type;

import com.orange.web.type.bean.TypeFragmentation;
import jdk.internal.org.objectweb.asm.ClassReader;

/**
 * 将从classreader中读入的类字节码进行拆解
 * @author lining
 */
public class TypeFileDisassembly implements TypeDisassembly{
    public ClassReader classReader;
    public  TypeFileDisassembly(ClassReader classReader){
        this.classReader = classReader;
    }
    @Override
    public TypeFragmentation dismantle(ClassReader classReader) {
        if(classReader != null)
            this.classReader = classReader;
        return new TypeFragmentation();
    }
}
