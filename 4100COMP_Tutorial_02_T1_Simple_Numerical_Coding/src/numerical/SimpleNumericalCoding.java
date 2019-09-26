package numerical;

public class SimpleNumericalCoding {
	public static void main(String[] args) {
		
		/*
		 * ORIGINAL CODE
		 * 
		int integer1;
		int integer2;
		int sum;
		
		integer1=10;
		integer2=20;
		sum= integer1+integer2;
		
		System.out.println("The sum value is: "+ sum);
		*/
		
		int integer1;
		int integer2;
		double sum, sub, mul, div, mod;
		
		integer1=10;
		integer2=20;
		sum = integer1+integer2;
		sub = integer1-integer2;
		mul = integer1*integer2;
		div = integer1/integer2;
		mod = integer1%integer2;
		System.out.println("SUM: "+sum+"\nSUB: "+sub+"\nMULTIPLY: "+mul+"\nDIV: "+div+"\nMOD: "+mod);
	}
}
