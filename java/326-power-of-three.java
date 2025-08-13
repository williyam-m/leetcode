class Solution {
    public boolean isPowerOfThree(int n) {
        return ( n > 0 && ( (int) Math.pow(3, 19) ) % n == 0);
        // 3 ^ 19 is the max number 
        /*
        if (n < 3 && n != 1) //because 3^0 == 1
           return false;
        while (n > 1) {
            if (n % 3 != 0)
               return false;
            n /= 3;
        }
        return true;
        */
    }
}