package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

 public class CalDayRandomTest {
 	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
 	private static final int NUM_TESTS=100;

 	/**
      * Generate Random Tests that tests CalDay Class.
      */
 	 @Test
 	  public void radnomtest()  throws Throwable  {



 		 long startTime = Calendar.getInstance().getTimeInMillis();
 		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


 		 System.out.println("Start testing...");

 		 try{
 			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {

 				 for (int i = 0; i < NUM_TESTS; i++) {

 				 	// tests the addAppt function

 					 long randomseed =System.currentTimeMillis();

 					 Random random = new Random(randomseed);

 					 int startHour=ValuesGenerator.RandInt(random);
 					 int startMinute=ValuesGenerator.RandInt(random);
 					 int startDay=ValuesGenerator.RandInt(random);
 					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
 					 int startYear=ValuesGenerator.RandInt(random);
 					 String title="Birthday Party";
 					 String description="This is my birthday party.";
					  String emailAddress="xyz@gmail.com";

 					 //Construct a new Appointment object with the randomized data
 					 Appt appt = new Appt(startHour, startMinute ,startDay ,startMonth ,startYear ,title,description, emailAddress);

					 //Initialize GregorianCalendar
 					 int Year = ValuesGenerator.RandInt(random);
 					 int Month = ValuesGenerator.RandInt(random);
 					 int Day = ValuesGenerator.RandInt(random);
 					 GregorianCalendar today = new GregorianCalendar(Year, Month, Day);
 					 CalDay calday = new CalDay(today);

 					 calday.addAppt(appt);

 					 LinkedList<Appt> appts = new LinkedList<Appt>();

 					 if(appt.getValid() == false){
 						 assertEquals(appts, calday.getAppts());
 					 }else {

 					 	appts.add(appt);
 					 	assertEquals(appts, calday.getAppts());

						 //Create a second appointment
 						 int startHour2 = ValuesGenerator.RandInt(random);
 						 int startMinute2 = ValuesGenerator.RandInt(random);
 						 int startDay2 = ValuesGenerator.RandInt(random);
 						 int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
 						 int startYear2 = ValuesGenerator.RandInt(random);
 						 String title2 = "Birthday Party";
 						 String description2 = "This is my birthday party.";
						 String emailAddress2 = "xyz@gmail.com";

 						 Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2, emailAddress2);

 						 calday.addAppt(appt2);
 						 if (startHour2 > startHour) {
 							 	appts.add(appt2);
 							  assertEquals(appts, calday.getAppts());
 						 }

 					 }
 				 }

 				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
 				 if((iteration%10000)==0 && iteration!=0 )
 					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

 			 }
 		 }catch(NullPointerException e){

 		 }

 		 System.out.println("Done testing...");
 	 }


 	 }



 //}