class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (check(0, 0, String.valueOf(i * i), 0, i)) {
                ans += i * i;
            }
        }
        return ans;
    }
    private boolean check (int sum, int running, String num, int s, int target) {
        if (s == num.length())
           return target == sum + running;
        int d = num.charAt(s) - '0';

        return check(sum, running * 10 + d, num, s + 1, target) ||
           check(sum + running, d, num, s + 1, target);
    } 
}