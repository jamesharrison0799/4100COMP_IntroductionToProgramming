package ageCondition;

import java.util.Scanner;

public class AgeCondition2 {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		double price;
		int age;
		boolean isStudent = false;
		System.out.println("Age: ");
		age = console.nextInt();
		
		if(age>16) {
			while(true) {
				console.nextLine();
				System.out.println("Are you a student?");
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

		System.out.printf("You are %d, your ticket price is £%.2f",age, price);
	}

}
