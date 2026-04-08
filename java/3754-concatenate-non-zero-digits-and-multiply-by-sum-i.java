class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        long tens = 1;
        int sum = 0;
        while (n > 0) {
            int mod = n % 10;
            if (mod != 0) {
                ans = tens * mod + ans;
                sum += mod;
                tens *= 10;
            }
            n /= 10;
        }

        return ans * sum;
    }
}