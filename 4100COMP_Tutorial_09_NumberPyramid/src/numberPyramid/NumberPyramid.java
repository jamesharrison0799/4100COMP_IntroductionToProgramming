package numberPyramid;

public class NumberPyramid {

	public static void main(String[] args) {
		
		int maxNum = 5; //ultimate max is 9
		
		for(int i = 1; i <= maxNum; i++) {
			int numberOfSpaces = maxNum - i;
			String space = " ";
			System.out.print(space.repeat(numberOfSpaces));
			for(int z = 0; z <= (i*2)-2; z++) {
				System.out.print(i);
			}
			System.out.print(space.repeat(numberOfSpaces));
			System.out.println();
		}
	}

}
