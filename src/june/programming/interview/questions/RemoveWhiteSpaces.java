package june.programming.interview.questions;

public class RemoveWhiteSpaces {
	public static void main(String[] args) {
		System.out.println(removeWhiteSpaces("Rakesh Sonkar"));
	}
	
	public static String removeWhiteSpaces(String input) {
		StringBuilder outBuilder = new StringBuilder();
		char[] charArray = input.toCharArray();
		for(char c : charArray) {
			if(!Character.isWhitespace(c))
				outBuilder.append(c);
		}
		return outBuilder.toString();
	}

}
