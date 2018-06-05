package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }
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
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data
				 //Construct a new Appointment object with the initial data
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
						 }
						 if(methodName.equals("setRecurDays")){
							 int[] recurDaysArray = null;
							 recurDaysArray[0] = 1;
							 recurDaysArray[1] = 2;
							 recurDaysArray[2] = 3;
							 int recurBy = 6;
							 int recurIncrement = 7;
							 int recurNumber = 8;
							 appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, recurNumber);

							 int[] empty = new int[0];
							 int[] array = appt.getRecurDays();

							 assertEquals(array, empty);

							 //Test for a null array
							 int[] nullarray = null;
							 appt.getRecurDays();
							 assertEquals(null, nullarray);
						 }
						 if(methodName.equals("setValid")){
							 boolean result = true;
							 int ranint = ValuesGenerator.getRandomIntBetween(random, -3, 98);
							 int ran_startMinute = ValuesGenerator.getRandomIntBetween(random, -5, 100);
							 int ran_startHour = ValuesGenerator.getRandomIntBetween(random, -5, 100);
							 int ran_startDay = ValuesGenerator.getRandomIntBetween(random, -5, 100);
							 int ran_startMonth = ValuesGenerator.getRandomIntBetween(random, -5, 100);

							 appt.setStartHour(ran_startHour);
							 appt.setStartMinute(ran_startMinute);
							 appt.setStartMonth(ran_startMonth);

							 if(ran_startHour <= 0 || ran_startHour > 23){
								 result = false;
							 }
							 else{
								 if(ran_startMinute < 0 || ran_startMinute > 59){
									 result = false;
								 }
								 else{
									 if(ran_startMonth < 1 || ran_startMonth > 12){
										 result = false;
									 }
										 else{
											 int daysInMonth = CalendarUtil.NumDaysInMonth(startYear, ran_startMonth - 1);
											 appt.setStartDay(ran_startDay);
											 if(ran_startDay < 1 || ran_startDay > daysInMonth){
												 result = false;
											 }
											 else{
												 result = true;
											 }
										 }
									 }
								 }
								 assertEquals(result, appt.getValid());
							 }
						 if(methodName.equals("isOn")){
								boolean result = true;
								int ranint = ValuesGenerator.getRandomIntBetween(random, -3, 98);
								int ran_startMinute = ValuesGenerator.getRandomIntBetween(random, -5, 100);
								int ran_startHour = ValuesGenerator.getRandomIntBetween(random, -5, 100);
								int ran_startDay = ValuesGenerator.getRandomIntBetween(random, -5, 100);
								int ran_startMonth = ValuesGenerator.getRandomIntBetween(random, -5, 100);
								int ran_startYear = ValuesGenerator.getRandomIntBetween(random, -5, 100);

								if(ran_startDay == appt.getStartDay() && ran_startMonth == appt.getStartMonth() && ran_startYear == appt.getStartYear()){
									assertEquals(true, appt.isOn(ran_startDay, ran_startMonth, ran_startYear));
								}
								else{
									assertEquals(false, appt.isOn(ran_startDay, ran_startMonth, ran_startYear));
								}
								ran_startDay = appt.getStartDay();
								ran_startMonth = appt.getStartMonth();
								ran_startYear = appt.getStartYear();
								assertEquals(true, appt.isOn(ran_startDay, ran_startMonth, ran_startYear));
							 }


					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
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
