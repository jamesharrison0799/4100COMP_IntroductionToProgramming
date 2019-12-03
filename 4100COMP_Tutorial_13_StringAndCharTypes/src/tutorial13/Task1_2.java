package tutorial13;


public class Task1_2 {

	public static void main(String[] args) {
		String name = "JamesHarrison";
		System.out.printf("Task ONE\nSecond: %s \nFifth: %s \nNumber of Chars: %d \nUpperCase: %s \n\n",name.charAt(1),name.charAt(4),name.length(),name.toUpperCase());
		
		System.out.printf("Task TWO\n%s",new StringBuilder(name).reverse().toString());
		
	}
	
}
