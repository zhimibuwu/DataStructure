/* OpenCommercial.java */

import java.net.*;
import java.io.*;
import java.util.Stack;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();

    /* Replace this comment with your solution.  */
    String site = "http://www." + inputLine + ".com";
    // System.out.println(url);
    URL url = new URL(site);

    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    String input;
    Stack st = new Stack();
    int index = 0;
    while ((input = in.readLine())!=null && index <= 4)
      {
        st.push(input);
        index++; 
      }
    while (!st.isEmpty())
    {
      System.out.println(st.pop());
    }
    in.close();
  }
}
