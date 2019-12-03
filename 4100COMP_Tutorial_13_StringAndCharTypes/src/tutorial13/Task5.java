package tutorial13;

import java.util.Scanner;

public class Task5 {
	
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("--- Ceaser Cipher ---\n"
				+ "Please enter the message you wish to encrypt>>>");
		String msg = console.nextLine();
		
		long key = 0;
		System.out.println("Please enter an encryption key: ");
		try {
			key = console.nextInt();
		}catch(Exception e){
			System.out.println("Invalid key\n" + e);
			e.printStackTrace();
		}
		
		System.out.println(encryptMsg(msg.toLowerCase(),key));
	}
	
	public static String encryptMsg(String msg, long key) {
		char[] msgBuffer = msg.toCharArray();
		
		for(int i=0; i<msgBuffer.length; i++) {
			char letter = msgBuffer[i];
			letter = (char) (letter + key);
			if (letter > 'z'){
				letter = (char) (letter - 26);
			}else if(letter < 'a') {
				letter = (char) (letter + 26);
			}
			
			msgBuffer[i] = letter;
		}
		
		return String.valueOf(msgBuffer);
	}

}
