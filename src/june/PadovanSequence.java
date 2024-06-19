package june;

public class PadovanSequence {
	public static long padovan(int n) {
        final int MOD = 1000000007;
        
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }
        
        long P0 = 1, P1 = 1, P2 = 1;
        
        for (int i = 3; i <= n; i++) {
            long Pn = (P1 + P0) % MOD;
            P0 = P1;
            P1 = P2;
            P2 = Pn;
        }
        
        return P2;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(padovan(n));  // Output: 2
        
        n = 4;
        System.out.println(padovan(n));  // Output: 2

        // Additional test cases
        n = 5;
        System.out.println(padovan(n));  // Output: 3
        
        n = 6;
        System.out.println(padovan(n));  // Output: 4

        n = 1000000;
        System.out.println(padovan(n));  // Output: (Large number modulo 10^9 + 7)
    }
}
