package arrays;

public class IntArrays {

	public static void main(String[] args) {

		int[] intArray = new int[5];
		intArray[0] = 21;
		intArray[1] = 33;
		intArray[2] = 58;
		intArray[3] = 17;
		intArray[4] = 9;

		intArray[1] = 3;

		intArray[4] = intArray[2] + intArray[3];

		System.out.printf("%d, %d, %d", intArray[1], intArray[2], intArray[4]);

	}

}
