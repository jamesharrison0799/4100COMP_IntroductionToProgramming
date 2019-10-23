package logicalOperators;

public class LogicalOperators {
	public static void main(String[] args) {
		int a = 10, b = 20;
		double c = 13.2;
		char d = 'D';
		
		boolean one = (b>=a+2), two = ((15>a)&&(b<21)), three = ((a<b-7)||(a+b == 42)), four = ((c/2<10)||(d=='d')&&(a+b==25));
		
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);	
		
	}
}
