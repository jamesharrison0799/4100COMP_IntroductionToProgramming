package coursework2;

import java.util.*;
import java.util.regex.Pattern;

public class Coursework2 {

	static Scanner console = new Scanner(System.in);
	static String email;
	final public String file = "seats.txt";

	static Coursework2 m = new Coursework2();
	static ReadFile readFile = new ReadFile();
	static Formatting format = new Formatting();
	static WriteFile writeFile = new WriteFile();

	public static void main(String[] args) {

		System.out.println("Checking for the existance of: \"" + m.file + "\"");
		if (readFile.fileCheck() != null) {
			System.out.println(readFile.fileCheck());
			onStart();
		} else {
			System.out.println("ERROR: DATA FILE NOT FOUND\nPROGRAM TERMINATED");
			quit(0);
		}

	}

	public static void onStart() {

		System.out.println("Welcome to 'GENERIC SEAT BOOKING PROGRAM'!\nFor all your seat booking needs.\nTo start,");
		setEmail();
		System.out.printf("Email Confirmed\nWelcome %s\n\n\n", email);
		// getDataStats();
		menu();
	}

	public static void setEmail() {
		System.out.println("Please enter your email address.\n>");
		email = console.nextLine();
		// Check email
		if (!isValidEmail(email)) {
			System.out.println("Email Address is invalid.");
			setEmail();
		}
	}

	public static boolean isValidEmail(String email) {
		// REGEX from https://www.owasp.org/index.php/OWASP_Validation_Regex_Repository
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,10}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		}
		return pat.matcher(email).matches();
	}

	// ---------------MENU---------------
	public static void menu() {
		format.printFunctionHeader("Menu", false);
		format.printMenu(Arrays.asList("Reserve Seat", "Cancel Seat", "View Reservations",
				"Set Email(Current " + email + ")", "QUIT"));

		switch (console.nextLine()) {
		case "1":
			format.printFunctionHeader("Reserve Seat", false);
			reserveSeat();
			menu();
		case "2":
			format.printFunctionHeader("Cancel Reservation", false);
			cancelSeat();
			menu();
		case "3":
			format.printFunctionHeader("View Reservation", true);
			viewReservation();
			menu();
		case "4":
			format.printFunctionHeader("Change Email", false);
			setEmail();
			menu();
		case "5":
			quit(1);
		default:
			menuError("Invalid Selection");
			menu();
		}
	}

	public static void postFunctionOptions(int t) {
		switch (t) {
		case 0:
			format.printMenu(Arrays.asList("Return to Menu", "QUIT"));
			switch (console.nextLine().toUpperCase()) {
			case "1":
				menu();
			case "2":
				quit(1);
			}
		case 1:
			format.printMenu(Arrays.asList("Return to Menu", "Cancel a Reservation", "QUIT"));

			switch (console.nextLine().toUpperCase()) {
			case "1":
				menu();
			case "2":
				cancelSeat();
			case "3":
				quit(1);
			}
		}
	}

	// ---------------Functions---------------
	public static void reserveSeat() {
		format.printTableHeader(false);

		// get data (unreserved seats only) and print iteratively
		// f = unreserved seats
		// r = reserved seats
		String getType = "f";
		if (readFile.getData(getType, null) != null) {
			for (String i : readFile.getData(getType, null)) {
				System.out.println(format.formatData(i, false));
			}
		} else {
			System.out.println("\n\nSorry!\nThere are no seats avaliable.");
		}

		processReservation();
	}

	public static void processReservation() {
		System.out.println("\nPlease enter the seat number that you would like to reserve (press b to return)\n"
				+ "Note: You can reserve many seats by entering multuple numbers seperated by spaces ( EG: 1A 1B 6D )\n>>> ");
		String seatNumToReserve = console.nextLine();
		if (!seatNumToReserve.toUpperCase().matches("B")) {
			ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(seatNumToReserve.split(" ")));
			for (String i : numbers) {
				if (i.toUpperCase().matches("[1-9][A-Z]")
						&& readFile.getData("f", null).toString().contains(i.toUpperCase())) {
					System.out.printf("Seat Found!\nAttempting to %s!\n", i);
					writeFile.addReservation(i.toUpperCase(), email);
				}
			}
		} else if (seatNumToReserve.toUpperCase().matches("B")) {
			menu();
		} else {
			System.out.println("Invalid Input");
			processReservation();
		}
	}

	public static void cancelSeat() {
		format.printTableHeader(true);
		String getType = "r";
		if (readFile.getData(getType, email) != null) {
			for (String i : readFile.getData(getType, email)) {
				System.out.println(format.formatData(i, true));
			}
		} else {
			System.out.println("\n\nYou have not booked any seats.");
		}
		processCancel();

	}

	public static void processCancel() {
		System.out.println("\nPlease enter the seat number that you would ike to cancel (press b to return)\n"
				+ "Note: You can cancel many seats by entering multuple numbers seperated by spaces ( EG: 1A 1B 6D )\n>>>");
		String seatNumToCancel = console.nextLine();
		if (!seatNumToCancel.toUpperCase().matches("B")) {
			ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(seatNumToCancel.split(" ")));
			for (String i : numbers) {
				if (i.toUpperCase().matches("[1-9][A-Z]")
						&& readFile.getData("r", email).toString().contains(i.toUpperCase())) {
					System.out.printf("Seat Found!\n Attempting to cancel reservation for seat %s\n", i);
					writeFile.delReservation(i.toUpperCase());
				}
			}
		} else if (seatNumToCancel.toUpperCase().matches("B")) {
			menu();
		} else {
			System.out.println("Invalid Input");
			processCancel();
		}
	}

	public static void viewReservation() {
		String getType = "r";
		if (readFile.getData(getType, email) != null) {
			for (String i : readFile.getData(getType, email)) {
				System.out.println(format.formatData(i, false));
			}
			postFunctionOptions(1);
		} else {
			System.out.println("\n\nNo Bookings found");
			postFunctionOptions(0);
		}

	}

	// @param t - "0" quit without second approval
	public static void quit(int t) {
		if (t == 0) {
			System.exit(0);
		} else {
			System.out.println(
					"The program is about to terminate.\nPress 'y'" + "key to continue, 'n' to return to menu.");
			switch (console.nextLine()) {
			case "y":
				System.exit(0);
			case "n":
				menu();
			default:
				quit(1);
			}
		}
	}

	public static void menuError(String e) {
		System.out.println("MenuError\n" + e);
	}

}
