class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int num = left; num <= right; ++num) {
            if (isPrime(bitCount(num))) {
                ++ans;
            }
        }
        return ans;
    }
    private int bitCount(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 6; i * i <= num; i += 6) {
            if (num % (i - 1) == 0 || num % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }
}