class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            ans <<= 1;
            ans += (n & 1);
            n >>= 1;
        }
        return ans;
        /*
        int[] bits = new int[32];
        int i = 31;
        while (n > 0) {
            bits[i--] = n % 2;
            n /= 2;
        }
        int ans = 0;
        for (int j = 0; j < 32; ++j) {
            ans += bits[j] * Math.pow(2, j);
        }
        return ans;
        */
    }
}