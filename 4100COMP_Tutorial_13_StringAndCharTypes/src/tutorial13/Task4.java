package tutorial13;

import java.util.StringTokenizer;

public class Task4 {

	public static void main(String[] args) {
		String text = "The quick brown fox jumps over the lazy dog";
		System.out.println(toTitleCase(text));
		System.out.println(toTitleCase(wordSwap("dog", "fox", text)));
	}

	// task 4
	public static String toTitleCase(String text) {
		StringBuilder titleCase = new StringBuilder(text.length());
		boolean nextTitleCase = true;

		for (char c : text.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				nextTitleCase = true;
			} else if (nextTitleCase) {
				c = Character.toTitleCase(c);
				nextTitleCase = false;
			}
			titleCase.append(c);
		}

		return titleCase.toString();
	}

	// task5
	public static String wordSwap(String wordToSwap, String swapWith, String fullString) {
		
		String result = "";
		
		if(!fullString.contains(wordToSwap) || !fullString.contains(swapWith)) {
			return "Can not swap words";
		}else {
			StringTokenizer tokenisedString = new StringTokenizer(fullString);
			while(tokenisedString.hasMoreElements()) {
				String str = tokenisedString.nextToken();
				if(str.equals(wordToSwap)) {
					result += swapWith + " ";
				}else if(str.equals(swapWith)) {
					result += wordToSwap + " ";
				}else {
					result += str+" ";
				}
					
			}
		}
		
		return result;
	}
}
