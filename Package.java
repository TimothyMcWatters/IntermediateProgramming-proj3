import java.util.Scanner;

/**
This program:
Allows users to pick a cell phone and cell phone package, it will calculate
shipping and total costs, and finally output all of the transaction info to a text 
file that is also searchable by customerID.

@author Timothy McWatters
@version 1.0

COP3022    Project 3
File Name: Option.java
*/

public class Package {
	//constants
	public static final int PACKAGE_ARRAY_SIZE = 3;
	
	//instance variables
	private double totalStartupCost = 0.00;
	private double totalMonthlyCost = 0.00; 
	private double shippingCost = 0.00;
	private Option[] phonePackage = null;
	
	/**
	 * default constructor for the Package class
	 */
	public Package() {
		setTotalStartupCost(0.0);
		setShippingCost(0.0);
		this.phonePackage = new Option[PACKAGE_ARRAY_SIZE];
	} // end of default constructor
	
	/**
	 * returns the total start up cost of the phone package 
	 * @return the totalStartupCost = the total cost to start up a phone package
	 */
	public double getTotalStartupCost() {
		return totalStartupCost;
	} // end of getTotalStartupCost method

	/**
	 * sets the total start up cost of the phone package
	 * @param totalStartupCost = the phone package total cost to start up
	 */
	public void setTotalStartupCost(double totalStartupCost) {
		this.totalStartupCost = totalStartupCost;
	} // end of setTotalStartupCost

	/**
	 * returns the total monthly re-occurring cost of the phone package 
	 * @return the totalMonthlyCost = the total cost monthly for the phone package
	 */
	public double getTotalMonthlyCost() {
		return totalMonthlyCost;
	} // end of getTotalMonthlyCost method

	/**
	 * sets the total monthly cost of the phone package
	 * @param totalStartupCost = the phone package total monthly cost
	 */
	public void setTotalMonthlyCost(double totalMonthlyCost) {
		this.totalMonthlyCost = totalMonthlyCost;
	} // end of setTotalMonthlyCost
	
	/**
	 * returns the cost of shipping
	 * @return the shippingCost
	 */
	public double getShippingCost() {
		return shippingCost;
	} // end of getShippingCost method

	/**
	 * sets the cost of shipping
	 * @param shippingCost = the shipping cost to set
	 */
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	} // end of setShippingCost method

	/**
	 * returns the selected phone object 
	 * @return Option object
	 */
	public Option selectPhone() {
		Scanner phoneSelection = new Scanner(System.in);
		int menuItem = 0;
		boolean repeat = false;
		
		System.out.println("\nPlease select a phone:");
		for (int i = 1; i <= 3; i++) {
			System.out.println(i + FileProcessor.getOption(2 + i).toString());
		}
		do {
			System.out.println("Enter 1, 2 or 3");
			menuItem = phoneSelection.nextInt();
			switch (menuItem) {
			case 1:
				System.out.println("You have chosen: " + FileProcessor.getOption(3).toString());
				return FileProcessor.getOption(3);
			case 2:
				System.out.println("You have chosen: " + FileProcessor.getOption(4).toString());
				return FileProcessor.getOption(4);
			case 3:
				System.out.println("You have chosen: " + FileProcessor.getOption(5).toString());
				return FileProcessor.getOption(5);
			default: 
				System.out.println("Invalid Choice!");
				repeat = true;
				break;
			}
		} while (repeat);
		return FileProcessor.getOption(3); // compiler needs a return statement outside of the switch statement
	} // end of selectPhone method

	/**
	 * returns the selected Talk object 
	 * @return Option object
	 */
	public Option selectTalk() {
		Scanner talkSelection = new Scanner(System.in);
		int menuItem = 0;
		boolean repeat = false;
		
		System.out.println("\nPlease select a Talk Package: ");
		for (int i = 1; i <= 3; i++) {
			System.out.println(i + FileProcessor.getOption(i - 1).toString());
		}
		do {
			System.out.println("Enter 1, 2 or 3");
			menuItem = talkSelection.nextInt();
			switch (menuItem) {
			case 1:
				System.out.println("You have chosen: " + FileProcessor.getOption(0).toString());
				return FileProcessor.getOption(0);
			case 2:
				System.out.println("You have chosen: " + FileProcessor.getOption(1).toString());
				return FileProcessor.getOption(1);
			case 3:
				System.out.println("You have chosen: " + FileProcessor.getOption(2).toString());
				return FileProcessor.getOption(2);
			default: 
				System.out.println("Invalid Choice!");
				repeat = true;
				break;
			}
		} while (repeat);
		return FileProcessor.getOption(0); // compiler needs a return statement outside of the switch statement
	} // end of selectTalk method
	
	/**
	 * returns the selected Data object 
	 * @return Option object
	 */
	public Option selectData() {
		Scanner dataSelection = new Scanner(System.in);
		int menuItem = 0;
		boolean repeat = false;
		
		System.out.println("\nPlease select a Data Package: ");
		for (int i = 1; i <= 3; i++) {
			System.out.println(i + FileProcessor.getOption(5 + i).toString());
		}
		do {
			System.out.println("Enter 1, 2 or 3");
			menuItem = dataSelection.nextInt();
			switch (menuItem) {
			case 1:
				System.out.println("You have chosen: " + FileProcessor.getOption(6).toString());
				return FileProcessor.getOption(6);
			case 2:
				System.out.println("You have chosen: " + FileProcessor.getOption(7).toString());
				return FileProcessor.getOption(7);
			case 3:
				System.out.println("You have chosen: " + FileProcessor.getOption(8).toString());
				return FileProcessor.getOption(8);
			default: 
				System.out.println("Invalid Choice!");
				repeat = true;
				break;
			}
		} while (repeat);
		return FileProcessor.getOption(6); // compiler needs a return statement outside of the switch statement		
	} // end of selectData method

	/**
	 * Populates the phonePackage array with Option objects, phone/talk/data 
	 */
	public void selectPackage() {
		phonePackage[0] = selectPhone();
		phonePackage[1] = selectTalk();
		phonePackage[2] = selectData();
	} // end of selectPackage method

	/**
	 * Calculates, sets and returns the packages shipping costs
	 *@param zipCode = the zip code to calculate shipping for 
	 *@return shippingCost = the total cost of shipping the package
	 */
	public double calculateShipping(int zipCode) {
		if ((zipCode >= 32500) && (zipCode <= 32599)) {
			setShippingCost(0.00);
			return 0.00;
		} else if (((zipCode >= 99500) && (zipCode <= 99999)) || ((zipCode >= 96700) && (zipCode <= 96899))) {
			setShippingCost(10.00);
			return 10.00;
		} else {
			setShippingCost(5.00);
			return 5.00;
		}
	} // end of calculateShipping method
	
	/**
	 * Calculates and returns the packages total startup (phone, data, talk and shipping costs)
	 * return total = the total start up cost of the package
	 */
	public void calculateStartupTotal(int zipCode) {
		double total = 0.0;
		for (int i = 0; i < PACKAGE_ARRAY_SIZE; i++) {
			total += phonePackage[i].getOptionCost();
		}
		calculateShipping(zipCode);
		total += getShippingCost();
		setTotalStartupCost(total);
	} // end of calculateStartupTotal method
	
	/**
	 * Calculates, sets and returns the packages monthly (data and talk costs)
	 * return total = the total re-occuring monthly cost of the package
	 */
	public void calculateMonthlyTotal() {
		double total = 0.0;
		for (int i = 1; i < PACKAGE_ARRAY_SIZE; i++) {
			total += phonePackage[i].getOptionCost();
		}
		setTotalMonthlyCost(total);
	} // end of calculateMonthlyTotal method
	
} // end of Package class
