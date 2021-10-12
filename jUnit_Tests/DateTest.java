/**
 * This is the JUnit test file to test Date's isValid() method.
 *
 * @author Jason Li, John Leng
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void isValid() {
        Date date1 = new Date("05/31/2021");
        assertTrue(date1.isValid());

        Date date2 = new Date("08/31/2021");
        assertTrue(date2.isValid());

        Date date4 = new Date("09/30/2021");
        assertTrue(date4.isValid());

        Date date18 = new Date("3/22/2021");
        assertTrue(date18.isValid());

        Date date19 = new Date("6/09/2021");
        assertTrue(date19.isValid());

        Date date6 = new Date("02/25/2021");
        assertTrue(date6.isValid());

        Date date3 = new Date("12/31/2021");
        assertFalse(date3.isValid());

        Date date5 = new Date("11/30/2021");
        assertFalse(date5.isValid());

        Date date7 = new Date("03/22/2020");
        assertFalse(date7.isValid());

        Date date8 = new Date("09/26/2022");
        assertFalse(date8.isValid());

        Date date9 = new Date("01/33/2000");
        assertFalse(date9.isValid());

        Date date10 = new Date("03/33/2000");
        assertFalse(date10.isValid());

        Date date11 = new Date("05/34/2000");
        assertFalse(date11.isValid());

        Date date12 = new Date("07/33/2000");
        assertFalse(date12.isValid());

        Date date13 = new Date("04/31/2000");
        assertFalse(date13.isValid());

        Date date14 = new Date("06/31/2000");
        assertFalse(date14.isValid());

        Date date15 = new Date("11/31/2000");
        assertFalse(date15.isValid());

        Date date16 = new Date("02/29/2003");
        assertFalse(date16.isValid());

        Date date17 = new Date("02/30/2004");
        assertFalse(date17.isValid());


    }
}