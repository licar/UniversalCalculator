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
        String inputFileName = args[0] != null ? args[0] : "input.txt";
        String outoutFileName = args[0] != null ? args[1] : "output.txt";
        Launcher calculatorMain = new Launcher(inputFileName, outoutFileName);
    }
    
}
