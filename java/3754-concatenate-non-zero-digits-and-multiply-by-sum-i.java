class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        long position = 1;
        while (n > 0) {
            if ((n % 10) != 0) {
                x += position * (n % 10);
                sum += (n % 10);
                position *= 10;
            }
            n /= 10;
        }
        return x * sum;
    }
}