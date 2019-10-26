package arrays;

public class strArray {
	public static void main(String[] args) {
		
		String[] strArray = new String[5];
		
		strArray[0] = "This";
		strArray[1] = "is";
		strArray[2] = "a";
		strArray[3] = "String";
		strArray[4] = "Array";
		
		for(int i = 0; i <= strArray.length; i++) {
			System.out.print(strArray[i] +" ");
		}
		
	}
}
