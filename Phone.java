/**
This program:
Allows users to pick a cell phone and cell phone package, it will calculate
shipping and total costs, and finally output all of the transaction info to a text 
file that is also searchable by customerID.

@author Timothy McWatters
@version 1.0

COP3022    Project 3
File Name: Phone.java
*/

public class Phone extends Option {
	
	private String optionName = "";
	private double optionCost = 0.0;
	
	/**
	 * default constructor for the Phone class
	 */
	public Phone() {
		setOptionName("");
		setOptionCost(0.0);
	} // end of default constructor
		
	/**
	 * parameterized constructor for the Phone class
	 * @param optionName = the name of the option
	 * @param optionCost = the cost of the option
	 */
	public Phone(String optionName, double optionCost) {
		setOptionName(optionName);
		setOptionCost(optionCost);
	} // end of parameterized constructor

	/**
	 * returns the name of the option
	 * @return the optionName
	 */
	public String getOptionName() {
		return optionName;
	} // end of getOptionName method

	/**
	 * sets the option name
	 * @param optionName = the name of the option to set
	 */
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	} // end of setOptionName method

	/**
	 * returns the cost of the option
	 * @return the optionCost
	 */
	public double getOptionCost() {
		return optionCost;
	} // end of getOptionCost method

	/**
	 * sets the cost of the option
	 * @param optionCost = the cost of the option to set
	 */
	public void setOptionCost(double optionCost) {
		this.optionCost = optionCost;
	} // end of setOptionCost method

	/* 
	 * returns a nicely formatted string
	 * @return string representation of the option
	 */
	@Override
	public String toString() {
		return " [" + getOptionName() + ", Cost = $" + getOptionCost() + "]";
	} // end of toString method
	
} // end of the Phone class