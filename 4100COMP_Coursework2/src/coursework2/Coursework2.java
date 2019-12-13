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

		// Will prevent the program from running if the data file is not found
		System.out.println("Checking for the existance of: \"" + m.file + "\"");
		if (readFile.fileCheck() != null) {
			System.out.println(readFile.fileCheck());
			onStart();
		} else {
			System.out.println("ERROR: DATA FILE NOT FOUND\nPROGRAM TERMINATED");
			quit(false);
		}

	}

	// Introduce the user and collect their email (email can be changed later if
	// required)
	public static void onStart() {

		System.out.println("Welcome to 'GENERIC SEAT BOOKING PROGRAM'!\nFor all your seat booking needs.\nTo start,");
		setEmail();
		System.out.printf("Email Confirmed\nWelcome %s\n\n\n", email);
		menu();
	}

	// ask the user for their email address
	public static void setEmail() {
		System.out.println("Please enter your email address.\n>");
		email = console.nextLine();
		// Check email
		if (!isValid(email, null)) {
			System.out.println("Email Address is invalid.");
			setEmail();
		}
	}

	// check the validity of various items using regular expressions
	public static boolean isValid(String email, String number) {
		// REGEX from https://www.owasp.org/index.php/OWASP_Validation_Regex_Repository

		// If statement to decide what type of check to perform on the data.
		// Chooses based on what data is not null, returns false if both or neither are
		// null
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
			format.printFunctionHeader("Seat Search", true);
			seatSearch();
			menu();
		case "2":
			// Reserve a seat (shows all available)
			format.printFunctionHeader("Reserve Seat", true);
			reserveSeat();
			menu();
		case "3":
			// Cancel a reservation, shows all reservations the user has
			format.printFunctionHeader("Cancel Reservation", false);
			cancelSeat();
			menu();
		case "4":
			// View all reservations associated with the users email
			format.printFunctionHeader("View Reservation", true);
			viewReservation();
			menu();
		case "5":
			// Change the email used to identify the user
			format.printFunctionHeader("Change Email", false);
			setEmail();
			menu();
		case "6":
			// Quit program based on exit parameters
			quit(true);
		default:
			menuError("Invalid Selection");
			menu();
		}
	}

	// Sub-menu displayed after a function has completed
	public static void postFunctionOptions(int t) {
		switch (t) {
		case 0:
			format.printMenu(Arrays.asList("Return to Menu", "QUIT"));
			switch (console.nextLine().toUpperCase()) {
			case "1":
				menu();
			case "2":
				quit(true);
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
				menuError("Invalid Selection");
				quit(true);
			}
		}
	}

	// ---------------Functions---------------
	// --- Seat Search
	// ask the user questions to create search parameters
	public static void seatSearch() {
		desiredClass = getSeatClass();
		wantWindow = getWantWindow();
		wantAisle = getWantAisle();
		wantTable = getWantTable();
		checkRange();

		matchSeats(desiredClass, wantWindow, wantAisle, wantTable, lowerPriceRange, upperPriceRange);
	}

	// Gets the price upper and lower boundaries of the price range and checks if
	// they are valid numbers using REGEX in isValid method
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

	// Get the price range for which the user is willing to pay and checks for
	// validity of the range
	public static void checkRange() {
		lowerPriceRange = getPriceRange(false);
		upperPriceRange = getPriceRange(true);

		if (lowerPriceRange > upperPriceRange) {
			System.out.println("You have not entered a valid range, please try again.");
			checkRange();
		}
	}

	// returns the desired seat class
	public static String getSeatClass() {
		System.out.println("In what class would you like to sit?");
		format.printMenu(Arrays.asList("1ST", "STANDARD"));
		switch (console.nextLine()) {
		case "1":
			return "1ST";
		case "2":
			return "STD";
		default:
			menuError("Invalid Selection");
		}

		return getSeatClass();
	}

	// returns if user wants a window seat or not
	public static boolean getWantWindow() {
		System.out.printf("In your %s class seat would you like a window?\n", desiredClass);
		format.printMenu(Arrays.asList("YES", "NO"));
		switch (console.nextLine()) {
		case "1":
			return true;
		case "2":
			return false;
		default:
			menuError("Invalid Selection");
		}

		return getWantWindow();
	}

	// returns if user wants an aisle seat or not
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
			menuError("Invalid Selection");
		}

		return getWantAisle();
	}

	// returns if user wants a table at their seat or not
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
			menuError("Invalid Selection");
		}

		return getWantTable();
	}

	// Search seats and find matches / partial matches based on a match score
	// parameter
	public static void matchSeats(String dC, boolean wW, boolean wA, boolean wT, double lR, double uR) {

		ArrayList<String> matches = new ArrayList<>();
		ArrayList<String> partialMatches = new ArrayList<>();
		ArrayList<String> partialMatchesWithScore = new ArrayList<>();

		// iterate through all unreserved
		for (String i : readFile.getData(null)) {
			ArrayList<String> seatParams = new ArrayList<>(Arrays.asList(i.split(" ")));
			// get exact matches
			int matchScore = 0;

			// Assign a score based upon how similar the seat parameters are to the search
			// if the price on the seat is outside of the users price range, it will be
			// excluded from partial matches
			for (int z = 0; z < seatParams.size(); z++) {
				if (z == 1 && seatParams.get(z).matches(dC)) {
					matchScore += 1;
				} else if (z == 2 && seatParams.get(z).matches(Boolean.toString(wW))) {
					matchScore += 1;
				} else if (z == 3 && seatParams.get(z).matches(Boolean.toString(wA))) {
					matchScore += 1;
				} else if (z == 4 && seatParams.get(z).matches(Boolean.toString(wT))) {
					matchScore += 1;
				} else if (z == 5 && (lR <= Double.parseDouble(seatParams.get(z))
						&& Double.parseDouble(seatParams.get(z)) < uR)) {
					matchScore += 1;
				} else if (z == 5 && !(lR <= Double.parseDouble(seatParams.get(z))
						&& Double.parseDouble(seatParams.get(z)) < uR)) {
					matchScore -= 10;
				}
			}
			if (matchScore == 5) {
				matches.add(i);
			} else if (matchScore < 5 && matchScore > 0) {
				partialMatchesWithScore.add(matchScore + " " + i);
			}

		}

		// sort partial match list based upon match score.
		Collections.sort(partialMatchesWithScore, Collections.reverseOrder());

		// remove score after sorting

		for (String i : partialMatchesWithScore) {
			partialMatches.add(i.substring(2));
		}

		// Check size of match list and display data or appropriate message
		// No matches or partial matches found, user is sent to menu
		if (matches.size() == 0 && partialMatches.size() == 0) { // NO MATCHES AND PARTIAL MATCHES
			System.out.println(
					"Sorry, no matches have been found.\nNo partial matches could be found either, try adjusting your price range.\n");
			menu();
		} else if (matches.size() > 0 && partialMatches.size() == 0) { // MATCHES BUT NO PARTIAL MATCHES
			showMatches(0, matches);
			postMatchesMenu(0, matches, partialMatches);

		} else if (matches.size() == 0 && partialMatches.size() > 0) { // NO MATCHES BUT PARTIAL MATCHES
			System.out.printf(
					"\n\nSorry, no matches have been found.\nHowever, the system found %d seat(s) that are similar to your requirements\n",
					partialMatches.size());
			postMatchesMenu(1, matches, partialMatches);

		} else if (matches.size() > 0 && partialMatches.size() > 0) { // MATCHES AND PARTIAL MATCHES
			showMatches(0, matches);
			System.out.printf("\n\nThe system also found %d seat(s) that are similar to your requiremnets\n",
					partialMatches.size());
			postMatchesMenu(2, matches, partialMatches);
		}

	}

	// Menu displayed after search results are shown to user
	// No matches or partial matches found, user is sent to menu
	// 0 - Matches found
	// 1 - Only partial matches found
	// 2 - Matches and partial matches found
	// 3 - Post partial seat list view
	public static void postMatchesMenu(int p, ArrayList<String> matches, ArrayList<String> partialMatches) {

		if (p == 0) { // 0
			format.printMenu(Arrays.asList("Proceed with matched seats", "Return to menu", "Quit"));
			switch (console.nextLine()) {
			case "1":
				processReservation(matches);
			case "2":
				menu();
			case "3":
				quit(true);
			default:
				menuError("Invalid Selection");
				postMatchesMenu(p, matches, partialMatches);
			}

		} else if (p == 1) { // 1
			format.printMenu(Arrays.asList("Show partially matched Seats", "Return to menu", "Quit"));
			switch (console.nextLine()) {
			case "1":
				showMatches(1, partialMatches);
				postMatchesMenu(3, matches, partialMatches);
			case "2":
				menu();
			case "3":
				quit(true);
			default:
				menuError("Invalid Selection");
				postMatchesMenu(p, matches, partialMatches);

			}

		} else if (p == 2) { // 2
			format.printMenu(Arrays.asList("Proceed with matched seats", "View partially matched seats",
					"Return to menu", "Quit"));
			switch (console.nextLine()) {
			case "1":
				processReservation(matches);
				menu();
			case "2":
				showMatches(1, partialMatches);
				postMatchesMenu(3, matches, partialMatches);
			case "3":
				menu();
			case "4":
				quit(true);
			default:
				menuError("Invalid Selection");
				postMatchesMenu(p, matches, partialMatches);
			}
		} else if (p == 3) { // 3
			format.printMenu(Arrays.asList("Proceed with partially matched seats", "Return to menu", "Quit"));
			switch (console.nextLine()) {
			case "1":
				processReservation(partialMatches);
			case "2":
				menu();
			case "3":
				menu();
			case "4":
				quit(true);
			default:
				menuError("Invalid Selection");
				postMatchesMenu(p, matches, partialMatches);

			}
		}

	}

	// Method to display match lists to user dependent on type parameter
	// 0 matches
	// 1 partial matches
	public static void showMatches(int type, ArrayList<String> data) {

		if (type == 0) {
			format.printFunctionHeader("Seats that match your requirements", true);
		} else {
			System.out.println("\n\n NOTE: SEATS ARE SORTED BASED UPON HOW CLOSLY THEY MATCH THE SEARCH PARAMETERS");
			format.printFunctionHeader("Seats similar to your requirements", true);
		}

		format.printTableHeader(false);

		for (String i : data) {
			System.out.println(format.formatData(i, false));
		}
	}

	// ---

	// --- RESERVE SEAT
	// method to reserve seat based upon all available
	// Shows all available to user and asks if they want to reserve a seat
	// if none available give user option to quit or return to menu.
	public static void reserveSeat() {

		// get unreserved seats by using readFile.getData() method with a null
		// parameter.
		// Null parameter is passed so the function knows to return free seats, if
		// string
		// is passed (the users email) it will return seats that are associated with
		// that email.
		if (readFile.getData(null) != null) {
			format.printTableHeader(false);
			for (String i : readFile.getData(null)) {
				System.out.println(format.formatData(i, false));
			}
			boolean menu = true;
			while (menu == true) {
				System.out.println("\n\nWould you like to reserve a seat?\n(Choose \"NO\" to return to menu)");
				format.printMenu(Arrays.asList("YES", "NO"));
				switch (console.nextLine()) {
				case "1":
					menu = false;
					processReservation(null);
				case "2":
					menu = false;
					menu();
				default:
					menu = true;
					menuError("Invalid Selection");
				}
			}
		} else {
			System.out.println("\n\nSorry!\nThere are no seats avaliable.");
			postFunctionOptions(0);
		}

	}

	// takes a list of seat IDs off the user and checks for validity then passes
	// them into the writeFile.changeReservation() function from WriteFile class
	public static void processReservation(ArrayList<String> matched) {
		int rejected = 0;
		boolean findSeat;
		System.out.println("\nPlease enter the seat number that you would like to reserve (press b to return to menu)\n"
				+ "Note: You can reserve many seats by entering multuple numbers seperated by spaces \n( EG: 1A 1B 6D )\n>>> ");
		String seatNumToReserve = console.nextLine();
		if (!seatNumToReserve.toUpperCase().matches("B")) {
			ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(seatNumToReserve.split(" ")));
			for (String i : numbers) {
				if (matched != null) {
					findSeat = matched.toString().contains(i.toUpperCase());
				} else {
					findSeat = readFile.getData(null).toString().contains(i.toUpperCase());
				}

				if (i.toUpperCase().matches("[1-9][A-Z]") && findSeat) {
					System.out.printf("Seat Found!\nAttempting to reserve seat %s!\n", i.toUpperCase());
					writeFile.changeReservation(i.toUpperCase(), email);
				} else {
					System.out.printf("\nUnable to process request for seat %s.\n", i.toUpperCase());
					rejected += 1;
				}

			}

			System.out.printf("\n\nSucessfully added %d reservation(s) for %s!\n\n", numbers.size() - rejected, email);

		} else if (seatNumToReserve.toUpperCase().matches("B")) {
			menu();
		} else {
			System.out.println("Invalid Input");
			processReservation(matched);
		}
	}

	// Method to show a list of seats associated with the users email
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

	// takes a list of seat IDs off the user and checks for validity then passes
	// them into the writeFile.changeReservation() function from WriteFile class
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
	
	//Shows a list of reservations associated with the users email address
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
	
	// terminates the program based upon certain exit conditions
	//false - Do not use 2-step verification exit
	//true - Use 2-step verification exit
	// ---

	// @param t - "0" quit without second approval
	public static void quit(boolean useTwoStep) {
		if (!useTwoStep) {
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
				menuError("Invalid Selection");
				quit(true);
			}
		}
	}

	//method to display an error in a menu system
	public static void menuError(String e) {
		System.out.println("MenuError\n" + e);
	}

}
