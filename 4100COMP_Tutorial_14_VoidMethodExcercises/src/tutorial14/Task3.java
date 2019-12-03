package tutorial14;

import java.util.Scanner;

public class Task3 {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the first number\n>");
		int firstNumber = console.nextInt();
		System.out.println("Enter the Second number\n>");
		int secondNumber = console.nextInt();
		
		numCompare(firstNumber, secondNumber);
	}
	
	public static void numCompare(int a, int b) {
	
		if(a>b) {
			System.out.printf("%d is bigger", a);
		}else if (a<b){
			System.out.printf("%d is bigger", b);
		}else if (a == b) {
			System.out.println("Neither is bigger");
		}
	}

}
