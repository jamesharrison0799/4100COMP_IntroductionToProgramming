package currencyConverter;
import java.util.Scanner;


public class CurrencyConverter {
	static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		
		//2.4d = 1p  1s = 5p        £1(old pound)= 100p
		
		System.out.println("Pounds (£): ");
		int hPounds = console.nextInt();
		
		System.out.println("Shillings (s): ");
		int hShillings = console.nextInt();
		
		System.out.println("Pence (c): ");
		int hPence = console.nextInt();
		
		double hValuePence = (hPounds*100)+(hShillings*5)+(hPence*2.4);		
		double ukValue = (hValuePence/100) ; //UK Pound 
		console.close();
		System.out.printf("Hadean £%d-%ds-%dd == GBP £%.2f", hPounds, hShillings, hPence, ukValue);
		
		
		/*
		String input = console.next();
		//System.out.println(input);
		String temp = input.replace("\\D","");
		String[] gbp = temp.split("-");
		for (String i : gbp) {
			System.out.println(i);
		}
		//int pound = Integer.parseInt(gbp.get());
		*/
	}
}
