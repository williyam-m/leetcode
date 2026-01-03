class Solution {
    public int numOfWays(int n) {
        long A = 6; // different pattern e.g. ABC
        long B = 6; // alternative pattern e.g. ABA
        int MOD = 1_000_000_007;

        for (int i = 1; i < n; ++i) {
            long newA = (A * 2 + B * 2) % MOD;
            long newB = (A * 2 + B * 3) % MOD;
            A = newA;
            B = newB;
        }
        return (int) (A + B) % MOD;
        /* Next row possibility
        newA : different (ABC) Pattern
        > ABC {BCA, CAB} + ABA {BCB, BAB}

        newB : alternative (ABA) Pattern
        > ABC {BAC, CAB} + ABA {BCB, BAB, CAC}
        */
    }
}