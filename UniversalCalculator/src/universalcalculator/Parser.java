/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;
import universalcalculator.constants.Constants;
/**
 *
 * @author user
 */
public final class Parser {
    
    public static String[] parse(String line, String delimeters){
        return (line.replaceAll("\\s+","").split("(?=[" + Constants.DELIMETERS  + "])|(?<=[" + Constants.DELIMETERS  + "])"));
    }
}
