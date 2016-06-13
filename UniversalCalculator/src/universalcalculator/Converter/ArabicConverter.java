/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator.Converter;
import universalcalculator.constants.Constants;

/**
 *
 * @author user
 */
public class ArabicConverter implements Converter{

    public ArabicConverter() {
    }

    @Override
    public Float convert(String number) throws Exception {
        Float result = 0f;
        if (isValidNumber(number)){
            result = Float.valueOf(number);
        }else{
            throw new Exception("Invalid number");
        }
        return result;
    }
    
    private Boolean isValidNumber(String number){
        Boolean isValidNumber = true;
        Boolean expectDot = true;
        
        for (Integer i = 0; (i != number.length()) && isValidNumber; ++i) {
            if (number.charAt(i) == Constants.DOT_SIGN){
                if (expectDot && (i != 0) && (i < (number.length() - 1)))expectDot = false;
                else isValidNumber = false;
            } else if ((number.charAt(i) == Constants.MINUS_SIGN) && (i != 0)){
                isValidNumber = false;
            }
        }
        return isValidNumber;
    }

    @Override
    public Boolean requareThisConverter(String number) {
        Boolean isThisConverterRequare = true;
        
        for (Integer i = 0; (i != number.length()) && isThisConverterRequare; ++i){
            if (!Character.isDigit(number.charAt(i)) &&
                    (number.charAt(i) != Constants.DOT_SIGN) &&
                    (number.charAt(i) != Constants.MINUS_SIGN)){
                isThisConverterRequare = false;
            }
        }
        return isThisConverterRequare;           
    }
}
