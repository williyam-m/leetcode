class Solution {
    public int countValidPrefixes(String s) {
        int zero = 0;
        int one = 0;
        int ans = 0;
        for (int c : s.toCharArray()) {
            if (c == '1') {
                ++one;
            }
            else {
                ++zero;
            }
            if (Math.abs(one - zero) <= 1) {
                ++ans;
            }
        }
        return ans;
    }
}