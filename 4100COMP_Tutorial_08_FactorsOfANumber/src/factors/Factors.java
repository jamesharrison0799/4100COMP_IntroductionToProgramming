package factors;

import java.util.ArrayList;
import java.util.List;

public class Factors {

	public static void main(String[] args) {
		int number = 3195; //Number that program will find factors of.
		
		List<Integer> factors = new ArrayList<>();
		
		System.out.printf("The factors of %d are:\n",number);
		for(int i = 1; i< number; i++) { //i must start from 1 to prevent divide by 0 error
			if(number % i == 0 ) {
				System.out.println(i);
				factors.add(i);
			}
		}
		
		System.out.printf("\nThe largest factor is: %d", factors.get(factors.size()-1));

	}

}
