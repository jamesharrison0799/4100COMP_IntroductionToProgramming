package ageCondition;

import java.util.Scanner;

public class AgeCondition {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		double price;
		int age;
		System.out.println("Age: ");
		age = console.nextInt();
		
		
		if (age < 16 || age > 64) {
			price = 5;
		}else {
			price = 10;
		}

		System.out.printf("You are %d, your ticket price is £%.2f",age, price);
	}

}
