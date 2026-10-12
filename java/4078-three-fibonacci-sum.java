class Solution {
    public boolean threeFibonacciSum(int n) {
        if (n % 2 != 0) {
            return false;
        }
        // must be c * 2
        int first = 1;
        int second = 1;
        while (second <= n) {
            if (second + second == n) {
                return true;
            }
            int next = first + second;
            first = second;
            second = next;
        }
        return false;
    }
}