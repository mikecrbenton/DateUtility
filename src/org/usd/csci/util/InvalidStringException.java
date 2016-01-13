/*
 * $Id$
 * $Name$
 */

package org.usd.csci.util;

/**
 * Exception to indicate either a mull String or 0 characters in String
 * 
 * @author Mike Benton CSC470
 */

public class InvalidStringException extends Exception {
    
    /**
     * Default Constructor
     */
    
    public InvalidStringException() {
        
    }
    
    /**
     *  Constructs an InvalidDateException with a specified message
     * 
     * @param message 
     */
    
    public InvalidStringException(String message) {
        super(message);
    }
    
}//END OF CLASS 
