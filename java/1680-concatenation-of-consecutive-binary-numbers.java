class Solution {
    public int concatenatedBinary(int n) {
        final int mod = 1_000_000_007;
        int bits = 0;
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            if ((i & (i - 1)) == 0) {
                ++bits;
            }
            ans = ((ans << bits) | i) % mod;
        }
        return (int) ans;
        /*
        final int mod = 1_000_000_007;
        StringBuilder binaryStr = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            binaryStr.append(Integer.toBinaryString(i));
        }
        int ans = 0;
        for (char c : binaryStr.toString().toCharArray()) {
            ans = (ans * 2) % mod;
            if (c == '1') {
                ans = (ans + 1) % mod;
            }
        }
        return ans;
        */
    }
}