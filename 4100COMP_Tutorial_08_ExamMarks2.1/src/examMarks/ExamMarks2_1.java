package examMarks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamMarks2_1 {

	static Scanner console = new Scanner(System.in) ;
	
	public static void main(String[] args) {
		
		
		List<Integer> studentScoresRaw = new ArrayList<>();
		List<String> studentScoresGrades = new ArrayList<>();

		//Controlled While Structure
		//Changes:
		//console output added to tell the user how to finish entry
		//changed while condition to true
		//check user input before processing: if == -1 ends loop (before data processing)
		
		System.out.println("Enter -1 to end the loop");
		
		int counter = 1;
		while(true) {

			System.out.printf("Student %d: ",counter);
			int userInput = console.nextInt();
			if(userInput == -1) {
				break;
			}else {
				studentScoresRaw.add(userInput);
				if(userInput >= 70 && userInput<=100) {
					studentScoresGrades.add("A");
				}else if( userInput>=60 && userInput<70) {
					studentScoresGrades.add("B");
				}else if (userInput >=50  && userInput < 60) {
					studentScoresGrades.add("C");
				}else if(userInput < 50 && userInput >= 0) {
					studentScoresGrades.add("D");
				}else if(userInput>100 || userInput>0) {
					studentScoresGrades.add("!");
				}
				counter++;
			}
		}
		
		//System.out.println(studentScoresRaw);
		//System.out.println(studentScoresGrades);
		
		System.out.println("\n-----SCORES-----\n");
		for(int i = 0; i<=studentScoresGrades.size(); i++){
		
			System.out.printf("Student %d\nScore: %d\tGrade: %s\n",(i+1),studentScoresRaw.get(i),studentScoresGrades.get(i));
			
		}
		
	}

}
