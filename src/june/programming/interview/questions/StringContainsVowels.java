package june.programming.interview.questions;

public class StringContainsVowels {

	public static void main(String[] args) {
		System.out.println(stringContainsVowels("Hello"));
		System.out.println(stringContainsVowels("TV"));
	}

	private static boolean stringContainsVowels(String input) {
		return input.toLowerCase().matches(".*[aeiou].*");
	}
}
