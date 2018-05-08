/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  //Test that
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
     Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

  }
  //Tests deleteappt
  //Not working, won't recognize deleteAppt
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
     Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     //assertEquals(appt0.deleteAppt(appt0), true);
     Appt appt1 = new Appt(25, 61, 13, 40, 2018, "", "This is my birtparty", "xyz@gm");
     //assertEquals(appt1.deleteAppt(appt1), true);
  }

}
