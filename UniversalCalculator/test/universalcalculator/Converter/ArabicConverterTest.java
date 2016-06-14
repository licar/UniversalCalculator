/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator.Converter;

import org.junit.Test;
import static org.junit.Assert.*;
import universalcalculator.Formula;

/**
 *
 * @author user
 */
public class ArabicConverterTest {

    @Test
    public void testConvert() throws Exception {
        System.out.println("testConvert");
        ArabicConverter arabicConverter = new ArabicConverter();
        assertEquals(1000f, arabicConverter.convert("1000"), 0.0001);
        assertEquals(999f, arabicConverter.convert("999"), 0.0001);
        assertEquals(12.4f, arabicConverter.convert("12.4"), 0.0001);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test(expected=Exception.class)
    public void testDot() throws Exception {
        System.out.println("testDot");
        ArabicConverter arabicConverter = new ArabicConverter();
        arabicConverter.convert(".");
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test(expected=Exception.class)
    public void testTwoDots() throws Exception {
        System.out.println("TwoDots");
        ArabicConverter arabicConverter = new ArabicConverter();
        arabicConverter.convert("..");
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test(expected=Exception.class)
    public void testDotPlusNumber() throws Exception {
        System.out.println("DotPlusNumber");
        ArabicConverter arabicConverter = new ArabicConverter();
        arabicConverter.convert(".1234");
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testNegativeNumber() throws Exception {
        System.out.println("NegativeNumber");
        ArabicConverter arabicConverter = new ArabicConverter();
        assertEquals(-1234f, arabicConverter.convert("-1234"), 0.001);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testOneDigit() throws Exception {
        System.out.println("OneDigit");
        ArabicConverter arabicConverter = new ArabicConverter();
        assertEquals(1f, arabicConverter.convert("1"), 0.001);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testNegativeFloatNumber() throws Exception {
        System.out.println("NegativeFloatumber");
        ArabicConverter arabicConverter = new ArabicConverter();
        assertEquals(-1234.1f, arabicConverter.convert("-1234.1"), 0.001);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test(expected=Exception.class)
    public void testTwoDotsAfterDigit() throws Exception {
        System.out.println("TwoDotsAfterDigit");
        ArabicConverter arabicConverter = new ArabicConverter();
        arabicConverter.convert("1234.0.0");
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
    @Test(expected=Exception.class)
    public void testDotInEnd() throws Exception {
        System.out.println("DotInEnd");
        ArabicConverter arabicConverter = new ArabicConverter();
        arabicConverter.convert("1234.");
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test(expected=Exception.class)
    public void testTwoMinuses() throws Exception {
        System.out.println("TwoMinuses");
        ArabicConverter arabicConverter = new ArabicConverter();
        arabicConverter.convert("--1234");
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test(expected=Exception.class)
    public void testTwoMinusesAfterDigit() throws Exception {
        System.out.println("TwoMinuses");
        ArabicConverter arabicConverter = new ArabicConverter();
        arabicConverter.convert("-1-234");
        // TODO review the generated test code and remove the default call to fail.
    }
    

    @Test
    public void testRequareThisConverter() {
        System.out.println("testRequareThisConverter");
        ArabicConverter arabicConverter = new ArabicConverter();
        assertTrue(arabicConverter.isAppropriateConverter("123"));
        assertTrue(arabicConverter.isAppropriateConverter("123.1"));
        assertTrue(arabicConverter.isAppropriateConverter("123."));
        assertTrue(!arabicConverter.isAppropriateConverter("123+"));
        assertTrue(!arabicConverter.isAppropriateConverter("123a"));
        assertTrue(arabicConverter.isAppropriateConverter("-123"));
    }
    
}
