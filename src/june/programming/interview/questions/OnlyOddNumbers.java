package june.programming.interview.questions;

import java.util.List;

public class OnlyOddNumbers {

	public static void main(String[] args) {
		List<Integer> ls = List.of(1, 2, 3, 4, 6, 8, 9, 2, 35);
		System.out.println(onlyOddNumbers2(ls));
		System.out.println(onlyOddNumbers(ls));
	}

	private static boolean onlyOddNumbers(List<Integer> ls) {
		for (int i : ls) {
			if (i % 2 == 0)
				return false;
		}
		return true;
	}

	public static boolean onlyOddNumbers2(List<Integer> list) {
		return list.parallelStream().anyMatch(x -> x % 2 != 0);
	}
}
