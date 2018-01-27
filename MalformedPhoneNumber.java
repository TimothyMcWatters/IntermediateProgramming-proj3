/**
This program:
Allows users to pick a cell phone and cell phone package, it will calculate
shipping and total costs, and finally output all of the transaction info to a text 
file that is also searchable by customerID.

@author Timothy McWatters
@version 1.0

COP3022    Project 3
File Name: MalformedPhoneNumber.java
*/

public class MalformedPhoneNumber extends Exception {

	/**
	 * Default constructor for the MalformedPhoneNumber class
	 */
	public MalformedPhoneNumber() {
		super("Phone Numbers must be of the form: (XXX) XXX-XXXX (where X is any number 0-9)\nPlease enter the Phone Number again: ");
	} // end of default MalformedPhoneNumber constructor
	
	/**
	 * Parameterized constructor for the MalformedPhoneNumber class
	 */
	public MalformedPhoneNumber(String message) {
		super(message);
	} // end of parameterized MalformedPhoneNumber constructor
	
} // end of MalformedPhoneNumber Class

