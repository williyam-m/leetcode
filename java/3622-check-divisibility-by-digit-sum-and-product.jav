class Solution {
    public boolean checkDivisibility(int n) {
        return n % (findSum(n) + findProduct(n)) == 0;
    }
    private int findSum (int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
    private int findProduct (int n) {
        int ans = 1;
        while (n > 0) {
            ans *= n % 10;
            n /= 10;
        }
        return ans;
    }
}