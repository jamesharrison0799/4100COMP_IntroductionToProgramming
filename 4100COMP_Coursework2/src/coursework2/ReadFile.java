package coursework2;

import java.io.*;
import java.util.*;

public class ReadFile {

	// DATA FORMAT: SEATNUM CLASS isWindow isAile isWindow PRICE AVALIABILITY/EMAIL

	Coursework2 m = new Coursework2();

	Scanner reader;

	public String fileCheck() {
		if (new File(m.file).exists()) {
			return "Data file found...\n";
		}
		return null;
	}

	public void openFile() {
		try {
			reader = new Scanner(new FileReader(m.file));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			Coursework2.quit(0); // terminates the program
		}
	}

	public void closeFile() {
		reader.close();
	}

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
