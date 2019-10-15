package reading;

import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.util.Scanner;
import java.io.PrintWriter;

public class ReadingFromAFileFormat1 {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "vehicle.txt";
		
		FileReader file = new FileReader(fileName);
		Scanner read = new Scanner(file);
		//System.out.println(read);
		String vehicleName = read.nextLine();
		double mpg = read.nextDouble();
		int fuelCapacity = read.nextInt(), fuelCost = read.nextInt();
		System.out.printf("Vehicle %s holds %d  litres of fuel at a cost of %dp/litre. "
				+ "On average, it returns %.1f mpg.",vehicleName,fuelCapacity,fuelCost,mpg );
		
		//Task 3
		
		final double litresInGallon = 4.54609;
		double fullTankCost = (fuelCost * fuelCapacity)/100;
		double range = (fuelCapacity/litresInGallon)*mpg;
		System.out.printf("\nIt will cost £%.2f to fuel the vehicle at the specified rates. On average, this"
				+ " will give the vehicle a range of %.1f miles.",fullTankCost,range);
		
		//Task 4
		
		PrintWriter write = new PrintWriter("vehicle.out");
		write.printf("%s\n%.1f %d %d\n%.1f %.2f",vehicleName,mpg,fuelCapacity,fuelCost,range,fullTankCost);
		write.close();
		
		
		//Supplementary Task
		if(mpg>50) {
			System.out.println("\n\nOn behalf of the environment, thank you for choosing a fuel efficient car!");
		}else if(mpg<30) {
			System.out.println("\n\nYou are being chastised for choosing a gas guzziling vehicle!");
		}
	}
}
