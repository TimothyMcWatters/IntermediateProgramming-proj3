/**
This program:
Allows users to pick a cell phone and cell phone package, it will calculate
shipping and total costs, and finally output all of the transaction info to a text 
file that is also searchable by customerID.

@author Timothy McWatters
@version 1.0

COP3022    Project 3
File Name: CustomerAccounts.java
*/

public class CustomerAccounts {
	//constant
	public static final int CUSTOMER_ACCOUNTS_ARRAY_SIZE = 50;
	
	//instance variables
	private int numOfElements = 0;
	private Customer[] customerAccounts = null;
	
	/**
	 * Default constructor for the CustomerAccounts class
	 */
	public CustomerAccounts() {
		customerAccounts = new Customer[CUSTOMER_ACCOUNTS_ARRAY_SIZE];
	} // end of default constructor

	/**
	 * adds an account to the customerAccounts array and increments the numOfElements instance variable by 1
	 * @param account = an Account to add
	 */
	public void addAccount(Customer customerAccount) {
		customerAccounts[numOfElements++] = customerAccount;
	} // end of addAccount method
	
	/**
	 * searches for, and returns, the Account object associated with the parameter customerID in the 
	 * customerAccounts Array, or returns null if that customerID does not exist.
	 * @param accountName = the customerID of Account object to get
	 * @return Account = the Account object or null if the account is not found
	 */
	public Customer getAccount(int customerID) {
		for (int i = 0; i < numOfElements; i++) {
			if ((customerAccounts[i].getCustomerID() == customerID)) {
				return customerAccounts[i];
			} else {
				continue;
			}
		}
		return null;
	} // end of getAccount method

}  // end of CustomerAccounts class
