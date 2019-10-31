package seatDiscount;

import java.util.Scanner;

public class SeatDiscount2 {

	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {

		boolean useCustomRate;
		final int defualtRate = 20;
		double customRate = 0;
		
		menu();
		
		System.out.print(setRate());
		
		
	}

	public static void menu() {
		
		int invalidTimeOut = 0, maxMenuTries = 5;
		while (invalidTimeOut < maxMenuTries) {
			System.out.println("Specify Custom Discount Rate [Y|N]: ");
			String customDiscountRate = console.nextLine();

			switch (customDiscountRate.toUpperCase()) {
			case "Y":
				setRate();
				console.next();
				System.out.println("Yes");
				break;
			case "N":
				// readFile();
				System.out.println("No");
				break;
			default:
				invalidTimeOut++;
				System.out.printf("Invalid Input"
						+ " (%d / %d)",invalidTimeOut,maxMenuTries);
			}
			
		}
		System.out.printf("\nYou have entered an invalid input too many times, the program will now terminate.");
		System.exit(invalidTimeOut);
	}
	
	public static double setRate() {
		
		double customRate;
		while(true) {
			System.out.println("Enter Custom Discount Rate Percentage: ");
			try {
				customRate = console.nextDouble();
				if(customRate > 0 && customRate < 100) {
					
					return customRate;
				}else {
					System.out.println("Please enter a number between 0-100.");
				}
			}catch(Exception e){
				System.out.println("Invalid input" + "( "+e+" )");
				console.next();
				continue;
			}
		}
	}
}
