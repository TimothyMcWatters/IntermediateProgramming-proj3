import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessor {
	//constant
	public static final int OPTIONS_ARRAY_SIZE = 9;
	
	private String inputFileName = "";
	private String outputFileName = "";
	private Scanner fileIn = null; //default empty
	static Option[] options = null;
	
	/**
	 *  constructor for the FileProcessor class
	 */
	public FileProcessor(String inputFileName, String outputFileName) {
		setInputFileName(inputFileName);
		setOutputFileName(outputFileName);
		options = new Option[OPTIONS_ARRAY_SIZE];
	} // end of FileProcessor constructor
	
	/**
	 * returns the name of the file to process
	 * @return the fileName
	 */
	public String getInputFileName() {
		return inputFileName;
	} // end of getInputFileName method

	/**
	 * sets the name of the file to process 
	 * @param fileName = the name of the file to set
	 */
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	} // end of setInputFileName method
	
	/**
	 * returns the name of the file to write to
	 * @return the outputFileName
	 */
	public String getOutputFileName() {
		return outputFileName;
	} // end of getOutputFileName method

	/**
	 * sets the name of the file to write to 
	 * @param outputFileName = the name of the file to write to
	 */
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	} // end of setOutputFileName method
	
	/**
	 * attempts to open the file to process, and throws an exception if it can't
	 */
	public void openInputFile() {
		try {
			// Attempt to open the file
			fileIn = new Scanner(new FileInputStream(getInputFileName()));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
			System.exit(0);
		}
	} // end of openFile method
	
	/**
	 * processes the input file (reads in the file, processes in the information to create 
	 * phone package options) 
	 */
	public void processInputFile() {
		String trash = "";
		String theLine = "";
		String[] theTokens = null;
		String optionName = "";
		double optionCost = 0.0;
		
		trash = fileIn.nextLine();
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		optionName = theTokens[0]; 
		optionCost = Double.parseDouble(theTokens[1]);
		options[0] = new Talk(optionName, optionCost);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		optionName = theTokens[0]; 
		optionCost = Double.parseDouble(theTokens[1]);
		options[1] = new Talk(optionName, optionCost);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		optionName = theTokens[0]; 
		optionCost = Double.parseDouble(theTokens[1]);
		options[2] = new Talk(optionName, optionCost);
	
		trash = fileIn.nextLine();
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		optionName = theTokens[0]; 
		optionCost = Double.parseDouble(theTokens[1]);
		options[3] = new Phone(optionName, optionCost);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		optionName = theTokens[0]; 
		optionCost = Double.parseDouble(theTokens[1]);
		options[4] = new Phone(optionName, optionCost);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		optionName = theTokens[0]; 
		optionCost = Double.parseDouble(theTokens[1]);
		options[5] = new Phone(optionName, optionCost);
	
		trash = fileIn.nextLine();
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		optionName = theTokens[0]; 
		optionCost = Double.parseDouble(theTokens[1]);
		options[6] = new Data(optionName, optionCost);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		optionName = theTokens[0]; 
		optionCost = Double.parseDouble(theTokens[1]);
		options[7] = new Data(optionName, optionCost);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		optionName = theTokens[0]; 
		optionCost = Double.parseDouble(theTokens[1]);
		options[8] = new Data(optionName, optionCost);
	} // end of processInputFile method
	
	/**
	 * sets the name of the file to process 
	 * @param fileName = the name of the file to set
	 */
	public static Option getOption(int i) {
		return options[i];
	} // end of getOption method

	/**
	 * attempts to open the file to write, if it doesn't exist, creates 
	 * the file, but throws an exception if it can't find or create. Then 
	 * tries to processes the output file (writes transaction information to the file) 
	 * @param customer = the customer the transaction belongs to
	 */
	public void processOutputFile(Customer customer) {
		PrintWriter outputStream = null;
		try {
			File file1 = new File(getOutputFileName());
			file1.createNewFile();  // if file already exists will do nothing 
			outputStream = new PrintWriter(new FileOutputStream(file1, true)); 
		} catch (IOException e) {
			System.out.println("Error opening the file");
			System.exit(0);
		} 
		
		outputStream.printf("%s,%.2f,%.2f\n", 
				customer.getCustomerID(), customer.getCustomerTotalStartupCost(customer.getAddressZip()), 
				customer.getCustomerTotalMonthlyCost());
		outputStream.close();
	} // end of processOutputFile method
	
	/**
	 * attempts to open the transaction file, if it can't then it throws an exception. 
	 * searches the file for the customer ID and prints the transaction and returns true if it exists, or
	 * prints a default statement if the customer ID doesn't exist in the transaction file and returns false.
	 * @param customerID = the customers ID for the transaction being requested
	 * @return boolean = returns true if the customerID is found and false if not
	 */
	public boolean searchOutputFile(int customerID) {
		Scanner fileIn = null; //default empty
		try {
			// Attempt to open the file
			fileIn = new Scanner(new FileInputStream(getOutputFileName()));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
			System.exit(0);
		}
		
		while (fileIn.hasNextLine()) {
			String theString = fileIn.nextLine();
			String[] theTokens = theString.split(",");
			int fileCustomerID = Integer.parseInt(theTokens[0]);
			double fileStartupCost = Double.parseDouble(theTokens[1]);
			double fileMonthlyCost = Double.parseDouble(theTokens[2]);
			
			if (customerID == fileCustomerID) {
				System.out.printf("Customer ID: %s, Startup Cost: $%.2f, Monthly Cost: $%.2f\n", 
						fileCustomerID, fileStartupCost, fileMonthlyCost);
				return true;
			} else {
				continue;
			}
		}
		System.out.println("The transaction you are looking for does not exist, please try a different Customer ID: ");
		return false;
	} // end of searchOutputFile method

} // end of FileProcessor Class
