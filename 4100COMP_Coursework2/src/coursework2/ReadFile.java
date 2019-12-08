package coursework2;

import java.io.*;
import java.util.*;

public class ReadFile {

	// DATA FORMAT: SEATNUM CLASS isWindow isAile isWindow PRICE AVALIABILITY/EMAIL

	Coursework2 m = new Coursework2();

	Scanner reader;

	public String fileCheck() {
		System.out.println("Checking for the existance of: \""+m.file+"\"");
		if (new File(m.file).exists()) {
			return "Data file found...\n";
		}
		return null;
	}
}