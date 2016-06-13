/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator.constants;

import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class Constants {
    public static final String DELIMETERS = "+-*/=";
    public static final String EQUAL_SIGN = "=";
    public static final String SPACE_SIGN = " ";
    public static final String MULT_SIGN = "*";
    public static final String DIV_SIGN = "/";
    public static final String SUM_SIGN = "+";
    public static final String DIFF_SIGN = "-";
    public static final Character DOT_SIGN = '.';
    public static final Character MINUS_SIGN = '-';
    public static HashMap<String,Integer> OPERATORS = new HashMap<String,Integer>() {};
    static {
        HashMap<String,Integer> operators = new HashMap<String,Integer>() {};
        operators.put("+", 1);
        operators.put("-", 1);
        operators.put("*", 2);
        operators.put("/", 2);
        OPERATORS = operators;
    } 
            
}
