package tutorial12;

import java.util.ArrayList;
import java.util.Arrays;

public class Task1 {

	public static void main(String[] args) {

		ArrayList<String> strArray = new ArrayList<>();

		strArray.addAll(Arrays.asList("Fred", "Alice", "Bob"));

		items(strArray);

		strArray.add("Sue");
		
		items(strArray);
		
		strArray.removeAll(Arrays.asList("Fred","Alice"));
		
		items(strArray);
	}
	
	public static void items(ArrayList<String> strArray) {
		for (int i = 0; i < strArray.size(); i++) {
			System.out.printf("%s ", strArray.get(i));
		}

		System.out.println("\nSize: " + strArray.size());
	}

}
