class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls)
            sum += roll;

        int mean2 = ((n + rolls.length) * mean) - sum;
        if (mean2 > 6 * n || mean2 < n) 
            return new int[] {};
        
        int[] rolls2 = new int[n];
        Arrays.fill(rolls2, mean2 / n);
        mean2 %= n;

        for (int i = 0; i < mean2; ++i) {
            ++rolls2[i];
        }
        return rolls2;
    }
}