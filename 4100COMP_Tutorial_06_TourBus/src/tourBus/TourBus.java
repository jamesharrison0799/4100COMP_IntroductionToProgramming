package tourBus;
import java.util.Scanner;

public class TourBus {
		static Scanner console = new Scanner(System.in);
		
		public static void main(String[] args) {
			int seated, wheelchair, standing;
			System.out.println("Seated: ");
			seated = console.nextInt();
			System.out.println("Wheelchair: ");
			wheelchair = console.nextInt();
			System.out.println("Standing:");
			standing = console.nextInt();
			
			if((seated >= 60 && wheelchair >= 2 && standing >= 15) || (seated >= 60 && wheelchair >= 0 && standing >= 17)) {
				System.out.println("The bus is full");
			}else {
				System.out.println("The bus is not full");
			}
		}
}
