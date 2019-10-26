package largestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LargestNumber {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 0; i<10;i++) {
			int uI = console.nextInt();
			if(uI < 0) {
				break;
			}else {
				numbers.add(uI);
			}
		}
		System.out.printf("You have entered %d numbers, the largest of which is %d",numbers.size(),Collections.max(numbers));

	}

}
