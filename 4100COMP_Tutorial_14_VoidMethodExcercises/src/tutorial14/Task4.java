package tutorial14;

import java.util.Scanner;

public class Task4 {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int hour=0,  min =0;
		
		System.out.println("Please enter an event name.\n>");
		String eventName = console.nextLine();
		System.out.println("Please enter the time at wich the event happens. (HH:MM)\n>");
		String time = console.nextLine();
		if(time.matches("\\d{2}:\\d{2}")) {
			hour = Integer.parseInt(time.substring(0,2));
			min = Integer.parseInt(time.substring(3, 5));
			diaryReminder(eventName,hour,min);
		}else {
			System.out.println("Invalid Input - Restart Program.");
		}
		
	}

	public static void diaryReminder(String eventName, int hour, int min) {
		System.out.printf("---- EVENT REMINDER ----\nTitle: %s\nTime:%d:%d",eventName, hour, min);
	}
	
}
