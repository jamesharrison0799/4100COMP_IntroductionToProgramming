package resturant;

import java.util.Scanner;

public class Resturant {

	static Scanner input = new Scanner(System.in);
	static Table[] tables;
	static Booth[] booths;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		createTables();

		String choice = "";

		do {
			System.out.println("MENU");
			System.out.println("1 - View Bookings");
			System.out.println("2 - Book Table");
			System.out.println("3 - Cancel Table");
			System.out.println("4 - Quit");
			System.out.print(">>> ");

			choice = input.next();

			switch (choice) {
			case "1": {
				viewBookings();
				break;
			}
			case "2": {
				bookTable();
				break;
			}
			case "3": {
				cancelTable();
				break;
			}

			}
		} while (!choice.equals("4"));
		System.exit(0);
	}

	public static void createTables() {
		tables = new Table[8];
		int capacity = 0;
		for (int i = 0; i < tables.length; i++) {
			if (i + 1 == 1 || i + 1 == 2 || i + 1 == 7 || i + 1 == 8) {
				capacity = 4;
			} else if (i + 1 == 3 || i + 1 == 6) {
				capacity = 8;
			} else if (i + 1 == 4) {
				capacity = 2;
			} else if (i + 1 == 5) {
				capacity = 16;
			}
			tables[i] = new Table(i + 1, "", capacity);
		}
		
		booths = new Booth[5];
		for(int i = 0; i < booths.length; i++) {
			booths[i] = new Booth(i + 9, "" , 4);
		}
	}

	public static void viewBookings() {
		for (int i = 0; i < tables.length; i++) {
			if (isReserved(tables[i])) {
				System.out.println(tables[i].toString());
			} else {
				System.out.printf("Table %d is avaliable\n", i + 1);
			}
		}
	}

	public static boolean isReserved(Table table) {
		if (!table.getParty().isEmpty()) {
			return true;
		}
		return false;

	}

	public static boolean full() {
		for (int i = 0; i < tables.length; i++) {
			if (!isReserved(tables[i])) {
				return false;
			}
		}
		return true;

	}

	public static void bookTable() {
		System.out.println("===== BOOK TABLE =====");
		if (!full()) {
			System.out.println("Enter Name: ");
			String party = input.next();
			System.out.println("Enter Party Size: ");
			/**
			 * FIXME validate party size input 
			 * - can currently exceed maximum without warning 
			 * - data type validation (InputMismatchException)
			 */
			int partySize = input.nextInt();
			for (int i = 0; i < tables.length; i++) {
				if (!isReserved(tables[i]) && partySize <= tables[i].capacity) {
					tables[i].setParty(party);
					System.out.printf("Table %d booked for %s\n", (i + 1), party);
					return;
				}
			}
		} else {
			System.out.println("Sorry there are no tables avaliable.");
		}
	}

	public static void cancelTable() {
		System.out.println(" ===== CANCEL TABLE =====");
		System.out.println("Enter Name: ");
		String party = input.next();
		for (int i = 0; i < tables.length; i++) {
			if (tables[i].getParty().equals(party)) {
				tables[i].setParty("");
				System.out.printf("Table %d canceled for %s\n", (i + 1), party);
			}
		}
	}
}
