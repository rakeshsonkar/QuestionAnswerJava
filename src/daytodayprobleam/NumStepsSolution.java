package daytodayprobleam;

public class NumStepsSolution {

	public int numSteps(String s) {
        int steps = 0;
        
        // Convert the binary string to a StringBuilder to allow modifications
        StringBuilder sb = new StringBuilder(s);
        
        // Iterate until the binary representation becomes "1"
        while (sb.length() > 1) {
            int len = sb.length();
            // If the last character is '0', the number is even, so divide by 2
            if (sb.charAt(len - 1) == '0') {
                sb.deleteCharAt(len - 1);
            } else {
                // If the number is odd, add 1
                int i = len - 1;
                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }
                if (i >= 0) {
                    sb.setCharAt(i, '1');
                } else {
                    sb.insert(0, '1');
                }
            }
            steps++;
        }
        
        return steps;
    }
	public static int numberSteps(String s) {
		int res = 0, carry = 0;

        for(int i = s.length() - 1; i> 0; i--){
            res++;
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                res ++;
            }

        }

        return res + carry;
	}
	
	public static void main(String[] args) {
		NumStepsSolution solution = new NumStepsSolution();
	        System.out.println(solution.numSteps("1101")); // Output: 6
	        System.out.println(solution.numSteps("10")); // Output: 1
	        System.out.println(solution.numSteps("1")); // Output: 0
	        
	        System.out.println(numberSteps("1101"));
	}
}
