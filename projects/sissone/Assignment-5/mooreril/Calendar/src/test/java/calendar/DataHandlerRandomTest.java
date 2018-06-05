package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import java.util.GregorianCalendar;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

   private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
   private static final int NUM_TESTS=100;

	 /**
		* Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
		*/
   public static int RandomSelectRecur(Random random){
	    int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

	    int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
			return RecurArray[n] ; // return the value of the  appointments to recur
   }
	 /**
		* Return a randomly selected appointments to recur forever or Never recur  !.
		*/
   public static int RandomSelectRecurForEverNever(Random random){
      int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

      int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
      return RecurArray[n] ; // return appointments to recur forever or Never recur
   }


    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
        long startTime = Calendar.getInstance().getTimeInMillis();
				long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

				System.out.println("Start Testing Data Handler...");

				try{
				   for (int iteration = 0; elapsed < TestTimeout; iteration++){
					    long randomseed = System.currentTimeMillis();
							Random random = new Random(randomseed);

							for (int i = 0; i < NUM_TESTS; i++){
							   //Valid Appointment variables
								 int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
								 int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
								 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 int startYear = 2018;
								 String title="Birthday Party";
								 String description="This is my birthday party.";
								 String emailAddress="xyz@gmail.com";

								 //Gets valid day according to month
								 int daysInMonth = CalendarUtil.NumDaysInMonth(startYear, startMonth - 1);
								 int startDay = ValuesGenerator.getRandomIntBetween(random, 1, daysInMonth);

								 //Constructs an appointment with randomly generated data
								 Appt appt1 = new Appt(startHour, startMinute ,startDay ,startMonth ,startYear , title, description, emailAddress);

								 //set recurences for the appt1
								 int length = ValuesGenerator.getRandomIntBetween(random, 0, 8);
								 int[] recurDays = ValuesGenerator.generateRandomArray(random, length);
								 int recur = ApptRandomTest.RandomSelectRecur(random);
								 int recurIncrement = ValuesGenerator.RandInt(random);
								 int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);

								 appt1.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

								 //Create a second appointment
								 startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
								 startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
								 startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 daysInMonth = CalendarUtil.NumDaysInMonth(startYear, startMonth - 1);
								 startDay = ValuesGenerator.getRandomIntBetween(random, 1, daysInMonth);

								 Appt appt2 = new Appt(startHour, startMinute ,startDay ,startMonth ,startYear ,title, description, emailAddress);

								 //create a third appointment
								 startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
								 startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
								 startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 daysInMonth = CalendarUtil.NumDaysInMonth(startYear, startMonth - 1);
								 startDay = ValuesGenerator.getRandomIntBetween(random, 1, daysInMonth);

								 Appt appt3 = new Appt(startHour, startMinute ,startDay ,startMonth ,startYear ,title, description, emailAddress);

								 //Create a fourth appointment
								 startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
								 startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
							 	 startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 daysInMonth = CalendarUtil.NumDaysInMonth(startYear, startMonth - 1);
								 startDay = ValuesGenerator.getRandomIntBetween(random, 1, daysInMonth);

							 	 Appt appt4 = new Appt(startHour, startMinute ,startDay ,startMonth ,startYear ,title, description, emailAddress);

								 //Create a fifth appointment that is NULL
								 Appt appt5 = null;



								 //LinkedList<Appt> appts = new LinkedList<Appt>();

								 /*appts.add(appt1);
								 appts.add(appt2);
								 appts.add(appt3);
								 appts.add(appt4);*/


								 //Initiates Data handler
								 DataHandler dataHandler = new DataHandler();

								 dataHandler.saveAppt(appt1);
								 dataHandler.saveAppt(appt2);
								 dataHandler.saveAppt(appt3);
								 dataHandler.saveAppt(appt4);

								 //Create Gregorian Calendar
								 int year = ValuesGenerator.RandInt(random);
								 int month = ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 int day = ValuesGenerator.getRandomIntBetween(random, 0, 30);

								 GregorianCalendar day1 = new GregorianCalendar(year, month, day);
								 GregorianCalendar day2 = (GregorianCalendar)day1.clone();
								 day2.add(Calendar.DAY_OF_MONTH, 4);

								 //Test getApptRange
								 //LinkedList<CalDay> calDays = new LinkedList<CalDay>();
								 assertNotNull(dataHandler.getApptRange(day1, day2));


								 //Test the deleteAppt function
								 assertEquals(true, dataHandler.deleteAppt(appt1));
								 dataHandler.deleteAppt(appt1);
								 assertEquals(false, dataHandler.deleteAppt(appt1));

								 assertEquals(true, dataHandler.deleteAppt(appt2));
								 dataHandler.deleteAppt(appt2);
								 assertEquals(false, dataHandler.deleteAppt(appt2));

								 assertEquals(true, dataHandler.deleteAppt(appt3));
								 dataHandler.deleteAppt(appt3);
								 assertEquals(false, dataHandler.deleteAppt(appt3));

								 assertEquals(true, dataHandler.deleteAppt(appt4));
								 dataHandler.deleteAppt(appt4);
								 assertEquals(false, dataHandler.deleteAppt(appt4));

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
