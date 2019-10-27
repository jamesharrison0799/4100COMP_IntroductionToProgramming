package intArrayAverage;

public class IntArrayAverage {

	public static void main(String[] args) {
		
		int[] val = new int[6];
		val[0] = 23;
		val[1]= 6;
		val[2]= 47;
		val[3]= 35;
		val[4]= 2;
		val[5]= 14;

		int sum = 0;
		for(int i = 0; i < val.length; i++) {
			sum += val[i];
		}
		System.out.println((double) sum/val.length);
	}

}
