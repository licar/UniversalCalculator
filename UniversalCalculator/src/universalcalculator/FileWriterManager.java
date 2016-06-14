/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class FileWriterManager {
    String fileName;

    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    
    public String getFileName(){
        return fileName;
    }
    
    public FileWriterManager(String fileName) {
        this.fileName = fileName;
    }
    
    public void writeToFile(ArrayList<String> results){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new java.io.FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);
            
            for (String result : results){
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileWriterManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileWriterManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if (bufferedWriter != null)bufferedWriter.close();
                if (fileWriter != null)fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(FileWriterManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
