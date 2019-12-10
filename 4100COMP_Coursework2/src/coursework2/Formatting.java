package coursework2;

import java.util.*;

public class Formatting {

	int lineRepeat = 87, lineRepeatWithEmail = 120, lineRepeatMenu = 25;

	public String printDiv(int type) {

		switch (type) {
		case 1:
			return "-".repeat(lineRepeat);
		case 2:
			return "-".repeat(lineRepeatWithEmail);
		case 3:
			return "-".repeat(lineRepeatMenu);
		default:
			return "-";
		}
	}

	public void printFunctionHeader(String functionName, boolean withEmail) {
		if (withEmail) {
			System.out.printf("%s\n\t\t\t\t%s\n%s\n", printDiv(1), functionName, printDiv(1));
		} else {
			System.out.printf("%s\n\t\t\t\t%s\n%s\n", printDiv(2), functionName, printDiv(2));
		}
	}

	public void printTableHeader(boolean withEmail) {
		// DATA FORMAT: SEATNUM CLASS isWindow isAisle isTable PRICE AVALIABILITY/EMAIL
		if (withEmail) {
			System.out.printf("%s\nSEAT NUM\tSEAT CLASS\tWINDOW\t\tAISLE\t\tTABLE\t\tPRICE\t\tEMAIL\n%s\n", printDiv(2),
					printDiv(2));
		} else {
			System.out.printf("%s\nSEAT NUM\tSEAT CLASS\tWINDOW\t\tAISLE\t\tTABLE\t\tPRICE\n%s\n", printDiv(1),
					printDiv(1));
		}
	}

	public void printMenu(List<String> list) {
		System.out.println(printDiv(3));
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d - %s\n", i + 1, list.get(i));
		}
		System.out.println(printDiv(3));
		System.out.println(">>> ");
	}

	public String formatData(String data, boolean withEmail) {
		String[] output = data.split(" ");
		StringBuffer b = new StringBuffer();
		int dataWidth;

		// Omit email data where it is not required
		if (!withEmail) {
			dataWidth = output.length - 1;
		} else {
			dataWidth = output.length;
		}

		for (int i = 0; i < dataWidth; i++) {
			if (i == 2 || i == 3 || i == 4) {
				if (output[i].matches("true")) {
					b.append("YES\t\t");
				} else if (output[i].matches("false")) {
					b.append("NO\t\t");
				}

			} else {
				b.append(output[i] + "\t\t");

			}
		}
		return b.toString();

	}

}
