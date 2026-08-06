class Solution {
    public int smallestNumber(int n, int t) {
        while (!(findDigitProduct(n) % t == 0)) {
            ++n;
        }
        return n;
    }
    private int findDigitProduct(int n) {
        int ans = 1;
        while (n > 0) {
            ans *= n % 10;
            n /= 10;
        }
        return ans;
    }
}