class Solution {
    public int smallestNumber(int n, int t) {
        int ans = n;
        while (true) {
            if (prodOfDigits(ans) % t == 0)
               break;
            ++ans;
        }
        return ans;
    }
    private int prodOfDigits(int n) {
        int res = 1;
        while (n != 0) {
            res *= (n % 10);
            n /= 10;
        }
        return res;
    }
}