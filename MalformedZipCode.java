/**
This program:
Allows users to pick a cell phone and cell phone package, it will calculate
shipping and total costs, and finally output all of the transaction info to a text 
file that is also searchable by customerID.

@author Timothy McWatters
@version 1.0

COP3022    Project 3
File Name: MalformedZipCode.java
*/

public class MalformedZipCode extends Exception {

	/**
	 * Default constructor for the MalformedZipCode class
	 */
	public MalformedZipCode() {
		super("Zip Codes must be of the form: XXXXX (where X is any number 0-9)\nPlease enter the Zip Code again: ");
	} // end of default MalformedZipCode constructor
	
	/**
	 * Parameterized constructor for the MalformedZipCode class
	 */
	public MalformedZipCode(String message) {
		super(message);
	} // end of parameterized MalformedZipCode constructor
	
} // end of MalformedZipCode Class
