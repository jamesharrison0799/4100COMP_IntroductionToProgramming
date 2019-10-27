package intArrayAverage;

import java.util.Arrays;

public class IntArrayAverage {

	public static void main(String[] args) {
		
		int[] val = new int[6];
		val[0] = 23;
		val[1]= 6;
		val[2]= 47;
		val[3]= 35;
		val[4]= 2;
		val[5]= 14;

		int sum = 0, largestNumber = val[0], smallestNumber = val[0];
		for(int i = 0; i < val.length; i++) {
			sum += val[i];
			if(val[i]>largestNumber) {
				largestNumber = val[i];
			}else if(val[i]<smallestNumber) {
				smallestNumber = val[i];
			}
				
			//Print odd numbers only
			if(!(val[i] % 2 == 0)) {
				System.out.println(val[i]);
			}
		}
		System.out.printf("Average: %f\nMin: %d\nMax: %d\n",(double) sum/val.length,largestNumber, smallestNumber);
		
		Arrays.sort(val);
		
		System.out.print("Sorted Array: ");
		for(int i = 0; i<val.length; i++) {
			System.out.print(val[i] + " ");
		}
	}

}
