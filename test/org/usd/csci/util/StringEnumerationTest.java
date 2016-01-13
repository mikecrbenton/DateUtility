/*
 * $Id$
 * $Name$
 */

package org.usd.csci.util;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * StringEnumerationTest for StringEnumeration Class
 * 
 * @author Mike Benton CSC470
 */
public class StringEnumerationTest {
    
    public StringEnumerationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     *  Test of StringEnumeration Constructor for null String
     */
    @Test
    public void testStringEnumerationConstructorNull(){
        
        try{ 
            StringEnumeration testNull = new StringEnumeration(null);
            fail("An InvalidStringException was not thrown");
        }catch(InvalidStringException e){
            System.out.println(e.getMessage());
        } 
    }
    
    /**
     * Test of StringEnumeration Constructor for String with 0
     * characters
     */
    @Test
    public void testStringEnumerationConstructorZero(){
        
        try{ 
            StringEnumeration testNull = new StringEnumeration("");
            fail("An InvalidStringException was not thrown");
        }catch(InvalidStringException e){
            System.out.println(e.getMessage());
        } 
    }
    
    /**
     * Test of hasMoreElements method, of class StringEnumeration.
     */
    @Test
    public void testHasMoreElements() throws Exception {
        
        System.out.println("hasMoreElements");
        
        //CREATE INSTANCE OF CLASS WITH STRING
        StringEnumeration instance = new StringEnumeration("Hello");
        
        boolean expResult = true;
        
        boolean result = instance.hasMoreElements();
        assertEquals(expResult, result);
    }

    /**
     * Test of nextElement method, of class StringEnumeration.
     */
    @Test
    public void testNextElement() throws Exception {
        
        System.out.println("nextElement");
        
        StringEnumeration instance = new StringEnumeration("Hello");
        
        Object expResult = "Hello";
        
        //LIST TO ITERATE THROUGH STRING IN nextElement METHOD
        ArrayList<Object> list = new ArrayList<Object>();

        //ITERATE THROUGH EACH CHAR IN STRING TO ADD TO ARRAYLIST
        while(instance.hasMoreElements()){
            
            Object c = instance.nextElement();
            list.add(c);
        }
        
        //INITIALIZE STRING TO EMPTY
        String result = "";
        
        //ITERATE THROUGH ARRAYLIST AND AND ADD TO STRING
        for (Object s : list){
            result += s.toString() ;
        }
        
        //PASS STRING AS RESULT, SINCE A STRING IS AN OBJECT
        assertEquals(expResult, result);
        
    }
    
}
