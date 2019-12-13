package coursework2;

import java.io.*;
import java.util.*;

public class WriteFile {

	Coursework2 m = new Coursework2();
	ReadFile readFile = new ReadFile();
	Scanner scan;

	// Method to make changes to the file. Uses seat num as an identifier then
	// modifies the appropriate line
	// change type:
	// = true - Set Reservation
	// = false - Delete Reservation
	public void changeReservation(String seatNum, String email) {
		try {
			BufferedReader file = new BufferedReader(new FileReader(m.file));
			StringBuffer inputBuffer = new StringBuffer();
			String line;
			String outputText = null;

			while ((line = file.readLine()) != null) {
				if (line.contains(seatNum)) {
					if (email != null) {
						line = modifyLine(readFile.getData(seatNum).remove(0).toString(), email);
						outputText = "added";
					} else if (email == null) {
						line = modifyLine(readFile.getData(seatNum).remove(0).toString(), null);
						outputText = "deleted";
					}
				}
				inputBuffer.append(line);
				inputBuffer.append("\n");
			}
			file.close();

			FileOutputStream fileOut = new FileOutputStream(m.file);
			fileOut.write(inputBuffer.toString().getBytes());
			fileOut.close();
			System.out.printf("Sucessfully %s reservation for seat %s\n", outputText, seatNum);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to change the data being written to the file based on if email is null
	// if email is not null (ie, user has inputed their email) the program can
	// assume that they want to add their email to a seat, therefore email is
	// appended to the string buffer and added to the line in the file.
	//
	// if null value is passed the program will remove bookings associated with that
	// email by appending "free" to the string buffer instead of their email
	public String modifyLine(String data, String email) {
		String[] output = data.split(" ");
		StringBuffer b = new StringBuffer();
		int dataWidth;

		dataWidth = output.length - 1;

		for (int i = 0; i < dataWidth; i++) {
			b.append(output[i] + " ");
		}

		if (email != null) {
			b.append(email);
		} else {
			b.append("free");
		}
		return b.toString();
	}

}
