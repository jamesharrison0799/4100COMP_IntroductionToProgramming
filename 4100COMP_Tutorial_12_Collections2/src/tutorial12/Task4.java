package tutorial12;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		try {
			Scanner read = new Scanner(new FileReader("numbers.txt"));

			ArrayList<Integer> numbers = new ArrayList<>();

			while (read.hasNext()) {
				numbers.add(read.nextInt());
			}

			System.out.println(numbers);

			int sum = 0;
			for (int i = 0; i < numbers.size(); i++) {
				sum += numbers.get(i);
			}
			System.out.println("Average = " + (sum / numbers.size()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
