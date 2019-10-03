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
		
		
		double hValuePence = hPence+(hShillings*20)+(hPounds*240);
		
		System.out.println(hValuePence);
		
		double ukValue = hValuePence/2.4 ; 
		
		System.out.println("GBP£"+(ukValue/100));
		
		
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
