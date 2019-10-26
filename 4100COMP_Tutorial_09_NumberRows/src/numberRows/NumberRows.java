package numberRows;

public class NumberRows {

	public static void main(String[] args) {
		
		int maxNum = 5;
		
		for(int i = 1; i<=maxNum;i++) {
			for(int z = 0; z < i;z++) {
				System.out.print(i);
			}
			System.out.println();
		}

	}

}
