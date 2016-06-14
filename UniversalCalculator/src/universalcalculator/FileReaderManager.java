/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public FileReaderManager(String filePath) {
        this.fileName = filePath;
        open();
    }
    
    public void open(){
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String readLine() throws IOException{
        String line = null;
        line = bufferedReader.readLine();
        return line;
    }

    public void close() throws IOException{
        if (bufferedReader != null) bufferedReader.close();
        if (fileReader != null) fileReader.close();
    }
}
