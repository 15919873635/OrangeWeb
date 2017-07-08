/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.orange.web.classes;

import com.orange.web.type.ServletFileGenerateTemplate;
import com.orange.web.type.TypeFileGenerator;

/**
 *
 * @author lining
 */
public class TypeFileGeneratorTesting {
    public static void main(String[] args){
//        System.out.println(Type.getType("Ljava.lang.Object;").getDescriptor());
        TypeFileGenerator fileGenerator = new TypeFileGenerator();
//        TypeFragmentation typeFragmentation = new TypeFragmentation();
        try {
            fileGenerator.generator(ServletFileGenerateTemplate.typeFragmentation, null);
            fileGenerator.write2File("MyExample.class");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
