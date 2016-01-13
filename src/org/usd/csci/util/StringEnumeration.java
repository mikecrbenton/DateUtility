/*
 * $Id$
 * $Name$
 */

package org.usd.csci.util;

import java.util.Enumeration;
import java.util.Scanner;

/**
 * StringEnumeration is a class that receives a String and returns individual elements
 * 
 * @author Mike Benton CSC470
 */

public class StringEnumeration implements Enumeration {
   
    String testString; //INITIALIZED IN CONSTRUCTOR
    int counter = -1;
    
    //CONSTRUCTOR
    public StringEnumeration(String message)throws InvalidStringException{ 
        
        if(message == null) {
            throw new InvalidStringException("String is null");
        }
        
        if(message.length() <= 0) {
            throw new InvalidStringException("There are 0 characters in your entry");
        } 
        
        testString = message;
        testString.trim(); //TRIM ANY LEADING/TRAILING WHITESPACE
    }
    
    /**
     * hasMoreElements    receives no parameter and returns a boolean true if a
     *                    String has more elements, and returns false if there
     *                    are no more elements
     * 
     * @return            boolean 
     */
    @Override
    public boolean hasMoreElements(){
        
        if(counter == (testString.length() - 1) ){
            return false;
        }  
        else{
            return true;
        }
    }
    
    /**
     * nextElement    receives no parameter and returns a character as an
     *                Object
     * 
     * @return        Object (as a Character Object)
     */
        
    @Override
    public Object nextElement(){
        
        counter++;
        Character charObject = testString.charAt(counter);
        return charObject;
        
    }
       
} //END OF CLASS
