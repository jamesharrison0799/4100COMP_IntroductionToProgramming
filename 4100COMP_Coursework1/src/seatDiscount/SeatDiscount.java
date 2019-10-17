package seatDiscount;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatDiscount {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("-- Seat Discount System --");
		
		//Custom Rate Variables
		boolean useCustomRate;
		final int defualtRate = 20;
		double customRate = 0;
		
		//Custom Rate Menu
		while (true) {
			
			System.out.println("Specify Custom Discount Rate [Y|N]: ");
			String customDiscountRate = console.nextLine();
			
			// .toUpperCase is used in case the user submits a lower case character.
			// The OR operator could also be used eg: if (customDiscountRate.equals("Y") || customDiscountRate.equals("y")){}
			if (customDiscountRate.toUpperCase().equals("Y")) {
				//The boolean variable useCustomRate is used so that the programme knows what value to use when calculating discounts later.
				useCustomRate = true;
				//Takes custom discount percentage from user. A check is completed to ensure the number is valid. (Between 0 and 100)
				while(true) {
					System.out.println("Enter Custom Discount Rate Percentage: ");
					customRate = console.nextDouble();
					if(customRate > 0 && customRate < 100) {
						break;
					}else {
						System.out.println("Please enter a number between 0-100.");
					}
				}
				break;
			}else if(customDiscountRate.toUpperCase().equals("N")) {
				useCustomRate = false;
				break;
			}else {
				System.out.println("Please use only 'Y' or 'N' Characters to proceed.");
				
			}
		}
		
		//Try catch is used to prevent the program from suffering a fatal error should the data file not be present / unreadable		
		try{
			
			//Defines and opens data file ("seats.txt") and initialises reader
			String seatData = "seats.txt";
			FileReader file = new FileReader(seatData);
			Scanner read = new Scanner(file);
			
			//ArrayList's used to temporarily store data read from the data file.
			List<String> lines = new ArrayList<>();
			List<Double> discountSum = new ArrayList<>();
			List<Double> incomeSum = new ArrayList<>();
			
			
			//While loop reads the data file line by line and adds each line as an element to the Array list 'lines'
			while(read.hasNext()) {
				String line = read.nextLine();
				lines.add(line);			
			}
			
			/*for loop to iterate through data ArrayList. Loop finishes when i becomes greater than the size of the ArrayList 'lines'. 
			 *Iterator increase by four each time so that it aligns with the starting index of each data set. 
			 *This starting point can be determined because of the known data format, which is as follows:
			 *	Index	LineNumber	Content
			 *	0		1			SEAT NAME
			 * 	1		2			SEAT PRICE
			 * 	2		3			NUMBER OF BOOKINGS
			 * 	3		4			(EMPTY LINE)
			 */
			for (int i = 0; i < lines.size(); i += 4) {
				//assign data to variables using an iterator and known relative position   
				String seatType = lines.get(i);
				int seatAmount = Integer.parseInt(lines.get(i+2));
				double discount;
				double seatPrice = Double.parseDouble(lines.get(i+1));
				
				//determines value of discount based upon whether the boolean variable, useCustomRate, is True or False
				if (useCustomRate == true) {
					discount = (((seatPrice/10)*customRate)*seatAmount)/10;
				}else {
					discount = (((seatPrice/10)*defualtRate)*seatAmount)/10;
				}
				
				double income = ((seatPrice*seatAmount)-discount);
				
				System.out.printf("Seat Type: %s, Seat Price £%.2f, Bookings: %d, Discount: £%.2f, Income £%.2f\n\n",seatType,seatPrice,seatAmount,discount,income);
				
				discountSum.add(discount);
				incomeSum.add(income);
			}
			
			// The following demonstrates the two methods that can be used to sum all the elements of an ArrayList.
			double totalDiscount = 0;
			double totalIncome = 0;
			
			//index
			for(int z = 0; z < discountSum.size(); z++ ) {
				totalDiscount += discountSum.get(z);
			}
			
			//for each in 
			for(Double d: incomeSum) {
				totalIncome += d;
			}
			//-----
			
			System.out.printf("Total Discount: £%.2f\nTotal Income: £%.2f",totalDiscount,totalIncome);
			
			//Close scanner to prevent resource leak
			read.close();
			
		}catch(Exception e) {
			System.out.println("\nAn Error has prevented the program from reading the file. \nERROR:\n"+ e.getMessage());
		}
		
	}

	
}	
