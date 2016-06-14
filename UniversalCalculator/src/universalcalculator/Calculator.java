/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;

import java.util.ArrayList;
import universalcalculator.Converter.Converter;
import universalcalculator.constants.Constants;
import universalcalculator.structure.TokenPriority;

/**
 *
 * @author user
 */
public final class Calculator {
    private Formula formula;
    private final ArrayList<Converter> converters;
    private Float formulaResult;
    private Float expectResult;
    
    public Calculator(Formula formula, ArrayList<Converter> converters) throws Exception {
        this.formula = formula;
        this.converters = converters;
        updateResults();
    }
    
    public Calculator(ArrayList<Converter> converters) throws Exception {
        this.converters = converters;
    }
    
    public void  updateResults() throws Exception
    {
        formulaResult = colculate();
        expectResult = convert(formula.getResult());
    }
    
    public void setFormula(Formula formula) throws Exception{
        this.formula = formula;
        updateResults();
    }
    
    public Formula getFormula(){ 
        return formula;
    }
    
    public Float getExpectResult(){
        return expectResult;
    }
    
    public Float getFormulaResult(){
        return formulaResult;
    }
    
    public Float colculate() throws Exception{
        if (formula == null) throw new Exception("Require formula for colculation");
        if (converters == null) throw new Exception("Require converters");
        ArrayList<TokenPriority> expression = formula.getExpression();
        Integer i = 0;
        Integer iteration = 1;
        Float firstOperand;
        Float secondOperand;
        String result = null;
        while (expression.size() != 1){
            if ((iteration == 1 && expression.get(i).getPriority() == 2) || 
                 (iteration == 2 && expression.get(i).getPriority() == 1)){
                
                firstOperand = convert(expression.get(i - 1).getValue());
                secondOperand = convert(expression.get(i + 1).getValue()); 
                
                if (iteration == 1 && expression.get(i).getPriority() == 2){
                    if (expression.get(i).getValue().equals(Constants.MULT_SIGN)){
                        result = Float.toString(firstOperand * secondOperand);
                    } else if(expression.get(i).getValue().equals(Constants.DIV_SIGN)){
                        result = Float.toString(firstOperand / secondOperand);
                    }
                }else if (iteration == 2 && expression.get(i).getPriority() == 1){
                    if (expression.get(i).getValue().equals(Constants.SUM_SIGN)){
                        result = Float.toString(firstOperand + secondOperand);
                    } else if(expression.get(i).getValue().equals(Constants.DIFF_SIGN)){
                        result = Float.toString(firstOperand - secondOperand);
                    }
                }
                expression.set((i - 1), new TokenPriority(result));
                expression.remove(i + 1);
                expression.remove(i.intValue());
                --i;
            }
            if (i == expression.size() - 1){
                ++iteration;
                i = 0;
            }else ++i;
        }
        return convert(expression.get(0).getValue());
    }
    
    
    private Float convert(String number) throws Exception{
        Boolean foundConverter = false;
        Float result = null;
        for (Integer i = 0; i != converters.size() && foundConverter == false; ++i){
            if (converters.get(i).isAppropriateConverter(number)){
                foundConverter = true;
                result = converters.get(i).convert(number);
            }
        }
        if (!foundConverter) throw new Exception("Not found appropriate converter");
        
        return result;
    }

}
