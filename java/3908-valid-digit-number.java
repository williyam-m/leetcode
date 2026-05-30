class Solution {
    public boolean validDigit(int n, int x) {
        boolean flag = false;
        while (n >= 10) {
            if (!flag && n % 10 == x) {
                flag = true;
            }
            n /= 10;
        }
        return n != x && flag;
    }
}