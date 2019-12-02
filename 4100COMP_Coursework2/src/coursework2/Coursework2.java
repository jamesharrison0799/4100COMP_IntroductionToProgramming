package coursework2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coursework2 {

	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}

	public static void menu() {
		// clearConsole();
		System.out.println("- - Seat Booking System - -\n" + "\r\n" + "- - MAIN MENU - -\n" + "1 - Reserve Seat\n"
				+ "2 - Cancel Seat\n" + "3 - View Seat Reservations\n" + "Q - Quit\n" + "Pick :\n");
		String menuUserInput = console.nextLine();

		switch (menuUserInput) {
		case "1":
			reserveSeat();
		case "2":
			cancelSeat();
		case "3":
			viewReservation();
		case "Q":
			quit();
		default:
			menuError("Invalid Selection");
		}
	}

	public static void reserveSeat() {
		// Get list of available seats
		System.out.println(readFile(2, null));
	}

	public static void cancelSeat() {
		System.out.println("CANCEL SEAT");
	}

	public static void viewReservation() {
		System.out.println("VIEW RESERVATION");
	}

	public static void quit() {
		System.out.println("QUIT");
	}

	public static void menuError(String e) {
		System.out.println("MenuError\n" + e);
	}

	public static String getEmail() {
		String email = console.nextLine();
		return email;

	}

	// Types of file read:
	// 1 - get all
	// 2 - get all available
	// 3 - get specific
	public static ArrayList<String> readFile(int type, String email) {
		try {
			Scanner read = new Scanner(new FileReader("seats.txt"));

			ArrayList<String> lines = new ArrayList<>();
			ArrayList<String> availableSeats = new ArrayList<>();
			while (read.hasNext()) {
				String line = read.nextLine();
				lines.add(line);
			}

			switch (type) {
			case 1:
				return lines;
			case 2:
				for (String i : lines) {
					if (i.contains("free")) {
						availableSeats.add(i);
					}
				}
				return availableSeats;
			case 3:
				break;
			default:
				break;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			menu();
		}

		return null;
	}

	public static void clearConsole() {
		for (int i = 0; i <= 100; i++) {
			System.out.println("\n");
		}
	}
}