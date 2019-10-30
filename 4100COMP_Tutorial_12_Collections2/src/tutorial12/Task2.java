package tutorial12;

import java.util.ArrayList;

public class Task2 {

	public static void main(String[] args) {

		int[] fixedArray = { 10, 20, 30 };

		ArrayList<Integer> variableArray = new ArrayList<>();

		for (int i = 0; i < fixedArray.length; i++) {
			variableArray.add(fixedArray[i]);
		}

		// System.out.println(variableArray);

		for (int i = 0; i < variableArray.size(); i++) {
			System.out.printf("%d ", variableArray.get(i));
		}

		System.out.println("\nSize: " + variableArray.size());

	}

}
