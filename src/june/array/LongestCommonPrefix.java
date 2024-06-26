package june.array;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] arr, int N) {
		if (N == 0)
			return "-1";
		if (N == 1)
			return arr[0];

		String prefix = arr[0];

		for (int i = 1; i < N; i++) {
			while (arr[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "-1";
			}
		}

		return prefix;
	}

	public static void main(String[] args) {
		String[] arr1 = { "geeksforgeeks", "geeks", "geek", "geezer" };
		System.out.println(longestCommonPrefix(arr1, arr1.length)); // Output: "gee"

		String[] arr2 = { "hello", "world" };
		System.out.println(longestCommonPrefix(arr2, arr2.length)); // Output: "-1"
	}
}
