package stars;

import java.util.Scanner;

public class Stars {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("How many stars? >>> ");
		int userInput = input.nextInt();
		
		for(int i = 1; i <= userInput; i++) {
			System.out.print("*");
		}
		
	}

}
