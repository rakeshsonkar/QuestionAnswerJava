package june.programming.interview.questions;

public class PalindromeString {

	public static void main(String[] args) {
		System.out.println(checkPalindromeString("rakesh"));
		System.out.println(checkPalindromeString("madam"));
	}
	
	public static boolean checkPalindromeString(String inputString) {
		boolean result = true;
		int length = inputString.length();
		
		for (int i = 0; i < length/2; i++) {
			if(inputString.charAt(i) != inputString.charAt(length - i - 1)) {
				result = false;
				break;
			}
		}
		return result;
	}
}
