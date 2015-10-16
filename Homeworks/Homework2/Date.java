/* Date.java */

import java.io.*;

class Date {

  /* Put your private data fields here. */
  private int month;
  private int day;
  private int year;

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
    if (isValidDate(month, day, year))
    {
      this.month = month;
      this.day = day;
      this.year = year;
    }
    else
      System.exit(0);
  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
    this(Integer.parseInt(s.split("/")[0]), Integer.parseInt(s.split("/")[1]), Integer.parseInt(s.split("/")[2]));
  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
    return ((year % 4 == 0)&&(year % 100 != 0)) || (year % 400 == 0);                        // replace this line with your solution
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
    boolean isLeap = isLeapYear(year);
    switch(month) {
      case 2:
        if (isLeap)
          return 29;
        else
          return 28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
    // return 0;                           // replace this line with your solution
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
    return ((month >= 1 && month <= 12) && (year >= 1) && (day >= 1 && day <= daysInMonth(month,year)));                        // replace this line with your solution
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
    return month + "/" + day + "/" + year;                     // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
    return (this.year < d.year) || (this.year == d.year && this.month < d.month) || (this.year == d.year && this.month == d.month && this.day < d.day);                        // replace this line with your solution
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
    return !isBefore(d) && !(this.year == d.year && this.month == d.month && this.day == d.day);                        // replace this line with your solution
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
    int result = 0;
    for (int i = 1; i < month; i++)
    {
      result += daysInMonth(i, year);
    }
    result += day;
    return result;                           // replace this line with your solution
  }

  private static Date max(Date d1, Date d2) {
    if (d1.isBefore(d2))
      return d2;
    else
      return d1;
  }

  private static Date min(Date d1, Date d2) {
    if (d1.isBefore(d2))
      return d1;
    else
      return d2;
  }

  private static int daysInYear(int year) {
    if (isLeapYear(year))
      return 366;
    else
      return 365;
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
    Date maxDate = max(this,d);
    Date minDate = min(this,d);
    int result = 0;
    for (int i = minDate.year; i < maxDate.year; i++) {
      result += daysInYear(i);
    }
    result = result + maxDate.dayInYear() - minDate.dayInYear();
    if (isBefore(d))
      result *= -1;
    return result;                           // replace this line with your solution
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */
    System.out.println("1996 is LeapYear: " + isLeapYear(1996));
    System.out.println("1800 is LeapYear: " + isLeapYear(1800));
    System.out.println("1900 is LeapYear: " + isLeapYear(1900));
    System.out.println("2000 is LeapYear: " + isLeapYear(2000));
    System.out.println("1600 is LeapYear: " + isLeapYear(1600));
    System.out.println("1996.2 should have: " + daysInMonth(2,1996));
    System.out.println("1996.1 should have: " + daysInMonth(1,1996));
    System.out.println("1996.4 should have: " + daysInMonth(4,1996));
    System.out.println("1800.2 should have: " + daysInMonth(2,1800));
    System.out.println("1800.1 should have: " + daysInMonth(1,1800));
    System.out.println("1800.4 should have: " + daysInMonth(4,1800));
    System.out.println("2/30/1990 is valid: " + isValidDate(2,30,1990));
    System.out.println("2/29/1990 is valid: " + isValidDate(2,29,1990));
    System.out.println("2/28/1990 is valid: " + isValidDate(2,28,1990));
    System.out.println("2/29/2000 is valid: " + isValidDate(2,29,2000));
    System.out.println("1/32/2000 is valid: " + isValidDate(1,32,2000));
    System.out.println("0/23/2000 is valid: " + isValidDate(0,23,2000));
    System.out.println("4/23/-1 is valid: " + isValidDate(4,23,-1));
    System.out.println("12/31/1975 is the " + d1.dayInYear());

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
