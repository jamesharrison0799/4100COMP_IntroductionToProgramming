package tutorial12;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {
	
	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<>();

		try {
			Scanner read = new Scanner(new FileReader("words.txt"));
			while(read.hasNext()) {
				words.add(read.next());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(words);
		
		for(int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			if(word.endsWith("s")) {
				words.remove(i);
			}
		}
		
		System.out.println(words);
	}

}
