package reading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ReadingFromAFileFormat2 {
	public static void main(String[] args) throws IOException {
		String fileName = "vehicle.txt";
		String[][] vehicles = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			int counter = 0;
			int lineNum = 0;
			while (true) {
				
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				
				//System.out.println(line);
				if (counter == 0) {
					System.out.println("0 "+line);
					counter = counter + 1;
					continue;
				}
				if(counter == 1){
					System.out.println("1 "+line);
					counter +=1;
					continue;
				}
				if(counter == 2){
					counter = 0;
					continue;
				}
				
			}
			
		}
		
		
		
	}
}
