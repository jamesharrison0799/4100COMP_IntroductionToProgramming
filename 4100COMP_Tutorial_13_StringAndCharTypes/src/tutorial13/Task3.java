package tutorial13;

import java.util.Scanner;

public class Task3 {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Please enter your First name:\n>>> ");
		String first_name = console.nextLine();
		System.out.println("Please enter your Second name:\n>>> ");
		String second_name = console.nextLine();
		getProperties(first_name,second_name);
		
	}

	public static void getProperties(String first, String second) {
		System.out.printf(""
				+ "Your full name is %s\n"
				+ "Your initials are: %s%s\n"
				+ "Your First name has %d characters\n"
				+ "Your Second name has %d characters\n",
				first+" "+second,
				first.charAt(0),second.charAt(0),
				first.length(),
				second.length()
				);
	}
}
