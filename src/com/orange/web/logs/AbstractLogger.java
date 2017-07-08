/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.logs;

import com.orange.web.annotation.LoggingLevel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author lining
 */
public abstract class AbstractLogger {
    protected File loggingFile;
    protected LoggingLevel[] loggingLevels;
    protected String loggingFormat;
    protected long maxFileSize;
    protected void readLoggingFile() throws FileNotFoundException{
        if(loggingFile.exists()){
            if(!loggingFile.canRead())
                loggingFile.setReadable(true);
            synchronized(loggingFile){
                BufferedReader reader = new BufferedReader(new FileReader(loggingFile));
                
            }
        }
    }
    protected void writeLoggingFile(String message) throws IOException{
        if(loggingFile != null){
            if(!loggingFile.exists()){
                loggingFile.createNewFile();
                loggingFile.setReadable(true);
                loggingFile.setWritable(true);
            }else{
                if(!loggingFile.canRead())
                    loggingFile.setReadable(true);
                if(!loggingFile.canWrite())
                    loggingFile.setWritable(true);
            }
            synchronized(loggingFile){
                // 打开一个随机访问文件流，按读写方式
                RandomAccessFile randomFile = new RandomAccessFile(loggingFile, "rw");
                // 文件长度，字节数
                long fileLength = randomFile.length();
                if(maxFileSize > 0 && maxFileSize < (fileLength + message.length())){

                }
                // 将写文件指针移到文件尾。
                randomFile.seek(fileLength);
                randomFile.writeBytes(message+"\r\n");
                randomFile.close();
            }
        }
    }
    public abstract void debug(String debugString);
    public abstract void info(String infoString);
    public abstract void warn(String warnString);
    public abstract void error(String errorString);
    public abstract void fatal(String fatalString);
}
