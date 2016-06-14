/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author user
 */
public final class FileReaderManager {
     
    private BufferedReader bufferedReader;
    private FileReader fileReader;
    private String fileName;
    
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    
    public String getFileName(){
        return fileName;
    }
    
    public FileReaderManager(String filePath) throws FileNotFoundException {
        this.fileName = filePath;
        open();
    }
    
    public void open() throws FileNotFoundException{
        fileReader = new FileReader(fileName);
        bufferedReader = new BufferedReader(fileReader);
    }
    
    public String readLine() throws IOException{
        return bufferedReader.readLine();
    }

    public void close() throws IOException{
        if (bufferedReader != null) bufferedReader.close();
        if (fileReader != null) fileReader.close();
    }
}
