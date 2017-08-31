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

/**
 * DateUtility is a utility class with methods to manipulate dates
 * 
 * @author Mike Benton CSC470
 */
public class DateUtility {
    
    
    /**
     * getMonthName    receives a date and returns the name of the month for 
     *                 that date (e.g. January)
     * 
     * @param date     Date object
     * 
     * @return         full month name as a String object
     * 
     * @throws InvalidDateException     If Date is null
     * 
     */
    
    public String getMonthName(Date date) throws InvalidDateException {
        
        if(date == null) {
            throw new InvalidDateException("Date is null");
        }
        
        DateFormat df = new SimpleDateFormat("MMMM");// 4 M's or more returns the full name
        String month = df.format(date);
        return month;
    }
    
    
    /**
     * getMonthAbbreviation    receives a date and returns the name of the month  
     *                         as an abbreviation (e.g. Jan)
     * 
     * @param date             Date object
     * 
     * @return                 abbreviated month name as a String object
     * 
     * @throws InvalidDateException     If Date is null
     * 
     */
    
    public String getMonthAbbreviation(Date date) throws InvalidDateException {
        
        if(date == null) {
            throw new InvalidDateException("Date is null");
        }
        
        DateFormat df = new SimpleDateFormat("MMM");
        String monthAbrev = df.format(date);
        return monthAbrev;
    }
    
    /**
     * getWeekDayName          receives a date and returns the name of the week  
     *                         day represented by the date (e.g. Monday)
     * 
     * @param date             Date object
     * 
     * @return                 weekday name as a String object
     * 
     * @throws InvalidDateException     If Date is null
     * 
     */
    
    public String getWeekDayName(Date date) throws InvalidDateException {
        
        if(date == null) {
            throw new InvalidDateException("Date is null");
        }
        
        DateFormat df = new SimpleDateFormat("EEEE");
        String weekday = df.format(date);
        return weekday;
    } 
    
    
    /**
     * getWeekDayNameAbbreviation    receives a date and returns the abbreviated
     *                               name of the week day represented by the date
     *                               (e.g. Monday)
     * 
     * @param date                   Date object
     * 
     * @return                       abbreviated weekday name as a String object
     * 
     * @throws InvalidDateException  If Date is null
     * 
     */
    
    public String getWeekDayNameAbbreviation(Date date) throws InvalidDateException {
        
        if(date == null) {
            throw new InvalidDateException("Date is null");
        }
        
        DateFormat df = new SimpleDateFormat("EEE");
        String weekdayAbrev = df.format(date);
        return weekdayAbrev;
    }
    
    
    /**
     * getDateString    receives a date and a string representing the desired 
     *                  format and returns the date as a string in the 
     *                  desired format
     * 
     * @param date      Date object
     * @param format    String representing the format
     * 
     * @return          returns a String in the desired format
     * 
     * @throws InvalidDateException     if - the date is null
     *                                     - the format is null
     *                                     - the format is invalid
     */
    
    public String getDateString(Date date, String format) throws 
    InvalidDateException {
        
        if(date == null) {
            throw new InvalidDateException("Date is null");
        } 
        
        if(format == null) {
            throw new InvalidDateException("Format is null");
        } 
        
        String dateString; 
        
        try {
            
             DateFormat df = new SimpleDateFormat(format);
             dateString = df.format(date);
             
        }catch(Exception e) {
            throw new InvalidDateException("Format is invalid");
        }
        return dateString;  
    }
    
    /**
     * getDateFromString    receives a string representing a date and a string 
     *                      representing the format of the date string and 
     *                      returns a date created for the dateString
     * 
     * @param dateString    String representing the date
     * @param format        String representing the format
     * 
     * @return              returns a Date object created from dateString
     * 
     * @throws InvalidDateException     if - dateString is null
     *                                     - dateString is invalid
     *                                     - format is null
     *                                     - format is invalid
     */
    public Date getDateFromString (String dateString, String format) throws
    InvalidDateException{
        
        if(dateString == null) {
            throw new InvalidDateException("dateString is null");
        } 
        if(format == null) {
            throw new InvalidDateException("format is null");
        } 
        
        DateFormat df;      //DateFormat object declaration
        Date returnTheDate; //Date object declaration
        
        try{
            df = new SimpleDateFormat(format);
        }catch(Exception e){
            throw new InvalidDateException("The format is invalid");
        }
        
        try{
            returnTheDate = df.parse(dateString);
        }catch(Exception e){
            throw new InvalidDateException("The dateString is invalid");
        }
        
        return returnTheDate;
    }
    
    /**
     * calculateAge     receives a date will return an integer representing an age 
     * 
     * @param birthdate     Date object
     * 
     * @return              returns an integer representing an age
     * 
     * @throws InvalidDateException  if -date is null
     *                                  -date is after the current date
     */
     public int calculateAge(Date birthdate) throws InvalidDateException {
        
        Date currentDate = new Date();
        int age;
        
        if(birthdate == null) {
            throw new InvalidDateException("The birthdate you entered is null");
        } 
        
        if(currentDate.before(birthdate)){
            throw new InvalidDateException("The date entered is after today's date");
        }
        
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        
        cal1.setTime(birthdate);
        cal2.setTime(currentDate);
        
        //current year - user entered year
        age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR); 
        
        return age;
        
    }
     
    public static int calculateYears(Date date1,Date date2) {
        
        int difference;
        
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        
        cal1.setTime(date1);
        cal2.setTime(date2);
        
        difference = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR); 
        
        return difference;
        
    }
     
     /**
     * getDatesForDayOfWeek     receives and integer representing a year and an 
     *                          integer representing a day of the week and returns
     *                          a list of dates representing a given day of the week
     * 
     * @param year              integer representing the year
     * @param dayOfWeek         integer representing the day of the week(sun-sat)
     * 
     * @return                  returns a List object of all the requested days
     * 
     * @throws InvalidDateException     if the year is than or equal to 0 or day 
     *                                  of week is not between 1-7 
     */
    
     
     //MAIN - CURRENT CODE TO RUN calculateYears() METHOD
     
     public static void main(String[] args)throws Exception {
       
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
         Date date1 = df.parse("01/10/2012");
         Date date2 = df.parse("01/10/2000");
         
         int result;
         
         result = calculateYears(date2,date1);
         System.out.print(result);
    } 
     
    public List<Date> getDatesForDayOfWeek (int year, int dayOfWeek) throws
    InvalidDateException {
        
        if(year <= 0 || (dayOfWeek < 1 || dayOfWeek > 7) ){
            throw new InvalidDateException("Incorrect input: year or day of week");
        }
        
        List<Date> dateList = new ArrayList<Date>();
        
        //int year converted to a String format 
        String intYearToString = Integer.toString(year);
        intYearToString = intYearToString+"/01/01";
        
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        
        try{
            cal.setTime(sdf.parse(intYearToString));
            cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        }catch(Exception e){
            throw new InvalidDateException("String parsing error");
        }
        
        while(cal.get(Calendar.YEAR) != year+1){
            
            dateList.add(cal.getTime()); //returns a date object
            cal.add(Calendar.DAY_OF_WEEK, 7);   
        }
        
        return dateList;
    }
    
    
    
} //END OF CLASS
