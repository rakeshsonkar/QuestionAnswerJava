package july;

import java.util.Stack;

public class ReverseSubstrings {
	public static void main(String[] args) {
		String str = "(abcd)";
		String str1 = "(u(love)i)";
		String str2 = "(ed(et(oc))el)";
		System.out.println(reverseParenthes(str));
		System.out.println(reverseParenthes(str1));
		System.out.println(reverseParentheses2(str2));
	}

	public static String reverseParenthes(String s) {
		Stack<Integer> open = new Stack<>();
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				open.push(res.length());
			} else if (ch == ')') {
				int l = open.pop();
				String reversed = new StringBuilder(res.substring(l)).reverse().toString();
				res.replace(l, res.length(), reversed);
			} else {
				res.append(ch);
			}
		}

		return res.toString();
	}
	
    public static String reverseParentheses2(String s) {
        int n = s.length();
        Stack<Integer> openBracketIdx = new Stack<>();
        int[] door = new int[n];

        // Traverse the string and find matching parentheses
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openBracketIdx.push(i);
            } else if (s.charAt(i) == ')') {
                int j = openBracketIdx.pop();
                door[i] = j;
                door[j] = i;
            }
        }

        // Construct the result string by traversing and reversing as needed
        StringBuilder result = new StringBuilder();
        int flag = 1;

        for (int i = 0; i < n; i += flag) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = door[i];
                flag = -flag;
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

}
