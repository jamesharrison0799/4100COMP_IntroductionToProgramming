package ageCondition;

import java.util.Scanner;
import java.util.Calendar;

public class AgeCondition3 {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		double price = 0;
		int age, currentMonth = (cal.get(Calendar.MONTH))+1 , userBirthMonth;
		boolean isStudent = false, freeTicket = false;
		String code = null;
		
		System.out.println("Brith Month (Number - eg, January = '1', December = '12'): ");
		userBirthMonth = console.nextInt();
		
		System.out.println("Age: ");
		age = console.nextInt();
		
		if(currentMonth == userBirthMonth) {
			freeTicket = true;
			switch(userBirthMonth){
				case 1:
					code = "Q1.1";
					break;
				case 2:
					code = "Q1.2";
					break;
				case 3:
					code = "Q1.3";
					break;
				case 4:
					code = "Q2.1";
					break;
				case 5:
					code ="Q2.2";
					break;
				case 6:
					code = "Q2.3";
				case 7:
					code = "Q3.1";
					break;
				case 8:
					code = "Q3.2";
					break;
				case 9:
					code = "Q3.3";
					break;
				case 10:
					code = "Q4.1";
					break;
				case 11:
					code = "Q4.2";
					break;
				case 12:
					code = "Q4.3";
					break;
				
			}
		}
		if(!freeTicket) {
			if(age>16) {
				while(true) {
					console.nextLine();
					System.out.println("Are you a student? [Y/N]");
					String studentCheck = console.nextLine();
					if(studentCheck.toUpperCase().equals("Y")) {
						isStudent = true;
						System.out.println("Your student discount will be applied");
						break;
					}else if(studentCheck.toUpperCase().equals("N")) {
						break;
					}else {
						System.out.println("Invalid input. Enter Y or N only.");
					}
				}
			}
			
			if (age < 16 || age > 64) {
				price = 5;
			}else {
				price = 10;
			}
			if(isStudent == true && (age>16 && age<64)) {
				price = price-(price/10);
			}else if (isStudent == true && (age>64)) {
				price = price-((price/10)*2);
			}
		}
		
		if(freeTicket) {
			System.out.printf("You are %d and you where born in this month! Your ticket is free! (%s)",age,code);
		}else {
			System.out.printf("You are %d, your ticket price is £%.2f",age, price);
		}
		
	}

}
