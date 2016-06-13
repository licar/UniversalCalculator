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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public final class FileManager {
     
    private BufferedReader bufferedReader = null;
    private FileReader fileReader = null;
    private String filePath = null;
    
    
    public FileManager(String filePath) {
        this.filePath = filePath;
    }
    
    public void open(){
        Boolean isSuccess = true;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String readLine(){
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }
    
    public void writeToFile(ArrayList<String> results){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String result : results){
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fileWriter.close();
                bufferedWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getFileName(){
        return filePath;
    }
    
    public void close(){
        try {
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
