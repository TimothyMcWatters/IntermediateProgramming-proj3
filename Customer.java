import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
This program:
Allows users to pick a cell phone and cell phone package, it will calculate
shipping and total costs, and finally output all of the transaction info to a text 
file that is also searchable by customerID.

@author Timothy McWatters
@version 1.0

COP3022    Project 3
File Name: Customer.java
*/

public class Customer {

	private int customerID = 0;
	private static int nextIDNum = 1000;
	private String customerName = "";
	private int addressHouseNumber = 0;
	private String addressStreet = "";
	private String addressCity = "";
	private String addressState = "";
	private int addressZip = 0;
	private String customerPhone = "";
	private Package selectedPackage = null;
	
	/**
	 * Default constructor for the Customer class
	 */
	public Customer() {
		setCustomerName("");
		setAddressHouseNumber(0);
		setAddressStreet("");
		setAddressCity("");
		setAddressState("");
		setAddressZip(0);
		setCustomerPhone("");
		setCustomerID();
		this.selectedPackage = new Package();
	} // end of default constructor
	
	/**
	 * Parameterized constructor for the Customer class
	 * @param customerName = The name of the customer
	 * @param addressHouseNumber = customers house number
	 * @param addressStreet = customers street
	 * @param addressCity = customers city
	 * @param addressState = customers state
	 */
	public Customer(String customerName, int addressHouseNumber, String addressStreet, String addressCity,
			String addressState) {
		setCustomerName(customerName);
		setAddressHouseNumber(addressHouseNumber);
		setAddressStreet(addressStreet);
		setAddressCity(addressCity);
		setAddressState(addressState);
		this.addressZip = 0; // added using mutator method later to ensure proper formatting/error handling
		this.customerPhone = ""; // added using mutator method later to ensure proper formatting/error handling
		setCustomerID();
		this.selectedPackage = new Package();
	} // end of parameterized constructor
	
	/**
	 * returns the sequentially assigned ID for the customer
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	} // end of getCustomerID method
	
	/**
	 * sets the ID for the customer, and increments the ID in preparation for the next customer.
	 */
	public void setCustomerID() {
		this.customerID = nextIDNum++;
	} // end of setCustomerID method
	
	/**
	 * returns the full name of the customer
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	} // end of getCustomerName method
	
	/**
	 * sets the full name of the customer
	 * @param customerName = the name of the customer to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	} // end of setCustomerName method
	
	/**
	 * returns the customers house number
	 * @return the addressHouseNumber
	 */
	public int getAddressHouseNumber() {
		return addressHouseNumber;
	} // end of getAddressHouseNumber method
	
	/**
	 * sets the customers house number
	 * @param addressHouseNumber = the customers house number to set
	 */
	public void setAddressHouseNumber(int addressHouseNumber) {
		this.addressHouseNumber = addressHouseNumber;
	} // end of setAddressHouseNumber method
	
	/**
	 * returns the customers street
	 * @return the addressStreet
	 */
	public String getAddressStreet() {
		return addressStreet;
	} // end of getAddressStreet method
	
	/**
	 * sets the customers street
	 * @param addressStreet = the customers street to set
	 */
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	} // end of setAddressStreet method
	
	/**
	 * returns the customers city
	 * @return the addressCity
	 */
	public String getAddressCity() {
		return addressCity;
	} // end of getAddressCity method
	
	/**
	 * sets the customers city
	 * @param addressCity = the customers city to set
	 */
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	} // end of setAddressCity method
	
	/**
	 * returns the customers state
	 * @return the addressState
	 */
	public String getAddressState() {
		return addressState;
	} // end of getAddressState method
	
	/**
	 * sets the customers state
	 * @param addressState = the customers state to set
	 */
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	} // end of setAddressState method
	
	/**
	 * returns the customers zip code
	 * @return the addressZip
	 */
	public int getAddressZip() {
		return addressZip;
	} // end of getAddressZip method
	
	/**
	 * sets the customers zip code
	 * @param addressZip = the customers zip code to set
	 */
	public boolean setAddressZip(int addressZip) {
		try {
			String addressZipString = Integer.toString(addressZip);
			String regex = "^[0-9]{5}$";
		 
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(addressZipString);
		
			if (!matcher.matches()) {
				throw new MalformedZipCode();
			} else {
				this.addressZip = addressZip;
				return true;
			}
		} catch (MalformedZipCode e) {
			System.out.println(e.getMessage());
			return false;
		}
	} // end of setAddressZip method
	
	/**
	 * returns the customers phone number
	 * @return the customerPhone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	} // end of getCustomerPhone method
	
	/**
	 * sets the customers phone number
	 * @param customerPhone = the customers phone number to set
	 */
	public boolean setCustomerPhone(String customerPhone) {
		try {
			String regex = "^\\(([0-9]{3})\\)[\\s]([0-9]{3})[-]([0-9]{4})$";
		 
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(customerPhone);
		
			if (!matcher.matches()) {
				throw new MalformedPhoneNumber();
			} else {
				this.customerPhone = customerPhone;
				return true;
			}
		} catch (MalformedPhoneNumber e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	} // end of setCustomerPhone method
	
	/**
	 * allows the customer to select the customers Phone Package via the Package class
	 */
	public void selectCustomersPackage() {
		selectedPackage.selectPackage();
	} // end of selectCustomersPackage method
	
	/**
	 * returns the customers total start up costs
	 * @return start up total = the customers total start up cost (phone, data, talk and shipping)
	 */
	public double getCustomerTotalStartupCost(int zipCode) {
		selectedPackage.calculateStartupTotal(zipCode);
		return selectedPackage.getTotalStartupCost();
	} // end of getCustomerTotalStartupCost method
	
	/**
	 * returns the customers total start up costs
	 * @return start up total = the customers total start up cost (phone, data, talk and shipping)
	 */
	public double getCustomerTotalMonthlyCost() {
		selectedPackage.calculateMonthlyTotal();
		return selectedPackage.getTotalMonthlyCost();
	} // end of getCustomerTotalMonthlyCost method
	
	/* 
	 * returns a nicely formatted string representation of the customer class
	 * @return the string representation of the Customer class
	 */
	@Override
	public String toString() {
		String completeString = (String.format("Customer ID	Customer Name		Phone Number		Address    \n"
				+ "%-15d %-23s %-23s %d %s %s, %s %d", 
				getCustomerID(), getCustomerName(), getCustomerPhone(), 
				getAddressHouseNumber(), getAddressStreet(), getAddressCity(), 
				getAddressState(), getAddressZip()));
		return completeString;
	} // end of toString method
	
} // end of Customer class
