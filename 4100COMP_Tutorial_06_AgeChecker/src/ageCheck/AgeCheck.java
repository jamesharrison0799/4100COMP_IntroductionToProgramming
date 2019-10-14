package ageCheck;

import java.util.Scanner;

public class AgeCheck {
	static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Please enter your age: ");
		int age = console.nextInt();
		
		if (age <= 17) {
			System.out.println("Unfortunately, you are not old enough to vote.");
		}else if (age >= 18) {
			System.out.println("You are old enough to vote");
			
			if (age <= 21) {
				System.out.println("You are aged between 18 and 21");
			}
			
		}
		
		
	}
}
