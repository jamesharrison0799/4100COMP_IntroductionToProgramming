package recap;

public class Recap {
	public static void main(String[] args) {
		
		System.out.println("1. Using Variables\n");
		//Write a Java program that declares three integer variables num1, num2 and sum
		//Write statements to store 25 into num1 and 8 into num2.
		
		int num1 = 25, num2 = 8;
		
		//Then update the value of the variable num1 by adding 5 to it and write a java statement that stores the
		//vale of num1+num2 into sum
		
		num1 = num1+5;
		
		int sum = num1+num2;
		
		//Add statements to your program that output the values of num1, num2 and sum
		
		System.out.println("NUM1: "+num1+"\nNUM2: "+num2+"\nSUM: "+sum);
		
		//Declare two more variables: num3 and prod
		//Store the vale 2 in num3
		
		int num3 = 2, prod;
		
		//Add statements to calculate the product of sum and num3 and store the result in prod
		
		prod = sum*num3;
		
		//Add a statement to output the value of prod
		
		System.out.println("PROD: "+prod);
		
		
		/*
		------------------------------------------------------------------------------------------------------
		------------------------------------------------------------------------------------------------------
		------------------------------------------------------------------------------------------------------
		------------------------------------------------------------------------------------------------------
		*/
		
		System.out.println("\n2. Variable state and sequential execution\n");
		//Rewrite your program such that it does not use the variable sum to perform the same calculation from step 7
		
		System.out.println("SUM(num1+num2): "+(num1+num2));
		
		//Remove the variable prod, replacing it with sum (sum2)
		
		int sum2 = (num1+num2)*num3;
		
		//Structure the program so that the output statements can still show the results required in step 3 and step 7
		System.out.println("\n\nNUM1: "+num1+"\nNUM2: "+num2+"\nSUM(num1+num2): "+(num1+num2)+"\nPROD(sum2): "+sum2);
		
	}
}
