package seatDiscount;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatDiscount {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("-- Seat Discount System --");
		
		boolean useCustomRate;
		final int defualtRate = 20;
		double customRate = 0;
		
		while (true) {
			System.out.println("Specify Custom Discount Rate [Y|N]: ");
			String customDiscountRate = console.nextLine();
			if (customDiscountRate.toUpperCase().equals("Y")) {
				useCustomRate = true;
				System.out.println("Enter Custom Discount Rate Percentage: ");
				customRate = console.nextDouble();
				break;
			}else if(customDiscountRate.toUpperCase().equals("N")) {
				useCustomRate = false;
				break;
			}else {
				System.out.println("Please use only 'Y' or 'N' Characters to proceed");
				
			}
		}
		
		try{
			String seatData = "seats.txt";
			FileReader file = new FileReader(seatData);
			Scanner read = new Scanner(file);
			
			List<String> lines = new ArrayList<>();
			List<Double> discountSum = new ArrayList<>();
			List<Double> incomeSum = new ArrayList<>();
			
			while(read.hasNext()) {
				String line = read.nextLine();
				lines.add(line);
			
			}
			
			for (int i = 0; i < lines.size(); i += 4) {
				String seatType = lines.get(i);
				int seatAmount = Integer.parseInt(lines.get(i+2));
				double discount;
				double seatPrice = Double.parseDouble(lines.get(i+1));
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
			
			read.close();
			
		}catch(Exception e) {
			System.out.println("\nAn Error has prevented the program from reading the file. \nERROR:\n"+ e.getMessage());
		}
		
	}

	
}	
