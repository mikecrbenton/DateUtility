/*
 * $Id$
 * $Name$
 */

package org.usd.csci.util;

/**
 * Exception to indicate either a null date, a null format or invalid entry
 * 
 * @author Mike Benton CSC470
 */
public class InvalidDateException extends Exception {
    
    /**
     * Default Constructor
     */
    public InvalidDateException() {
        
    }
    
    /**
     *  Constructs an InvalidDateException with a specified message
     * 
     * @param message 
     */
    
    public InvalidDateException(String message) {
        super(message);
    }
    
} //END OF CLASS
