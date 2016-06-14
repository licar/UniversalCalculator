/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import universalcalculator.Converter.ArabicConverter;
import universalcalculator.Converter.Converter;
import universalcalculator.Converter.RomanConverter;
import static universalcalculator.constants.Constants.DELIMETERS;

/**
 * 
 * @author user
 */
public final class Launcher {

    public Launcher(String inputFileName, String outputFileName) {
        FileReaderManager inputFile = null;
        try{
            ArrayList<String> results = new ArrayList<>();
            inputFile = new FileReaderManager(inputFileName);
            ArrayList<Converter> converters = getConverters();
            Calculator calculator = new Calculator(converters);
            String line;
            while ((line = inputFile.readLine()) != null){
                String[] tokens = Parser.parse(line, DELIMETERS);
                Formula formula = new Formula(tokens);
                calculator.setFormula(formula);
                results.add(Boolean.toString(calculator.getExpectResult().equals(calculator.getFormulaResult())));                
            }
            FileWriterManager outputFile = new FileWriterManager(outputFileName);
            outputFile.writeToFile(results);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                inputFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public ArrayList<Converter> getConverters(){
        ArrayList<Converter> converters = new ArrayList();
        converters.add(new ArabicConverter());
        converters.add(new RomanConverter());
        return converters;
    }
}
