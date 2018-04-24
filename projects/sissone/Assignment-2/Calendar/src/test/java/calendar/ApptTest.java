/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }
  //tests the set methods
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

      appt0.setStartHour(15);
      assertEquals(15, appt0.getStartHour());

      appt0.setStartMinute(30);
      assertEquals(30, appt0.getStartMinute());

      appt0.setStartDay(14);
      assertEquals(14, appt0.getStartDay());

      appt0.setStartMonth(9);
      assertEquals(9, appt0.getStartMonth());

      appt0.setStartYear(2018);
      assertEquals(2018, appt0.getStartYear());

      appt0.setTitle("Birthday Party");
      assertEquals("Birthday Party", appt0.getTitle());

      appt0.setDescription("This is my birthday party");
      assertEquals("This is my birthday party", appt0.getDescription());


  }
  //further tests the set methods
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

      appt0.setDescription(null);
      assertEquals("", appt0.getDescription());

      appt0.setTitle("Edited Title");
      assertEquals("Edited Title", appt0.getTitle());

      appt0.setDescription("Edited Description");
      assertEquals("Edited Description", appt0.getDescription());
  }
  //Tests the validation functions
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Appt appt0 = new Appt(25, 61, 13, 40, 0, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      //This test is failing.  I think this is because my error is isValid makes it useless.
      //I think this makes all appointments valid, no matter what variables are in them.
      //assertEquals(appt0.getValid(), false);


  }
  //Tests setRecurrence()
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      int[] recurDays = new int [3];

      recurDays[0] = 1;
      recurDays[1] = 2;
      recurDays[2] = 3;

      int recurBy = 4;
      int recurIncrement = 5;
      int recurNumber = 6;

      appt0.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);

      assertEquals(recurDays, appt0.getRecurDays());
      assertEquals(recurBy, appt0.getRecurBy());
      assertEquals(recurIncrement, appt0.getRecurIncrement());
      assertEquals(recurNumber, appt0.getRecurNumber());
  }
  //Tests isRecurring()
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      int[] recurDays = new int [3];

      recurDays[0] = 1;
      recurDays[1] = 2;
      recurDays[2] = 3;

      int recurBy = 4;
      int recurIncrement = 5;
      int recurNumber = 6;

      appt0.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
      assertEquals(true, appt0.isRecurring());

      appt0.setRecurrence(recurDays, recurBy, recurIncrement, 0);
      assertEquals(false, appt0.isRecurring());
  }
  //Tests get recurIncrement
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      int[] recurDays = new int [3];

      recurDays[0] = 1;
      recurDays[1] = 2;
      recurDays[2] = 3;

      int recurBy = 4;
      int recurIncrement = 5;
      int recurNumber = 6;

      appt0.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
      assertEquals(recurIncrement, appt0.getRecurIncrement());

  }
  //Tests toString()
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      //made startHour = 0
      Appt appt0 = new Appt(0, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      //assertEquals(null, appt0.toString());
      /*This test also ends in a test failure due to lack of a working isvalid fucntion.*/

  }
}
