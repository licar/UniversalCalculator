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
    
    /**
     * Convert to Arabia from another sort of number
     * @param number
     * @return
     * @throws Exception
     */
    public Float convert(String number) throws Exception;
    
    /**
     * Method define is it appropriate converter for number
     * @param number
     * @return
     */
    public Boolean isAppropriateConverter(String number); 
}
