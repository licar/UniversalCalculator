/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;

import java.util.ArrayList;
import universalcalculator.constants.Constants;
import universalcalculator.structure.TokenPriority;

/**
 *  This class keep separated math expression and its result in string type. 
 * @author user 
 * 
 */
public final class Formula {
    private ArrayList<TokenPriority> expression = new ArrayList<>();
    private String result = new String();
    
    public Formula(String[] tokens) throws Exception{
        if (isExpectLength(tokens)){
            setResult(tokens);
            setExpression(tokens);
        }else{
            throw new Exception("Too short expression");
        }
    }

    public void setExpression(String[] tokens) throws Exception{
        if (isValidExpression(tokens)){
            expression = setTokensPriority(tokens);
        }else{
            throw new Exception("Invalide expression");
        }
    }
    
    public void setResult(String[] tokens) throws Exception{
        if (tokens[tokens.length - 2].equals(Constants.EQUAL_SIGN) &&
                (Constants.OPERATORS.get(tokens[tokens.length - 1]) == null) &&
                (!tokens[tokens.length - 1].equals(Constants.SPACE_SIGN) &&
                !tokens[tokens.length - 1].isEmpty())){
            result = tokens[tokens.length - 1];
        }else{
            throw new Exception("Invalide formula");
        }
    }
    
    public ArrayList<TokenPriority> getExpression(){
        return this.expression;
    }
    
    public String getResult(){
        return this.result;
    }
    
    private Boolean isExpectLength(String[] tokens){
        Boolean isExpectLength = true;
        
        if (tokens.length < 3){
            isExpectLength = false;
        }
        return isExpectLength;
    }
    
    private Boolean isValidExpression(String[] tokens){
        Boolean isValidExpression = true;
        
        for (Integer i = 0; (i < tokens.length - 2); ++i){
            if (((i % 2 == 0) && ((tokens[i].equals(Constants.EQUAL_SIGN)) || (Constants.OPERATORS.get(tokens[i]) != null))) || 
                    ((i % 2 == 1) && (Constants.OPERATORS.get(tokens[i]) == null)) ||
                    tokens[i].equals(Constants.SPACE_SIGN) || tokens[i].isEmpty()){
                isValidExpression = false;
            }
        }
        return isValidExpression;
    }
    
    
    private ArrayList<TokenPriority> setTokensPriority(String[] tokens){
        ArrayList<TokenPriority> tmpExpression = new ArrayList();
        
        for (Integer i = 0; i < tokens.length - 2; ++i){
            TokenPriority token = new TokenPriority();
            token.setValue(tokens[i]);
            if (i % 2 == 1) token.setPriority(Constants.OPERATORS.get(tokens[i]));
            tmpExpression.add(token);
        }
        return tmpExpression;
    }
}
