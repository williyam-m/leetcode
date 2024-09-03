class Solution {
    public int getLucky(String s, int k) {
        int n = convertToInt(s);
        return findSum(n, k - 1);
    }
    private int convertToInt(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            int num = (c - 'a') + 1;
            ans += num > 9 ? ((num / 10) + (num % 10)) : num;
        }
        return ans;
    }
    private int findSum(int n, int k) {
        while (k-- > 0) {
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }
}