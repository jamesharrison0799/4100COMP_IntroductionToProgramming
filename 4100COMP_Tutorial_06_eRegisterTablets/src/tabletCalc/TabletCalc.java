package tabletCalc;

import java.util.Scanner;

public class TabletCalc {
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		
		int numberOfTablets = 0;
		System.out.println("Number of Students: ");
		int numberOfStudents = console.nextInt();
		
		if(numberOfStudents < 40) {
			numberOfTablets = 1; 
		}else {
			numberOfTablets = (numberOfStudents - 40)/30+2;
		}
		System.out.printf("There are a total of %d students.\nYou will need %d tablets for the eRegister", numberOfStudents, numberOfTablets);
	}

}
