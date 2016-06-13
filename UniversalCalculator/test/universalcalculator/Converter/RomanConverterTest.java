/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator.Converter;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class RomanConverterTest {
    
    public RomanConverterTest() {
    }

    @Test
    public void testConvert() throws Exception {
        System.out.println("testConvert");
        RomanConverter romanConverter = new RomanConverter();
        assertEquals(1010, romanConverter.convert("MX"), 0.001); 
        assertEquals(1000, romanConverter.convert("M"), 0.001);
        assertEquals(1, romanConverter.convert("I"), 0.001);
        assertEquals(1666, romanConverter.convert("MDCLXVI"), 0.001);
        assertEquals(500, romanConverter.convert("DM"), 0.001);
        assertEquals(4, romanConverter.convert("IV"), 0.001);
        assertEquals(20, romanConverter.convert("XX"), 0.001);
        assertEquals(10.01, romanConverter.convert("Xx"), 0.0001);
        assertEquals(10.015, romanConverter.convert("Xxv"), 0.0001);
        assertEquals(10.015, romanConverter.convert("Xxv"), 0.0001);
        assertEquals(0.001, romanConverter.convert("i"), 0.0001);
        assertEquals(1.666, romanConverter.convert("mdclxvi"), 0.0001);
    }
    
    @Test(expected=Exception.class)
    public void testInvalidConvert() throws Exception {
        System.out.println("testInvalidConvert");
        RomanConverter romanConverter = new RomanConverter();
        romanConverter.convert("1");
    }
    
    @Test(expected=Exception.class)
    public void testInvalidCaseSequence() throws Exception {
        System.out.println("InvalidCaseSequence");
        RomanConverter romanConverter = new RomanConverter();
        romanConverter.convert("xMx");
    }
    
    @Test(expected=Exception.class)
    public void testInvalidCaseSequence2() throws Exception {
        System.out.println("InvalidCaseSequence");
        RomanConverter romanConverter = new RomanConverter();
        romanConverter.convert("xX");
    }
    
    @Test
    public void testRequareThisConverter() {
        System.out.println("testRequareThisConverter");
        RomanConverter romanConverter = new RomanConverter();
        assertTrue(romanConverter.requareThisConverter("MX"));
        assertTrue(romanConverter.requareThisConverter("mx"));
        assertTrue(romanConverter.requareThisConverter("mxM"));
        assertFalse(romanConverter.requareThisConverter("-mx"));
        assertFalse(romanConverter.requareThisConverter("MX1"));
    }
    
}
