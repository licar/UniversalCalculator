/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator.Converter;

import java.util.HashMap;

/**
 *
 * @author user
 */
public class RomanConverter implements Converter{
    
    HashMap<Character, Float> romanDigits;
    
    public RomanConverter() {
        this.romanDigits = new HashMap();
        romanDigits.put('M', 1000f);
        romanDigits.put('D', 500f);
        romanDigits.put('C', 100f);
        romanDigits.put('L', 50f);
        romanDigits.put('X', 10f);
        romanDigits.put('V', 5f);
        romanDigits.put('I', 1f);
    }
    
    @Override
    public Float convert(String number) throws Exception{
        Float result = 0f;
        if (isValidNumber(number)){
            result = colculate(number);
        }else{
            throw new Exception("Invalid number");
        }
        return result;
    }
    
    private Float colculate(String number){
        Float result = 0f;
        Float digitValue;
        Float nextDigitValue;
        
        for (Integer i = 0; i != number.length(); ++i){
            digitValue = getDigitValue(number.charAt(i));
            if (i < number.length() - 1){
                nextDigitValue = getDigitValue(number.charAt(i + 1));
                result += (digitValue >= nextDigitValue) ? digitValue : -digitValue;
            }else{
                result += digitValue;
            }
        }
        return result;
    }
    
    private Float getDigitValue(Character digit){
        Float digitValue;
        if (Character.isLowerCase(digit)){
            digitValue = romanDigits.get(Character.toUpperCase(digit)) / 1000;
        }else{
            digitValue = romanDigits.get(digit);
        }
        return digitValue;
    }
    
    private Boolean isValidNumber(String number){
        Boolean isValidNumber = true;
        Boolean expectLower = false;
        for (Integer i = 0; (i != number.length()) && isValidNumber; ++i) 
        {
            if (!expectLower && Character.isLowerCase(number.charAt(i))){
                expectLower = true;
            }else if (expectLower && Character.isUpperCase(number.charAt(i))){
                isValidNumber = false;
            }
        }
        return isValidNumber;
    }

    @Override
    public Boolean requareThisConverter(String number) {
        Boolean isThisConverterRequare = true;
        for (Integer i = 0; (i != number.length()) && isThisConverterRequare; ++i){
            if (romanDigits.get(Character.toUpperCase(number.charAt(i))) == null)
            {
                isThisConverterRequare = false;
            }
        }
        return isThisConverterRequare;           
    }
}
