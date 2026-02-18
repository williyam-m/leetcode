class Solution {
    public boolean hasAlternatingBits(int n) {
        int curr = n & 1;
        n >>= 1;
        while (n > 0) {
            if (curr == (n & 1)) {
                return false;
            }
            curr = n & 1;
            n >>= 1;
        }
        return true;
        /*
        int[] bits = new int[32];
        int i = 31;
        for (; i >= 0; --i) {
            bits[i] = n & 1;
            n >>= 1;
        }
        ++i;
        for (; i < 32; ++i) {
            if (bits[i] == 1) {
                break;
            }
        }
        for (; i < 31; ++i) {
            if (bits[i] == bits[i + 1]) {
                return false;
            }
        }
        return true;
        */
    }
}