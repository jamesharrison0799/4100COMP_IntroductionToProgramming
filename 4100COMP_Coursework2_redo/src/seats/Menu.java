package seats;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {

	static Scanner console = new Scanner(System.in);
	static String email;

	static boolean exit = false;
	static String fileName = "seats.txt";
	final public static File file = new File(fileName);

	static Seat[] seats;

	public static void main(String[] args) {
		startUp();
		loadSeats();
		do {
			menu();
		} while (!exit);
	}

	// --- Start Up ---
	public static void startUp() {
		if (dataCheck() == true) {
			h("START UP");
			getEmail();
		} else {
			System.exit(0);
		}
	}

	public static Boolean dataCheck() {
		h("DATA CHECK");
		System.out.println("Checking Data File...");
		if (file.exists()) {
			System.out.println("Data File Found.");
			System.out.println("Absolute path: " + file.getAbsolutePath());
			return true;
		} else {
			System.out.println("Data File Not Found");
			return false;
		}
	}

	public static void getEmail() {
		// console.reset();
		do {
			System.out.println("Please enter your email address\n>>>");
			email = console.next();
			if (!isValid(email)) {
				System.out.println("email is invalid" + email);
			}
		} while (!isValid(email));
		System.out.println("Email Set: " + email);
	}

	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{1,10}$";
		Pattern pat = Pattern.compile(emailRegex);
		return pat.matcher(email).matches();
	}

	public static boolean isValid(String input, int lRange, int uRange) {
		String numberRegex = "^\\$?([0-9]{1,3},([0-9]{3},)*[0-9]{3}|[0-9]+)(.[0-9][0-9])?$";
		Pattern pat = Pattern.compile(numberRegex);
		if (pat.matcher(input).matches() && Integer.parseInt(input) >= lRange && Integer.parseInt(input) <= uRange) {
			return true;
		} else {
			return false;
		}
	}

	// --- loadSeats ---
	public static void loadSeats() {
		Scanner reader = null;
		try {
			reader = new Scanner(file);
			seats = new Seat[countLines()];

			for (int i = 0; i < seats.length; i++) {
				String seatNum = reader.next();
				String seatClass = reader.next();
				String isWindow = reader.next();
				String isAisle = reader.next();
				String isTable = reader.next();
				String price = reader.next();
				String isAvaliable = reader.next();
				seats[i] = new Seat(seatNum, seatClass, isWindow, isAisle, isTable, price, isAvaliable);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			reader.close();
		}
	}

	// --- menu ---
	public static void menu() {

		ArrayList<String> menuItems = new ArrayList<>(Arrays.asList("Seat Search", "Show All Avaliable Seats",
				"Cancel Seat", "View Reservations", "Change Email (Current: " + email + ")", "Exit Program"));
		switch (menuGen("Main Menu", menuItems)) {
		case "1":
			h("Seat Search");
			seatSearch();
			break;
		case "2":
			h("Show All Reservations");
			showAllFree();
			break;
		case "3":
			System.out.println("Cancel");
			break;
		case "4":
			viewReservation();
			break;
		case "5":
			getEmail();
			break;
		case "6":
			exit = true;
			break;
		default:
			System.out.println("Its fucked m8");
			break;
		}
	}

	public static void seatSearch() {

		String desiredSeatClass;
		String wantWindow = null;
		String wantAisle = null;
		String wantTable = null;

		ArrayList<String> menuItems = new ArrayList<>(Arrays.asList("YES", "NO"));

		//FIXME desired Seat Class
		// --
		System.out.println("Select Class");
		desiredSeatClass = getSeatClasses().get(Integer.parseInt(menuGen(getSeatClasses())));

		// --
		System.out.println("Would you like a window seat?");

		switch (menuGen(menuItems)) {
		case "1":
			wantWindow = "true";
			break;
		case "2":
			wantWindow = "false";
			break;
		default:
			System.out.println("fucked lmao");
			break;
		}

		// --
		System.out.println("Would you like a Aisle seat?");
		switch (menuGen(menuItems)) {
		case "1":
			wantAisle = "true";
			break;
		case "2":
			wantAisle = "false";
			break;
		default:
			System.out.println("fucked lmao");
			break;
		}

		System.out.println("Would you like a Table seat?");
		switch (menuGen(menuItems)) {
		case "1":
			wantTable = "true";
			break;
		case "2":
			wantTable = "false";
			break;
		default:
			System.out.println("fucked lmao");
			break;
		}

		int counter = 0;
		ArrayList<String> seatMatches = new ArrayList<>();
		ArrayList<String> partialMatches = new ArrayList<>();

		for (int i = 0; i < seats.length; i++) {
			counter = 0;
			if (seats[i].isFree()) {
				if (seats[i].seatClass.matches(desiredSeatClass)) {

					counter += 1;
				}
				if (seats[i].isWindow.matches(wantWindow)) {

					counter += 1;
				}
				if (seats[i].isAisle.matches(wantAisle)) {

					counter += 1;
				}
				if (seats[i].isTable.matches(wantTable)) {

					counter += 1;
				}

				if (counter == 4) {
					seatMatches.add(seats[i].seatNum);
				} else if (counter > 0 && counter < 4) {
					partialMatches.add(seats[i].seatNum);
				}
			}
		}

		if (!seatMatches.isEmpty()) {
			System.out.printf("\nThere was %d seat(s) that matched your requirements\n", seatMatches.size());
			switch (menuGen((ArrayList<String>) Arrays.asList("Book Seats", "View Partial Matches", "Return to Menu"))) {
			case "1":
				bookSeats(seatMatches);
				break;
			case "2":
				// showAllFree();
				break;
			case "3":
				menu();
				break;
			}

		} else {
			if (!partialMatches.isEmpty()) {
				System.out.printf("There where no seats found, however there where %d seats"
						+ " that partially matched your requirements.", partialMatches.size());
			} else {
				System.out.println("Ther where no seats found.");
			}
		}


	}

	public static void bookSeats(ArrayList<String> avaliableSeats) {

		System.out.println(avaliableSeats.toString());

		System.out.println("\nPlease enter the seat number that you would like to reserve (press b to return to menu)\n"
				+ "Note: You can reserve many seats by entering multuple numbers seperated by spaces \n( EG: 1A 1B 6D )\n>>> ");

		String seatNumToReserve;
		Scanner in = new Scanner(System.in);
		seatNumToReserve = in.nextLine();
		in.close();
		ArrayList<String> basket = new ArrayList<>();

		if (!seatNumToReserve.toUpperCase().matches("B")) {
			ArrayList<String> input = new ArrayList<String>(Arrays.asList(seatNumToReserve.split(" ")));
			for (String i : input) {
				if (i.toUpperCase().matches("[1-9][A-Z]") && validSeat(i) && avaliableSeats.contains(i.toUpperCase())) {
					basket.add(i.toUpperCase());
				} else {
					System.out.println(i + " is invalid");
				}
			}
		} else {
			menu();
		}

		// print out basket and calc total price

		double totalPrice = 0;

		for (int i = 0; i < basket.size(); i++) {
			for (int z = 0; z < seats.length; z++) {
				if (basket.get(i).matches(seats[z].seatNum)) {
					seats[z].printInfo();
					totalPrice += Double.parseDouble(seats[z].price);
				}
			}
		}

		System.out.println("£" + totalPrice);

		int option;
		do {

			do {
				System.out.println("Confirm Booking?\n1 - YES\n2 - NO (return to menu)");
				option = console.nextInt() - 1;
			} while (option < 0 || option > 1);

			switch (option + 1) {
			case 1:
				for (int i = 0; i < basket.size(); i++) {
					for (int z = 0; z < seats.length; z++) {
						if (seats[z].seatNum.matches(basket.get(i))) {
							System.out.println("set seat");
							seats[z].setSeat(email);
						}
					}
				}

				saveData();
			case 2:
				menu();
				break;
			}

		} while (option != 0);

	}

	public static boolean validSeat(String q) {
		int counter = 0;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i].seatClass.matches(q.toUpperCase()) && seats[i].isFree()) {
				counter += 1;
			}
		}
		if (counter < 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void saveData() {
		try {
			PrintWriter write = new PrintWriter(file);
			for (int i = 0; i < seats.length; i++) {
				System.out.println(seats[i].writeData());
				write.append(seats[i].writeData());
			}
			write.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, could not write data.\nFile Not Found");
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getSeatClasses() {
		ArrayList<String> classes = new ArrayList<String>();
		for (int i = 0; i < seats.length; i++) {
			if (!classes.contains(seats[i].seatClass)) {
				classes.add(seats[i].seatClass);
			}
		}
		return classes;
	}

	public static void showAllFree() {
		for (int i = 0; i < seats.length; i++) {
			if (seats[i].isFree()) {
				seats[i].printParams();
			}
		}
	}

	public static void viewReservation() {
		for (int i = 0; i < seats.length; i++) {
			if (seats[i].isAvaliable.matches(email)) {
				seats[i].printParams();
			}
		}
	}

	public static void clearReservations() {
		viewReservation();
	}

	// https://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
	// added plus one to return lmao
	public static int countLines() throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		try {
			byte[] c = new byte[1024];

			int readChars = is.read(c);
			if (readChars == -1) {
				// bail out if nothing to read
				return 0;
			}

			// make it easy for the optimiser to tune this loop
			int count = 0;
			while (readChars == 1024) {
				for (int i = 0; i < 1024;) {
					if (c[i++] == '\n') {
						++count;
					}
				}
				readChars = is.read(c);
			}

			// count remaining characters
			while (readChars != -1) {
				// System.out.println(readChars);
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
				readChars = is.read(c);
			}

			return count == 0 ? 1 : count + 1;
		} finally {
			is.close();
		}
	}

	// main menu
	public static String menuGen(String h, ArrayList<String> items) {
		h(h);
		String option;
		for (int i = 0; i < items.size(); i++) {
			System.out.printf("%d - %s\n", i + 1, items.get(i));
		}
		do {
			option = console.nextLine();
		} while (!isValid(option, 0, items.size()));
		return option;
	}

	// sub menu
	public static String menuGen(ArrayList<String> items) {
		String option;
		for (int i = 0; i < items.size(); i++) {
			System.out.printf("%d - %s\n", i, items.get(i));
		}
		do {
			option = console.nextLine();
		} while (!isValid(option, 0, items.size()));
		return option;
	}

	public static void h(String t) {
		System.out.println("------------------------------");
		System.out.println(t);
		System.out.println("------------------------------");
	}

}
