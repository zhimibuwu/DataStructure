/* BadTransactionException.java */

/**
 *  Implements an exception that should be thrown for invalid amount.
 **/
public class BadTransactionException extends Exception {

  public int accountAmount;  // The invalid account number.

  /**
   *  Creates an exception object for nonexistent account "badAcctNumber".
   **/
  public BadTransactionException(int badAcctAmount) {
    super("Invalid account amount: " + badAcctAmount);

    accountAmount = badAcctAmount;
  }
}
