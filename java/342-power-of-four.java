class Solution {
    public boolean isPowerOfFour(int n) {
        return (Integer.bitCount(n) == 1 && Integer.numberOfTrailingZeros(n) % 2 == 0);
        /*
        if (n < 4 && n != 1)
           return false;
        while (n > 1) {
            if (n % 4 != 0)
               return false;
            n /= 4;
        }
        return true;
        */
    }
}