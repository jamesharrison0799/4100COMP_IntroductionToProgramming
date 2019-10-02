package problem;

public class ProblemSolving {

	public static void main(String[] args) {
		
		//1. Land Calculation
		
		int acre = 43560, land=389767;
		float x = land/acre;
		System.out.println("There are "+x+" acres in "+land+" Sq. Feet of land.");
		
		//2. Area of Rectangle
		
		double l = 25.7, w = 18.5, area = l*w;//Centimetre 
		System.out.println("The area of the rectange is: "+area+"cm");
		
		//3. Length of Fence
		
		int numOfPost=15;//meters
		double postGap=3.45, lenOfWire = postGap*numOfPost;//meters
		System.out.println("The required lenth of wire is: "+lenOfWire+" meters");
		
		//4.Average Mark (Named Constant)
	
		final int numOfStudents = 5;
		int A = 48, B=94,C=77,D=88,E=65;
		double average = (A+B+C+D+E)/numOfStudents;
		System.out.println("The Average Mark is: "+average+"/100");
	}

}
