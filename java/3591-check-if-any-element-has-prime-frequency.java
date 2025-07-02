class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int[] count = new int[101];
        for (int n : nums) {
            ++count[n];
        }
        for (int c : count) {
            if (c > 0 && isPrime(c)) {
                return true;
            }
        }
        return false;
    }
    private boolean isPrime (int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }
}