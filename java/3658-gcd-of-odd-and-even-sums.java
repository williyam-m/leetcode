class Solution {
    public int gcdOfOddEvenSums(int n) {
        return findGcd(n * (n + 1), n * n);
    }
    private int findGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGcd(b, a % b);
    }
}