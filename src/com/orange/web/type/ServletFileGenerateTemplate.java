/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type;

import com.orange.web.type.bean.TypeFragmentation;
import com.orange.web.type.bean.TypeVisit;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

/**
 *
 * @author lining
 */
public class ServletFileGenerateTemplate {
    public static TypeFragmentation typeFragmentation = null;
    static{
        typeFragmentation = new TypeFragmentation();
        TypeVisit typeVisit = new TypeVisit();
        typeVisit.setVersion(Opcodes.V1_5);
        typeVisit.setAccess(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL);
        typeVisit.setName("com/ln/test/MyExample");
        typeVisit.setSuperName("java/lang/Object");
        typeFragmentation.setTypeVisit(typeVisit);
        
    }
}
