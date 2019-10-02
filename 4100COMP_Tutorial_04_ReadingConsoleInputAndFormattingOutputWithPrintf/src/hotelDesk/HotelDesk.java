package hotelDesk;
import java.util.Scanner;

public class HotelDesk {
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Enter room number (1-999): ");
		int roomNumber = console.nextInt();
		System.out.print("Room price (0.99 - 999.99): ");
		float roomPrice = console.nextFloat();
		
		System.out.printf("Room Number %03d costs £%.2f.", roomNumber,roomPrice);
	}

}
