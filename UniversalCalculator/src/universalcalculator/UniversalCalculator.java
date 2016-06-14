/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;

/**
 *
 * @author user
 */
public class UniversalCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inputFileName;
        String outputFileName;
        try{
            inputFileName = args[0];
            outputFileName = args[1];
        }catch (Exception e){
            inputFileName = "input.txt";
            outputFileName = "output.txt";
        }
        Launcher calculatorMain = new Launcher(inputFileName, outputFileName);
    }
    
}
