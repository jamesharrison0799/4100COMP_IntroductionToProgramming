package tutorial12;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3 {

	public static void main(String[] args) {

		ArrayList<String> strArray = new ArrayList<>();

		strArray.addAll(Arrays.asList("Fred", "Alice", "Bob"));

		getProperties(strArray);

		strArray.add("Sue");

		getProperties(strArray);

		strArray.removeAll(Arrays.asList("Fred", "Alice"));

		getProperties(strArray);
	}

	public static void getProperties(ArrayList<String> strArray) {
		for (int i = 0; i < strArray.size(); i++) {
			System.out.printf("%s ", strArray.get(i));
		}

		System.out.println("\nSize: " + strArray.size());
		
		if(strArray.contains("Fred")) {
			System.out.println("Fred is present");
		}else {
			System.out.println("No Fred");
		}
		
		System.out.println("\n");
		
	}
	

}
