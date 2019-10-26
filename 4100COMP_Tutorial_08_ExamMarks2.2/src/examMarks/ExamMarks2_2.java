package examMarks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamMarks2_2 {

	static Scanner console = new Scanner(System.in) ;
	
	public static void main(String[] args) {
		
		try {
			FileReader file = new FileReader("studentScores.txt");
			Scanner read = new Scanner(file);
			
			List<String> lines = new ArrayList<>();
			
			while(read.hasNext()) {
				String line = read.nextLine();
				lines.add(line);
			}
			
			int counter = 1;
			for(int i = 0; i <= lines.size(); i+=3) {
				String studentFirstName = lines.get(i);
				String studentLastName = lines.get(i+1);
				int studentScore = Integer.parseInt(lines.get(i+2));
				String studentGrade = null;
				if(studentScore >= 70 && studentScore<=100) {
					studentGrade = "A";
				}else if( studentScore>=60 && studentScore<70) {
					studentGrade = "B";
				}else if (studentScore >=50  && studentScore < 60) {
					studentGrade = "C";
				}else if(studentScore < 50 && studentScore >= 0) {
					studentGrade = "D";
				}else if(studentScore>100 || studentScore>0) {
					studentGrade = "!";
				}
				
				System.out.printf("\nStudent: %d\nName: %s, %s\nScore: %d\nGrade: %s\n"
						,counter,studentLastName,studentFirstName,studentScore,studentGrade);
				counter++;
				
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read file\n" + e);
		}
	}

}
