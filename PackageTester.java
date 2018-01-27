import java.util.Scanner;

/**
This program:
Allows users to pick a cell phone and cell phone package, it will calculate
shipping and total costs, and finally output all of the transaction info to a text 
file that is also searchable by customerID.

@author Timothy McWatters
@version 1.0

COP3022    Project 3
File Name: PackageTester.java
*/

public class PackageTester {

	public static void main(String[] args) {
		// Input and Output file names
		String inputFileName = "cell phone plan cost sheet.txt"; // name of the file to read in phone packages
		String outputFileName = "transactions.txt"; // name of the file to write to, or if it doesn't exist, create it first.
		
		// Creates an instance of the FileProcessor class, opens the input file, and processes it
		FileProcessor fileprocessor = new FileProcessor(inputFileName, outputFileName);
		fileprocessor.openInputFile();
		fileprocessor.processInputFile(); 
		
		// Creates an instance of the CustomerAccounts class, holds all the accounts for a Telecommunications company
		CustomerAccounts ATT = new CustomerAccounts();
		
		// creates a new Scanner object to read menu response input from the keyboard
		Scanner menuIn = new Scanner(System.in);
		System.out.println("Welcome to the AMAZING phone package selector program!");
		System.out.println("NOTE: Due to the scope of the project (not reading the transaction info back in from the transaction.txt file), \n"
				+ "once you close/exit the program, you should delete or rename the transaction.txt file if you plan on re-running \nthe program "
				+ "in order for the customer ID's to sync up and be searchable.");
		boolean quit = false; // default for the do while loop is false, if quit is selected below "quit" will be true and program will end
		
		do {
			System.out.println("\nType 'E' to enter a new customer transaction, 'S' to search for a customer transaction (using the Customer ID), or 'Q' to exit the program. ");
			System.out.println("Note: Customer ID's begin at 1000 and iterate by 1 for each additional transaction processed. ");
			String menuOption = menuIn.next();
			if (menuOption.equalsIgnoreCase("e")) {
				Scanner customerIn = new Scanner(System.in).useDelimiter("\\n");
				System.out.print("Enter the customers full name: ");
				String customerName = customerIn.next();
				System.out.print("Enter the customers house number: ");
				int addressHouseNumber = customerIn.nextInt();
				System.out.print("Enter the customers street name: ");
				String addressStreet = customerIn.next();
				System.out.print("Enter the customers city: ");
				String addressCity = customerIn.next();
				System.out.print("Enter the customers state: ");
				String addressState = customerIn.next();
				Customer customer = new Customer(customerName, addressHouseNumber, addressStreet, addressCity,
					addressState);
				boolean isCorrectZipFormat = false;
				do {
					System.out.print("Enter the customers zip code (in the format xxxxx, where x is a number 0-9): ");
					isCorrectZipFormat = customer.setAddressZip(customerIn.nextInt());
				} while (!isCorrectZipFormat);
				boolean isCorrectPhoneFormat = false;
				do {
					System.out.print("Enter the customers phone number (in the format (xxx) xxx-xxxx, where x is a number 0-9): ");
					isCorrectPhoneFormat = customer.setCustomerPhone(customerIn.next());
				} while (!isCorrectPhoneFormat);
				ATT.addAccount(customer);
				customer.selectCustomersPackage();
				fileprocessor.processOutputFile(customer);
			} else if (menuOption.equalsIgnoreCase("s")) {
				Scanner customerIDIn = new Scanner(System.in);
				System.out.print("Enter the customers ID for the transaction you are searching: ");
				int searchCustomerID = customerIDIn.nextInt();
				boolean found = fileprocessor.searchOutputFile(searchCustomerID);
				if ((found) && (!ATT.getAccount(searchCustomerID).equals(null))) {
					System.out.println(ATT.getAccount(searchCustomerID).toString());
				}
			} else if (menuOption.equalsIgnoreCase("q")) {
				System.out.println("You have elected to close the program, please come again.");
				System.exit(0);
			} else {
				System.out.println("Please try again: ");
				continue;
			}
		} while (!quit);
		
		menuIn.close();

	} // end of main method

} // end of PackageTester class
