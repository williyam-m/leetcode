class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;
        while (n > 0) {
            int digit = (n % 10);
            if (digit != 0) {
                x *= 10;
                x += digit;
                sum += digit;
            }
            n /= 10;
        }
        return (long) sum * reverse(x);
    }
    private int reverse(int num) {
        int ans = 0;
        while (num > 0) {
            ans *= 10;
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}