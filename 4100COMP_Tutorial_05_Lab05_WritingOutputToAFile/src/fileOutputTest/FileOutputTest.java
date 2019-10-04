package fileOutputTest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutputTest {

	public static void main(String[] args) throws FileNotFoundException{
		PrintWriter write = new PrintWriter("test1.txt");
		write.println("Hello File! Welcome to 4100COMP");
		write.close();

	}

}
