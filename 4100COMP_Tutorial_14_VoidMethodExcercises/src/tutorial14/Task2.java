package tutorial14;

import java.util.Scanner;

public class Task2 {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("What is your name?: ");
		String name = console.nextLine();

		helloName(name);

	}

	public static void helloName(String name) {
		System.out.printf("Hello %s",name);
	}
}
