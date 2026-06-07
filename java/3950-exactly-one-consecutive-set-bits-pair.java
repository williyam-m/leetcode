class Solution {
    public boolean consecutiveSetBits(int n) {
        int consecutive = 0;
        while (n > 0) {
            if ((n & 3) == 3) {
                if (++consecutive > 1) {
                    return false;
                }
            }
            n >>= 1;
        }
        return consecutive == 1;
        /*
        int consecutive = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == '1' && str.charAt(i + 1) == '1') {
                if (++consecutive > 1) {
                    return false;
                }
            }
            
        }
        return consecutive == 1;
        */
    }
}