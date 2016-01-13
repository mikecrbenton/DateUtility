/*
 * $Id$
 * $Name$
 */

package org.usd.csci.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * DateUtilityTest is the JUnit test class for DateUtility Class
 * 
 * @author Mike Benton CSC470
 */
public class DateUtilityTest {
    
    public DateUtilityTest() {
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
     * Test of getMonthName method, of class DateUtility.
     */
    @Test
    public void testGetMonthName() throws Exception {
        
        System.out.println("getMonthName");
        
        //create a date
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = formatter.parse("08/21/88");
        
        //create an instance of DateUtility Class
        DateUtility instance = new DateUtility();
        
        //set the expected return
        String expResult = "August";
        
        //call getMonthName with the Date of 8/21/88
        String result = instance.getMonthName(date);
        
        assertEquals(expResult, result);
        
        //CHECK FOR A NULL DATE
        try{
            Date nullDate = null;
            result = instance.getMonthName(nullDate);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of getMonthAbbreviation method, of class DateUtility.
     */
    @Test
    public void testGetMonthAbbreviation() throws Exception {
        
        System.out.println("getMonthAbbreviation");
        
        //create a date 
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = formatter.parse("11/03/88");
        
        //create/instansiate an instance of DateUtility Class
        DateUtility instance = new DateUtility();
        
        //set the expected return
        String expResult = "Nov";
        
        //call getMonthName with the Date of 11/03/76
        String result = instance.getMonthAbbreviation(date);
        
        assertEquals(expResult, result);
        
        //CHECK FOR A NULL DATE 
        try{
            Date nullDate = null;
            result = instance.getMonthAbbreviation(nullDate);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of getWeekDayName method, of class DateUtility.
     */
    @Test
    public void testGetWeekDayName() throws Exception {
        
        System.out.println("getWeekDayName");
        
        //create a date
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = formatter.parse("9/1/14");
        
        DateUtility instance = new DateUtility();
        
        String expResult = "Monday";
        String result = instance.getWeekDayName(date);
        assertEquals(expResult, result);
        
        //CHECK FOR NULL DATE
        try{
            Date nullDate = null;
            result = instance.getWeekDayName(nullDate);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * Test of getWeekDayNameAbbreviation method, of class DateUtility.
     */
    @Test
    public void testGetWeekDayNameAbbreviation() throws Exception {
        
        System.out.println("getWeekDayNameAbbreviation");
        
        //create a date
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = formatter.parse("9/1/14");
        
        DateUtility instance = new DateUtility();
        
        String expResult = "Mon";
        String result = instance.getWeekDayNameAbbreviation(date);
        assertEquals(expResult, result);
        
        //CHECK FOR A NULL DATE
        try{
            Date nullDate = null;
            result = instance.getWeekDayNameAbbreviation(nullDate);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of getDateString method, of class DateUtility.
     */
    @Test
    public void testGetDateString() throws Exception {
        
        System.out.println("getDateString");
        
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = formatter.parse("09/01/14"); 
        
        String format = "MM/dd/yy";
        
        DateUtility instance = new DateUtility();
        
        String expResult = "09/01/14";
        String result = instance.getDateString(date, format);
        assertEquals(expResult, result);
        
        //CHECK FOR NULL DATE
        try{
            Date nullDate = null;
            result = instance.getDateString(nullDate,format);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        
        //CHECK FOR NULL STRING
        try{
            String nullString = null;
            result = instance.getDateString(date,nullString);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        
        //CHECK FOR INVALID STRING
        try{
            String invalidString = "mike";
            result = instance.getDateString(date,invalidString);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
       
    }

    /**
     * Test of getDateFromString method, of class DateUtility.
     */
    @Test
    public void testGetDateFromString() throws Exception {
        
        System.out.println("getDateFromString");
        
        String dateString = "09/01/14";
        String format = "MM/dd/yy";
        
        DateUtility instance = new DateUtility();
        
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date expResult = formatter.parse("09/01/14"); 
        Date result = instance.getDateFromString(dateString, format);
        assertEquals(expResult, result);
        
        //CHECK FOR NULL STRING
         try{
            String nullString = null;
            result = instance.getDateFromString(nullString,format);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        
         //CHECK FOR NULL FORMAT
        try{
            String nullFormat = null;
            result = instance.getDateFromString(dateString,nullFormat);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        
        //CHECK FOR INVALID STRING
        try{
            String invalidString = "mike";
            result = instance.getDateFromString(dateString,invalidString);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * Test of calculateAge method, of class DateUtility.
     */
    @Test
    public void testCalculateAge() throws Exception {
        
        System.out.println("calculateAge");
        
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = formatter.parse("08/21/88");
        
        DateUtility instance = new DateUtility();
        
        int expResult = 26;
        int result = instance.calculateAge(date);
        assertEquals(expResult, result);
        
        //CHECK FOR NULL DATE
        try{
            Date nullDate = null;
            result = instance.calculateAge(nullDate);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        
        //CHECK IF THE DATE IS AFTER THE CURRENT(TODAY)
        try{
            Date afterCurrentDate = new Date();                

            Calendar cal = new GregorianCalendar();
            cal.setTime(afterCurrentDate);    //SET THE CALENDER TO TODAYS DATE
            cal.add(Calendar.DATE, 7);        //ADD 7 DAYS PAST TODAYS DATE
            afterCurrentDate = cal.getTime(); //DATE OBJECT IS NOW 7 DAYS PAST TODAY
            
            result = instance.calculateAge(afterCurrentDate);
            fail("An Invalid Date Exception was not thrown");
            
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of getDatesForDayOfWeek method, of class DateUtility.
     */
    @Test
    public void testGetDatesForDayOfWeek() throws Exception {
        
        System.out.println("getDatesForDayOfWeek");
        
        int year = 2014;
        int dayOfWeek = 1;
        
        DateUtility instance = new DateUtility();
        
        List<Date> expResult = new ArrayList<Date>();
        
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        Date dateAfterCurrent = format.parse("01/01/14");
        
        Calendar cal = Calendar.getInstance();    //CREATE NEW CALENDER
        cal.setTime(dateAfterCurrent);            //SET TIME ACCORDING TO DATE
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek); //SET DAY OF WEEK TO 1
        
        //LOOP THROUGH THE CURRENT YEAR
        while(cal.get(Calendar.YEAR) != year+1){
            
            expResult.add(cal.getTime());     //RETURNS A DATE OBJECT INTO LIST
            cal.add(Calendar.DAY_OF_WEEK, 7); //INCREMENT THE WEEK BY 1 (7DAYS)
        }
        
        //COMPARE THE LISTS
        List<Date> result = instance.getDatesForDayOfWeek(year, dayOfWeek);
        assertEquals(expResult, result);
        
        //CHECK FOR INVALID YEAR
        try{
            int invalidYear = 0;
            result = instance.getDatesForDayOfWeek(invalidYear,dayOfWeek);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        
        //CHECK FOR DAY OF WEEK LESS THAN 1
        try{
            int invalidDayOfWeek = 0;
            result = instance.getDatesForDayOfWeek(year,invalidDayOfWeek);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        
        //CHECK FOR DAY OF WEEK OVER 7
        try{
            int invalidDayOfWeek = 8;
            result = instance.getDatesForDayOfWeek(year,invalidDayOfWeek);
            fail("An Invalid Date Exception was not thrown");
        }catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
            
    }
    
}//END OF TEST CLASS
