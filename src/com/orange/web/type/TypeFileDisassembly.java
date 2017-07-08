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
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 将从classreader中读入的类字节码进行拆解
 * @author lining
 */
public class TypeFileDisassembly extends ClassVisitor implements TypeDisassembly{
    private final TypeFragmentation typeFragmentation = new TypeFragmentation();
    private final TypeVisit typeVisit = new TypeVisit();
    private final Set<FieldVisit> fieldVisitSet = new HashSet<>();
    private final Set<MethodVisit> methodVisitSet = new HashSet<>();
    public  TypeFileDisassembly(){
        super(Opcodes.ASM4);
    }
    @Override
    public void visit(int i, int i1, String string, String string1, String string2, String[] strings){
        typeVisit.setVersion(i);
        typeVisit.setAccess(i1);
        typeVisit.setName(string);
        typeVisit.setSignature(string1);
        typeVisit.setSuperName(string2);
        typeVisit.setInterfaces(strings);
    }
    @Override
    public FieldVisitor visitField(int i, String string, String string1, String string2, Object o) {
        FieldVisit fieldVisit = new FieldVisit();
        fieldVisit.setAccess(i);
        fieldVisit.setName(string);
        fieldVisit.setDesc(string1);
        fieldVisit.setSignature(string2);
        fieldVisit.setValue(o);
        fieldVisitSet.add(fieldVisit);
        return null;
    }
    @Override
    public MethodVisitor visitMethod(int i, String string, String string1, String string2, String[] strings){
        MethodVisit methodVisit = new MethodVisit();
        methodVisit.setAccess(i);
        methodVisit.setName(string);
        methodVisit.setDesc(string1);
        methodVisit.setSignature(string2);
        methodVisit.setExceptions(strings);
        methodVisitSet.add(methodVisit);
        return null;
    }
    @Override
    public void visitEnd() {
        typeFragmentation.setTypeVisit(typeVisit);
        typeFragmentation.setFieldVisit(fieldVisitSet.iterator());
        typeFragmentation.setMethodVisit(methodVisitSet.iterator());
    }
    @Override
    public TypeFragmentation dismantle(ClassReader classReader) {
        return typeFragmentation;
    }
}
