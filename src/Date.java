/**
 * The Date class holds year, month, and day, and it checks if the date is valid and also compares two dates.
 * Method isValid() checks if the date is valid according to the assignments parameters.
 * Method compareTo() returns 1 if the date is valid, and returns 0 otherwise.
 *
 * @author Jason Li, John Leng
 */

import java.util.Calendar;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;


    /**
     * Takes the string "mm/dd/yyyy" and creates a Date object.
     *
     * @param date input date
     */
    public Date(String date) {
        StringTokenizer inputDate = new StringTokenizer(date);
        this.month = Integer.parseInt(inputDate.nextToken("/"));
        this.day = Integer.parseInt(inputDate.nextToken("/"));  //******can i do this? is this right?
        this.year = Integer.parseInt(inputDate.nextToken("/"));
    }

    /**
     * Creates an object with today's date.
     */
    public Date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        String todayDate = dateFormat.format(cal.getTime());
        StringTokenizer today = new StringTokenizer(todayDate);
        this.month = Integer.parseInt(today.nextToken("/"));
        this.day = Integer.parseInt(today.nextToken("/"));
        this.year = Integer.parseInt(today.nextToken("/"));
    }


    /**
     * Checks if the date is valid by checking month, year, day, and leap years
     * @return returns true if its valid and false if it's not
     */
    public boolean isValid() {
        final int THE_EIGHTIES = 1980, TWENTY_EIGHT_DAYS = 28, TWENTY_NINE_DAYS = 29, THIRTY_DAYS = 30, THIRTY_ONE_DAYS = 31;
        final int JAN = 1, FEB = 2, MAR = 3;
        final int APR = 4;
        final int MAY = 5;
        final int JUN = 6;
        final int JUL = 7;
        final int AUG = 8;
        final int SEP = 9;
        final int OCT = 10;
        final int NOV = 11;
        final int DEC = 12;
        boolean LEAP_YEAR = false;

        //Determines if the year is a leap year
        if(this.year % 4 == 0){
            if(this.year % 100 == 0){
                if(this.year % 400 == 0){
                    LEAP_YEAR = true;
                }
                else{
                    LEAP_YEAR = false;
                }

            }
            else{
                LEAP_YEAR = true;
            }
        }
        else{
            LEAP_YEAR = false;
        }

        //Checks for the 80's
        if(this.year < THE_EIGHTIES) return false;
        //checks if the date is greater than today
        Date today = new Date();
        if (this.compareTo(today) == 1){
            return false;
        }
        //Checks February normally and on leap years
        if((this.day <= TWENTY_EIGHT_DAYS && this.month == FEB)
                || (LEAP_YEAR == true && this.day <= TWENTY_NINE_DAYS && this.month == FEB)) return true;

        //Checks months with 30 days
        if(this.day <= THIRTY_DAYS && (this.month == APR || this.month == JUN || this.month == SEP || this.month == NOV) )
            return true;
        //Checks months with 31 days
        if(this.day <= THIRTY_ONE_DAYS && (this.month == JAN || this.month == MAR || this.month == MAY
                || this.month == JUL || this.month == AUG || this.month == OCT || this.month == DEC))
            return true;
        return false;
    }

    /**
     * If the inputed date is older than the date the function is called on, returns 1, else returns 0.
     * @param date input date
     * @return 1 if the inputed date is older, 0 if it's not older
     */
    @Override
    public int compareTo(Date date) {
        if(this.year > date.year){
            return 1;
        }
        if(this.year == date.year && this.month > date.month){
            return 1;
        }
        if(this.year == date.year && this.month == date.month && this.day >= date.day){
            return 1;
        }
        return 0;
    }

    /**
     * Gets date.
     *
     * @return date in mm/dd/yyyy format
     */

    public String getDate() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Testbed is meant to test the isValid() method according to the Testbed Document
     * @param args takes arguments from command line
     */
    public static void main(String[] args){
        Date case1 = new Date("03/22/1979"); //Case 1
        System.out.println(case1.isValid());
        Date case2 = new Date("09/26/2022"); //Case 2
        System.out.println(case2.isValid());
        Date case3 = new Date("01/33/2000"); //Case 3
        System.out.println(case3.isValid());
        Date case4 = new Date("03/33/2000"); //Case 4
        System.out.println(case4.isValid());
        Date case5 = new Date("05/34/2000"); //Case 5
        System.out.println(case5.isValid());
        Date case6 = new Date("05/31/2000"); //Case 6
        System.out.println(case6.isValid());
        Date case7 = new Date("07/33/2000"); //Case 7
        System.out.println(case7.isValid());
        Date case8 = new Date("08/33/2000"); //Case 8
        System.out.println(case8.isValid());
        Date case9 = new Date("08/31/2000"); //Case 9
        System.out.println(case9.isValid());
        Date case10 = new Date("10/33/2000"); //Case 10
        System.out.println(case10.isValid());
        Date case11 = new Date("12/33/2000"); //Case 11
        System.out.println(case11.isValid());
        Date case12 = new Date("12/31/2000"); //Case 12
        System.out.println(case12.isValid());
        Date case13 = new Date("04/31/2000"); //Case 13
        System.out.println(case13.isValid());
        Date case14 = new Date("06/31/2000"); //Case 14
        System.out.println(case14.isValid());
        Date case15 = new Date("09/31/2000"); //Case 15
        System.out.println(case15.isValid());
        Date case16 = new Date("09/30/2000"); //Case 16
        System.out.println(case16.isValid());
        Date case17 = new Date("11/31/2000"); //Case 17
        System.out.println(case17.isValid());
        Date case18 = new Date("11/30/2000"); //Case 18
        System.out.println(case18.isValid());
        Date case19 = new Date("02/29/2003"); //Case 19
        System.out.println(case19.isValid());
        Date case20 = new Date("02/30/2004"); //Case 20
        System.out.println(case20.isValid());
        Date case21 = new Date("02/29/2004"); //Case 21
        System.out.println(case21.isValid());
    }
}