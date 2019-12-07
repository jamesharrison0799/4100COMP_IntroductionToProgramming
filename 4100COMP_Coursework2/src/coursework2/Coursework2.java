package coursework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Coursework2 {

	static Scanner console = new Scanner(System.in);
	static Scanner read;
	static String email;
	static final String file = "seats.txt";
	
	public static void main(String[] args) {
	
		onStart();
	}
	
	public static void onStart() {
		System.out.println("Welcome to 'GENERIC SEAT BOOKING PROGRAM'!\nFor all your seat booking needs.\nTo start,");
		setEmail();
		System.out.printf("Welcome %s\n",email);
		//getDataStats();
		menu();
	}

	public static void setEmail() {
		System.out.println("Please enter your email.\n>");
		email = console.nextLine(); 	
		//Check email
		if(!isValidEmail(email)) {
			System.out.println("Email Address is invalid.");
			setEmail();
		}
	}
	
	public static boolean isValidEmail(String email) {
		//REGEX from https://www.owasp.org/index.php/OWASP_Validation_Regex_Repository
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,10}$"; 
		Pattern pat = Pattern.compile(emailRegex);
		if(email == null) {
			return false;
		}
		return pat.matcher(email).matches();
	}
	
	public static void readFile(){
		//DATA FORMAT: SEATNUM CLASS isWindow isAile isWindow PRICE AVALIABILITY/EMAIL
		
		
	}
	
	// ---------------MENU---------------
	public static void menu() {
		
		System.out.printf("- - MAIN MENU - -\n\nCurrent user: %s\n\n1 - Reserve Seat\n"
				+ "2 - Cancel Seat\n3 - View Seat Reservations\n4 - Change Email\nQ - Quit\nPick :\n",email);

		switch (console.nextLine().toUpperCase()) {
		case "1":
			reserveSeat();
			menu();
		case "2":
			cancelSeat();
			menu();
		case "3":
			viewReservation();
			menu();
		case "Q":
			quit();
		case "4":
			setEmail();
			menu();
		default:
			menuError("Invalid Selection");
		}
	}

	// ---------------Functions---------------
	public static void reserveSeat() {

	}

	public static void cancelSeat() {

	}

	public static void viewReservation() {

	}

	public static void quit() {
		System.out.println("The program is about to terminate.\nPress 'y'" + "key to continue, 'n' to return to menu.");
		switch (console.nextLine()) {
		case "y":
			System.exit(0);
		case "n":
			menu();
		default:
			quit();
		}
	}

	public static void menuError(String e) {
		System.out.println("MenuError\n" + e);
	}

}
