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
public class Parser {
    
    public static String[] parse(String line, String delimeters){
        return line.split("((?<=" + delimeters + ")|(?=" + delimeters + "))");
    }
}
