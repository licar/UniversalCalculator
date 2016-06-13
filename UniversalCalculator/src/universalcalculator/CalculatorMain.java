/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;

import java.util.ArrayList;
import universalcalculator.Converter.ArabicConverter;
import universalcalculator.Converter.Converter;
import universalcalculator.Converter.RomanConverter;
import static universalcalculator.constants.Constants.DELIMETERS;

/**
 *
 * @author user
 */
public final class CalculatorMain {

    public CalculatorMain(String inputFileName, String outputFileName) {
        FileManager inputFile = null;
        FileManager outputFile = null;
        try{
            ArrayList<String> results = new ArrayList<>();
            inputFile = new FileManager(inputFileName);
            outputFile = new FileManager(outputFileName);
            String line;
            while ((line = inputFile.readLine()) != null){
                String[] tokens = Parser.parse(line, DELIMETERS);
                Formula formula = new Formula(tokens);
                ArrayList<Converter> converters = getConverters();
                Calculator calculator = new Calculator(formula, converters);
                results.add(Boolean.toString(calculator.getExpectResult().equals(calculator.getFormulaResult())));                
            }
            outputFile.writeToFile(results); 
        } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            inputFile.close();
            outputFile.close();
        }
    }
    
    public ArrayList<Converter> getConverters(){
        ArrayList<Converter> converters = null;
        converters.add(new ArabicConverter());
        converters.add(new RomanConverter());
        return converters;
    }
}
