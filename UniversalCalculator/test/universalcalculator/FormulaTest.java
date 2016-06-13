/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import universalcalculator.structure.TokenPriority;

/**
 *
 * @author user
 */
public class FormulaTest {

    /**
     * Test of setExpression method, of class Formula.
     */
    @Test
    public void testSetValidExpression() throws Exception {
        System.out.println("setValidExpression");
        String[] tokens = new String[7];
        tokens[0] = "0";
        tokens[1] = "+";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "12";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetExpressionWithRomanDigits() throws Exception {
        System.out.println("setExpressionWithRomanDigits");
        String[] tokens = new String[7];
        tokens[0] = "MDA";
        tokens[1] = "+";
        tokens[2] = "22";
        tokens[3] = "*";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "12";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
     @Test
    public void testSetExpressionWith3Arg() throws Exception {
        System.out.println("setExpressionWith3Arg");
        String[] tokens = new String[3];
        tokens[0] = "MDA";
        tokens[1] = "=";
        tokens[2] = "12";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testSetExpressionWithTwoNeighborsSigns() throws Exception {
        System.out.println("setExpressionWithTwoNeighborsSigns");
        String[] tokens = new String[7];
        tokens[0] = "+";
        tokens[1] = "+";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "12";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testSetWithoutExpression() throws Exception {
        System.out.println("setWithoutExpression");
        String[] tokens = new String[2];
        tokens[0] = "=";
        tokens[1] = "12";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testEmptyFormula() throws Exception {
        System.out.println("emptyFormula");
        String[] tokens = new String[0];
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testEqualsIsExpression() throws Exception {
        System.out.println("equalsIsExpression");
        String[] tokens = new String[7];
        tokens[0] = "1";
        tokens[1] = "=";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "12";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testResultIsSign() throws Exception {
        System.out.println("resultIsSign");
        String[] tokens = new String[7];
        tokens[0] = "1";
        tokens[1] = "=";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "*";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testSignInsteadNumber() throws Exception {
        System.out.println("signInsteadNumber");
        String[] tokens = new String[7];
        tokens[0] = "+";
        tokens[1] = "+";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "10";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testOnlyNumbersIsExpression() throws Exception {
        System.out.println("onlyNumbersIsExpression");
        String[] tokens = new String[7];
        tokens[0] = "22";
        tokens[1] = "11";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "12";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testEmptyInsteadNumber() throws Exception {
        System.out.println("emptyInsteadNumber");
        String[] tokens = new String[7];
        tokens[0] = "";
        tokens[1] = "+";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "2";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testSpaceInsteadResult() throws Exception {
        System.out.println("spaceInsteadResult");
        String[] tokens = new String[7];
        tokens[0] = "1";
        tokens[1] = "+";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = " ";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testEmptyInsteadResult() throws Exception {
        System.out.println("emptyInsteadResult");
        String[] tokens = new String[7];
        tokens[0] = "1";
        tokens[1] = "+";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testSpaceInsteadNumber() throws Exception {
        System.out.println("emptyInsteadResult");
        String[] tokens = new String[7];
        tokens[0] = " ";
        tokens[1] = "+";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "2";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testEmptyInsteadEquals() throws Exception {
        System.out.println("emptyInsteadEquals");
        String[] tokens = new String[7];
        tokens[0] = "1";
        tokens[1] = "+";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = " ";
        tokens[6] = "2";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testEmptyInsteadSign() throws Exception {
        System.out.println("emptyInsteadSign");
        String[] tokens = new String[7];
        tokens[0] = "1";
        tokens[1] = "";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "2";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
    @Test(expected=Exception.class)
    public void testSpaceInsteadSign() throws Exception {
        System.out.println("spaceInsteadSign");
        String[] tokens = new String[7];
        tokens[0] = "1";
        tokens[1] = " ";
        tokens[2] = "22";
        tokens[3] = "-";
        tokens[4] = "1";
        tokens[5] = "=";
        tokens[6] = "2";
        Formula instance = new Formula(tokens);
        instance.setExpression(tokens);
    }
    
}
