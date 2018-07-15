package app.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Abdulhamid M. Talib
 * @since July 14, 2018
 * @version 1.0
 * */
public class Util {

	private static AtomicInteger ai = new AtomicInteger(100);

	/**
	 * @return integer.
	 * */
	public static int generateId() {
		return ai.incrementAndGet();
	} // End method
	
	/**
	 * Add days to java.util.Date.
	 * @return java.util.Date;
	 * */
	public static Date addDaysToDate(Date date, int numberOfDays) {
		if (date == null) {
			return null;
		}
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, numberOfDays);
		
		return cal.getTime();
	} // End method
	
	/**
	 * Returns current date.
	 * 
	 * @return java.util.Date;
	 * */
	public static Date getCurrentDate() {
		Date d = java.sql.Date.valueOf(LocalDate.now() );
		return d;
	} // End method
	
	/**
	 * Returns a string-date based on the given format.
	 * */
	public static String extractDateDetails(String format, Date date) {
		if (date == null) {
			return "";
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return new SimpleDateFormat(format).format(cal.getTime() );
	} // End method
	
	public static String paddRightSpace(int numOfSpace, String str) {
		if (str == null) {
			str = "";
		}  
		
		int n = numOfSpace - str.length();
		
		for (int x = 0; x < n; x++) {
			str = str + " ";
		}
		
		return str;
	} // End method
	
}
