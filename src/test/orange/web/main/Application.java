/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.orange.web.main;

import com.orange.web.WebApplication;
import com.orange.web.annotation.OrangeWebAnnotation;

/**
 *
 * @author lining
 */
@OrangeWebAnnotation(scanBasePackage = {"com.orange.web.test"})
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebApplication.run(Application.class, args);
    }
}
