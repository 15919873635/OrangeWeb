/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type;

import com.orange.web.type.bean.AnnotationVisit;
import com.orange.web.type.bean.MethodVisit;
import com.orange.web.type.bean.TypeVisit;
import com.orange.web.type.bean.FieldVisit;
import com.orange.web.type.bean.ParamAnnotationVisit;
import com.orange.web.type.bean.TypeFragmentation;
import com.orange.web.util.ClassGeneratorUtil;
import com.orange.web.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jdk.internal.org.objectweb.asm.AnnotationVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * class文件生成器
 * @author lining
 */
public class TypeFileGenerator implements TypeGenerator{
    public  ClassWriter classWriter;
    public TypeFileGenerator(ClassWriter classWriter){
        this.classWriter = classWriter;
    }
    public TypeFileGenerator(){
        this.classWriter = new ClassWriter(0);
    }
    public void generator(TypeFragmentation typeFragmentation) throws Exception{
        generator(typeFragmentation, null);
    }
    @Override
    public void generator(TypeFragmentation typeFragmentation, ClassWriter classWriter) throws Exception{
        if(classWriter != null)
            this.classWriter = classWriter;
        if(typeFragmentation != null){
            generatorClassHeader(typeFragmentation.getTypeVisit(),this.classWriter);
            generatorAnnotation(typeFragmentation.getAnnotationVisit(), this.classWriter);
            generatorFields(typeFragmentation.getFieldVisit(),this.classWriter);
            generatorMethods(typeFragmentation.getMethodVisit(), this.classWriter);
        }
    }
    /**
     * 将生成的class字节数据写入到class文件中
     * @param bytes
     * @param filePath
     * @throws IOException 
     */
    public void write2File(byte[] bytes,String filePath) throws IOException{
        File file = new File(filePath);
        if(file.exists())
            file.delete();
        boolean succ = file.createNewFile();
        if(succ){
            FileOutputStream fileOut = new FileOutputStream(file);
            fileOut.write(bytes);
            fileOut.close();
        }
    }
    /**
     * 将生成的class数据写入到class文件中
     * @param data
     * @param filePath
     * @throws IOException 
     */
    public void write2File(String data,String filePath) throws IOException{
        byte[] bytes = data.getBytes();
        write2File(bytes,filePath);
    }
    /**
     * 将生成的class数据写入到class文件中
     * @param filePath
     * @throws IOException 
     */
    public void write2File(String filePath) throws IOException{
        byte[] bytes = this.classWriter.toByteArray();
        write2File(bytes,filePath);
    }
    /**
     * 生成类的头部信息数据
     * @param classVisit
     * @param classWriter
     * @throws java.lang.ClassNotFoundException
     */
    public void generatorClassHeader(TypeVisit classVisit,ClassWriter classWriter) throws ClassNotFoundException{
        if(classVisit != null){
            String name = classVisit.getName();
            String superName = classVisit.getSuperName();
            String[] interfaces = null;
            if(!StringUtil.isEmpty(name))
                name = ClassGeneratorUtil.transform2PackageName(name);
            if(!StringUtil.isEmpty(superName))
                superName = ClassGeneratorUtil.transform2PackageName(superName);
            if(classVisit.getInterfaces() != null && classVisit.getInterfaces().length > 0){
                interfaces = new String[]{};
                int count = 0;
                for(String interName : classVisit.getInterfaces()){
                    if(!StringUtil.isEmpty(interName)){
                        interName = ClassGeneratorUtil.transform2PackageName(superName);
                        interfaces[count] = interName;
                        count += 1;
                    }
                }
            }
            classWriter.visit(classVisit.getVersion(), 
                            classVisit.getAccess(),
                            name, 
                            classVisit.getSignature(),
                            superName,
                            interfaces);
        }    
    }
    
    /**
     * 生成类里面的字段信息
     * @param fieldVisits
     * @param classWriter
     */
    public void generatorFields(Iterator<FieldVisit> fieldVisits, ClassWriter classWriter) throws ClassNotFoundException{
        if(fieldVisits != null){
            while(fieldVisits.hasNext()){
                FieldVisit fieldVisit = fieldVisits.next();
                if(fieldVisit != null){
                    String fieldDesc = fieldVisit.getDesc();
                    if(!StringUtil.isEmpty(fieldDesc))
                        fieldDesc = ClassGeneratorUtil.getTypeDescriptor(fieldDesc);
                    FieldVisitor visitor = classWriter.visitField(fieldVisit.getAccess(),
                                    fieldVisit.getName(), 
                                    fieldDesc, 
                                    fieldVisit.getSignature(), 
                                    fieldVisit.getValue());
                    if(fieldVisit.getAnnotationSet() != null && !fieldVisit.getAnnotationSet().isEmpty())
                        generatorAnnotation(fieldVisit.getAnnotationSet().iterator(),classWriter);
                    visitor.visitEnd();
                }
            }
        }
    }
    
    /**
     * 生成类里面的方法信息
     * @param methodVisits
     * @param classWriter
     */
    public void generatorMethods(Iterator<MethodVisit> methodVisits, ClassWriter classWriter) throws ClassNotFoundException{
        if(methodVisits != null){
            while(methodVisits.hasNext()){
                MethodVisit methodVisit = methodVisits.next();
                if(methodVisit != null){
                    MethodVisitor methodVisitor =  classWriter.visitMethod(methodVisit.getAccess(),
                                    methodVisit.getName(), 
                                    methodVisit.getDesc(), 
                                    methodVisit.getSignature(), 
                                    methodVisit.getExceptions());
                    if(methodVisit.getPaAnnotationSet() != null && methodVisit.getPaAnnotationSet().size() > 0){
                        Iterator<ParamAnnotationVisit> it = methodVisit.getPaAnnotationSet().iterator();
                        while(it.hasNext()){
                            ParamAnnotationVisit paAnnotationVisit = it.next();
                            AnnotationVisit anVisit = paAnnotationVisit.getAnnotationVisit();
                            if(anVisit != null){
                                Set<AnnotationVisit> anSet = new HashSet<AnnotationVisit>();
                                anSet.add(anVisit);
                                methodVisitor.visitParameterAnnotation(paAnnotationVisit.getParameter(), paAnnotationVisit.getAnnotationVisit().getDesc(), true);
                                generatorAnnotation(anSet.iterator(), classWriter);
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * 生成类里面的注解信息
     * @param annotationVisits
     * @param classWriter
     */
    public void generatorAnnotation(Iterator<AnnotationVisit> annotationVisits, ClassWriter classWriter){
        if(annotationVisits != null){
            while(annotationVisits.hasNext()){
                AnnotationVisit annotationVisit = annotationVisits.next();
                if(annotationVisit != null){
                    AnnotationVisitor vistor =  classWriter.visitAnnotation(annotationVisit.getDesc(),
                                                annotationVisit.isVisible());
                    if(annotationVisit.getPlainWrapSet() != null && !annotationVisit.getPlainWrapSet().isEmpty()){
                        Iterator<AnnotationVisit.AnnotationPlainWrap> iterator = annotationVisit.getPlainWrapSet().iterator();
                        while(iterator.hasNext()){
                            AnnotationVisit.AnnotationPlainWrap plainWrap = iterator.next();
                            vistor.visit(plainWrap.getPlainName(), plainWrap.getPlainValue());
                        }
                    } if(annotationVisit.getEnumWrapSet() != null && !annotationVisit.getEnumWrapSet().isEmpty()){
                        Iterator<AnnotationVisit.AnnotationEnumWrap> iterator = annotationVisit.getEnumWrapSet().iterator();
                        while(iterator.hasNext()){
                            AnnotationVisit.AnnotationEnumWrap enumWrap = iterator.next();
                            vistor.visitEnum(enumWrap.getEnumName(), enumWrap.getEnumDesc(), enumWrap.getEnumValue());
                        }
                    } if(annotationVisit.getAnnotationWrapSet() != null && !annotationVisit.getAnnotationWrapSet().isEmpty()){
                        
                    } if(annotationVisit.getArrayWrapSet() != null && !annotationVisit.getArrayWrapSet().isEmpty()){
                        Iterator<AnnotationVisit.AnnotationArrayWrap> iterator = annotationVisit.getArrayWrapSet().iterator();
                        while(iterator.hasNext()){
                            AnnotationVisit.AnnotationArrayWrap arrayWrap = iterator.next();
                            vistor.visitArray(arrayWrap.getArrayValue());
                        }
                    }
                    vistor.visitEnd();
                }
            }
        }
    }

    public ClassWriter getClassWriter() {
        return classWriter;
    }

    public void setClassWriter(ClassWriter classWriter) {
        this.classWriter = classWriter;
    }
}
