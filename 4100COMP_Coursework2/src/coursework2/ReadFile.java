package coursework2;

import java.io.*;
import java.util.*;

public class ReadFile {

	// DATA FORMAT: SEATNUM CLASS isWindow isAile isWindow PRICE AVALIABILITY/EMAIL

	Coursework2 m = new Coursework2();

	Scanner reader;

	// Method to check if data file exists
	public String fileCheck() {
		if (new File(m.file).exists()) {
			return "Data file found...\n";
		}
		return null;
	}

	// Method to open file
	public void openFile() {
		try {
			reader = new Scanner(new FileReader(m.file));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			Coursework2.quit(true); // terminates the program
		}
	}

	// Method to close file
	public void closeFile() {
		reader.close();
	}

	// Returns data in the form of an ArrayList<Stirng> from data file.
	// Knows to return reserved or unreserved seat data based upon whether a
	// string variable is passed or a null variable is passed.
	// If a null variable is passed the program can assume that the user wants to
	// find unreserved files
	public ArrayList<String> getData(String e) {

		ArrayList<String> r = new ArrayList<>();
		openFile();
		while (reader.hasNext()) {
			String temp = reader.nextLine();
			// Reserved
			if (e != null) {
				if (temp.contains(e)) {
					r.add(temp);
				}
			}
			// Free
			else if (e == null) {
				if (temp.endsWith("free")) {
					r.add(temp);
				}
			}
		}

		closeFile();
		if (r.isEmpty()) {
			return null;
		} else {
			return r;
		}
	}
}
