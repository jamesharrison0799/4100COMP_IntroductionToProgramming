package coursework2;

import java.util.*;
import java.util.regex.Pattern;

public class Coursework2 {

	static Scanner console = new Scanner(System.in);
	static String email;
	final public String file = "seats.txt";

	static String desiredClass;
	static double lowerPriceRange, upperPriceRange;
	static boolean wantWindow, wantAisle, wantTable;

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
		if (!isValid(email, null)) {
			System.out.println("Email Address is invalid.");
			setEmail();
		}
	}

	public static boolean isValid(String email, String number) {
		// REGEX from https://www.owasp.org/index.php/OWASP_Validation_Regex_Repository
		if (email != null && number == null) {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,10}$";
			Pattern pat = Pattern.compile(emailRegex);
			return pat.matcher(email).matches();
		} else if (email == null && number != null) {
			String numberRegex = "^\\$?([0-9]{1,3},([0-9]{3},)*[0-9]{3}|[0-9]+)(.[0-9][0-9])?$";
			Pattern pat = Pattern.compile(numberRegex);
			return pat.matcher(number).matches();
		} else {
			return false;
		}

	}

	// ---------------MENU---------------
	public static void menu() {
		format.printFunctionHeader("Menu", true);
		format.printMenu(Arrays.asList("Seat Search", "Reserve Seat (Show All Avaliable)", "Cancel Seat",
				"View Reservations", "Change Email(Current: " + email + ")", "QUIT"));

		switch (console.nextLine()) {
		case "1":
			// Search for a seat based upon specific requirements
			format.printFunctionHeader("Seat Search", false);
			seatSearch();
			menu();
		case "2":
			// Reserve a seat
			format.printFunctionHeader("Reserve Seat", true);
			reserveSeat();
			menu();
		case "3":
			format.printFunctionHeader("Cancel Reservation", false);
			cancelSeat();
			menu();
		case "4":
			format.printFunctionHeader("View Reservation", true);
			viewReservation();
			menu();
		case "5":
			format.printFunctionHeader("Change Email", false);
			setEmail();
			menu();
		case "6":
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
				menu();
			case "3":
				quit(1);
			}
		}
	}

	// ---------------Functions---------------
	// --- Seat Search
	public static void seatSearch() {
		desiredClass = getSeatClass();
		wantWindow = getWantWindow();
		wantAisle = getWantAisle();
		wantTable = getWantTable();
		getRange();

		matchSeats(desiredClass, wantWindow, wantAisle, wantTable, lowerPriceRange, upperPriceRange);
	}

	public static void getRange() {
		lowerPriceRange = getPriceRange(false);
		upperPriceRange = getPriceRange(true);

		if (lowerPriceRange > upperPriceRange) {
			System.out.println("You have not entered a valid range, please try again.");
			getRange();
		}
	}

	public static String getSeatClass() {
		System.out.println("In what class would you like to sit?");
		format.printMenu(Arrays.asList("1ST", "STANDARD"));
		switch (console.nextLine()) {
		case "1":
			return "1ST";
		case "2":
			return "STD";
		default:
			System.out.println("Invalid input");
		}

		return getSeatClass();
	}

	public static boolean getWantWindow() {
		System.out.printf("In your %s class seat would you like a window?\n", desiredClass);
		format.printMenu(Arrays.asList("YES", "NO"));
		switch (console.nextLine()) {
		case "1":
			return true;
		case "2":
			return false;
		default:
			System.out.println("Invalid input");
		}

		return getWantWindow();
	}

	public static boolean getWantAisle() {
		if (wantWindow) {
			System.out.printf("In your %s class seat with a window", desiredClass);
		} else {
			System.out.printf("In your %s class seat without a window", desiredClass);
		}

		System.out.print(" would you like to be on an Aisle?\n");
		format.printMenu(Arrays.asList("YES", "NO"));
		switch (console.nextLine()) {
		case "1":
			return true;
		case "2":
			return false;
		default:
			System.out.println("Invalid Input");
		}

		return getWantAisle();
	}

	public static boolean getWantTable() {
		if (wantWindow) {
			if (wantAisle) {
				System.out.printf("In your %s class that is on an aisle and has a window", desiredClass);
			} else {
				System.out.printf("In your %s class seat with a window that isnt on an aisle", desiredClass);
			}
		} else {
			if (wantAisle) {
				System.out.printf("In your %s class seat that is on an aisle and does not have a window", desiredClass);
			} else {
				System.out.printf("In your %s class seat without a window and that is not on an aisle", desiredClass);
			}
		}

		System.out.print(" would you like a table?\n");
		format.printMenu(Arrays.asList("YES", "NO"));
		switch (console.nextLine()) {
		case "1":
			return true;
		case "2":
			return false;
		default:
			System.out.println("Invalid Input");
		}

		return getWantTable();
	}

	// range = false - lower
	// range = true - upper
	public static double getPriceRange(Boolean range) {
		if (range) {
			System.out.println("Whats the most you'd like to pay for this seat?\n>>>");
		} else {
			System.out.println("Whats the least you'd like to pay for this seat?\n>>>");
		}
		String num = console.nextLine();
		if (isValid(null, num)) {
			return Double.parseDouble(num);
		}
		return getPriceRange(range);
	}

	public static int getQuantity() {
		System.out.println("How many seats would you like to book?");
		String num = console.nextLine();

		return getQuantity();
	}

	public static void matchSeats(String dC, boolean wW, boolean wA, boolean wT, double lR, double uR) {

		ArrayList<String> matches = new ArrayList<>();
		ArrayList<String> partialMatches = new ArrayList<>();
		ArrayList<String> partialMatchesExclPrice = new ArrayList<>();

		// iterate through all unreserved
		for (String i : readFile.getData(null)) {
			ArrayList<String> seatParams = new ArrayList<>(Arrays.asList(i.split(" ")));
			// get exact matches
			if (seatParams.get(1).matches(dC) && seatParams.get(2).matches(Boolean.toString(wW))
					&& seatParams.get(3).matches(Boolean.toString(wA))
					&& seatParams.get(4).matches(Boolean.toString(wT)) && Double.parseDouble(seatParams.get(5)) > lR
					&& Double.parseDouble(seatParams.get(5)) < uR) {
				matches.add(i);

			} else if ((seatParams.get(1).matches(dC) || seatParams.get(2).matches(Boolean.toString(wW))
					|| seatParams.get(3).matches(Boolean.toString(wA))
					|| seatParams.get(4).matches(Boolean.toString(wT))) && Double.parseDouble(seatParams.get(5)) > lR
					&& Double.parseDouble(seatParams.get(5)) < uR && !matches.contains(i)) {
				partialMatches.add(i);
			} else if (seatParams.get(1).matches(dC) || seatParams.get(2).matches(Boolean.toString(wW))
					|| seatParams.get(3).matches(Boolean.toString(wA))
					|| seatParams.get(4).matches(Boolean.toString(wT)) && !matches.contains(i)
							&& !partialMatches.contains(i)) {
				partialMatchesExclPrice.add(i);
			}
		}

		if (matches.size() > 1) {
			System.out.printf("\n%d matches have been found\n\n", matches.size());
		} else {
			System.out.printf("\n%d match has been found\n\n", matches.size());
		}

		format.printTableHeader(false);

		for (String i : matches) {
			System.out.println(format.formatData(i, false));
		}

		if (partialMatches.size() == 0) {
			format.printMenu(Arrays.asList("Proceed with matched seats", "Return to menu"));
			switch(console.nextLine()) {
			case"1":
				// HERE JAMES HERE YOU FUCK THIS IS WHERE YOU WHERE UPTO!!!!!!!!!!!!
			}
		} else {
			if (partialMatches.size() > 1) {
				System.out.printf("\n\n%d partial matches have been found! Select \"View Partial Matches\" to view\n\n",
						partialMatches.size());
			} else {
				System.out.printf("\n\n%d partial match has been found!  Select \"View Partial Matches\" to view.\n\n",
						partialMatches.size());
			}
			format.printMenu(Arrays.asList("Proceed with matched seats","View partial matches","Return to menu"));
		}
	}

	public static void showPartialMatches(ArrayList<String> partial) {

	}

	// ---
	// --- RESERVE SEAT
	public static void reserveSeat() {
		format.printTableHeader(false);

		// get data (unreserved seats only) and print iteratively
		// f = unreserved seats
		// r = reserved seats
		if (readFile.getData(null) != null) {
			for (String i : readFile.getData(null)) {
				System.out.println(format.formatData(i, false));
			}
			boolean menu = true;
			while (menu == true) {
				System.out.println("\n\nWould you like to reserve a seat?\n(Choose \"NO\" to return to menu");
				format.printMenu(Arrays.asList("YES", "NO"));
				switch (console.nextLine()) {
				case "1":
					menu = false;
					processReservation();
				case "2":
					menu = false;
					menu();
				default:
					menu = true;
					System.out.println("Invalid input");
				}
			}
		} else {
			System.out.println("\n\nSorry!\nThere are no seats avaliable.");
			postFunctionOptions(0);
		}

	}

	public static void processReservation() {
		System.out.println("\nPlease enter the seat number that you would like to reserve (press b to return to menu)\n"
				+ "Note: You can reserve many seats by entering multuple numbers seperated by spaces \n( EG: 1A 1B 6D )\n>>> ");
		String seatNumToReserve = console.nextLine();
		if (!seatNumToReserve.toUpperCase().matches("B")) {
			ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(seatNumToReserve.split(" ")));
			for (String i : numbers) {
				if (i.toUpperCase().matches("[1-9][A-Z]")
						&& readFile.getData(null).toString().contains(i.toUpperCase())) {
					System.out.printf("Seat Found!\nAttempting to reserve seat %s!\n", i.toUpperCase());
					writeFile.changeReservation(i.toUpperCase(), email);
				}
			}
			System.out.printf("\n\nSucessfully added %d reservation(s) for %s!\n\n", numbers.size(), email);
		} else if (seatNumToReserve.toUpperCase().matches("B")) {
			menu();
		} else {
			System.out.println("Invalid Input");
			processReservation();
		}
	}
	// ---

	// --- CANCEL SEAT
	public static void cancelSeat() {
		if (readFile.getData(email) != null) {
			format.printTableHeader(true);
			for (String i : readFile.getData(email)) {
				System.out.println(format.formatData(i, true));
			}
		} else {
			System.out.println("\n\nYou have not booked any seats.\nReturning to menu...\n\n");
			menu();
		}
		processCancel();

	}

	public static void processCancel() {
		System.out.println("\nPlease enter the seat number that you would ike to cancel (press b to return)\n"
				+ "Note: You can cancel many seats by entering multuple numbers seperated by spaces \n( EG: 1A 1B 6D )\n>>>");
		String seatNumToCancel = console.nextLine();
		if (!seatNumToCancel.toUpperCase().matches("B")) {
			ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(seatNumToCancel.split(" ")));
			for (String i : numbers) {
				if (i.toUpperCase().matches("[1-9][A-Z]")
						&& readFile.getData(email).toString().contains(i.toUpperCase())) {
					System.out.printf("Seat Found!\n Attempting to cancel reservation for seat %s\n", i.toUpperCase());
					writeFile.changeReservation(i.toUpperCase(), null);
				}
			}
		} else if (seatNumToCancel.toUpperCase().matches("B")) {
			menu();
		} else {
			System.out.println("Invalid Input");
			processCancel();
		}
	}
	// ---

	// --- VIEW RESERVATION
	public static void viewReservation() {
		if (readFile.getData(email) != null) {
			format.printTableHeader(true);
			for (String i : readFile.getData(email)) {
				System.out.println(format.formatData(i, true));
			}
			postFunctionOptions(1);
		} else {
			System.out.println("\n\nNo Bookings found");
			postFunctionOptions(0);
		}

	}
	// ---

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
