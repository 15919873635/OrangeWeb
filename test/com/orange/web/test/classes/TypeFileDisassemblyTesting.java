/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.test.classes;

import com.orange.web.type.TypeFileDisassembly;
import com.orange.web.type.bean.TypeFragmentation;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.org.objectweb.asm.ClassReader;

/**
 *
 * @author lining
 */
public class TypeFileDisassemblyTesting {
    public static void main(String[] args){
        try {
            ClassReader reader = new ClassReader("java.lang.String");
            TypeFileDisassembly fileDisasembly = new TypeFileDisassembly();
            reader.accept(fileDisasembly, 0);
            TypeFragmentation typeFragmentation = fileDisasembly.dismantle(reader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
