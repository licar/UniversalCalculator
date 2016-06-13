/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator.Converter;
/**
 *
 * @author user
 */
public interface Converter {
    
    public Float convert(String number) throws Exception;
    
    public Boolean requareThisConverter(String number); 
}
