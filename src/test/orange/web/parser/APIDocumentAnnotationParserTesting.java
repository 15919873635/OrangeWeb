/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.orange.web.parser;

import com.orange.web.annotation.APIDocument;
import com.orange.web.parser.APIDocumentParser;
import com.orange.web.parser.SimpleParserFactory;

/**
 *
 * @author lining
 */
public class APIDocumentAnnotationParserTesting {
    public static void main(String[] args) {
        APIDocument api = MyHello.class.getAnnotation(APIDocument.class);
        APIDocumentParser parse = (APIDocumentParser)SimpleParserFactory.getParser(api);
        if(parse != null)
            System.out.println(parse.parse(api, 123,"1234"));
    }
}
