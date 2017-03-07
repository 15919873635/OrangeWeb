/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type;

import com.orange.web.type.bean.FieldVisit;
import com.orange.web.type.bean.MethodVisit;
import com.orange.web.type.bean.TypeFragmentation;
import com.orange.web.type.bean.TypeVisit;
import java.util.HashSet;
import java.util.Set;
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
        
        Set<FieldVisit> fieldVisitSet = new HashSet<FieldVisit>();
        FieldVisit fieldVisit1 = new FieldVisit();
        fieldVisit1.setAccess(Opcodes.ACC_PRIVATE);
        fieldVisit1.setName("hello");
        fieldVisit1.setDesc("java.lang.String");
        fieldVisitSet.add(fieldVisit1);
        
        FieldVisit fieldVisit2 = new FieldVisit();
        fieldVisit2.setAccess(Opcodes.ACC_PRIVATE);
        fieldVisit2.setName("age");
        fieldVisit2.setDesc("java.lang.Integer");
        fieldVisitSet.add(fieldVisit2);
        
        typeFragmentation.setFieldVisit(fieldVisitSet.iterator());
        
        Set<MethodVisit> methodVisitSet = new HashSet<>();
        MethodVisit methodVisit1 = new MethodVisit();
        methodVisit1.setAccess(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL);
        methodVisit1.setName("myTest");
        methodVisit1.setDesc(Type.getMethodDescriptor(Type.INT_TYPE,Type.FLOAT_TYPE,Type.INT_TYPE));
        methodVisitSet.add(methodVisit1);
        typeFragmentation.setMethodVisit(methodVisitSet.iterator());
    }
}
