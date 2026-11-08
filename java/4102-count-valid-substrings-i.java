class Solution {
    public long countValidSubstrings(String s) {
        long ans = 0;
        int n = s.length();
        int left = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= 2 && s.charAt(i - 2) == 'a' && s.charAt(i - 1) == 'b' && s.charAt(i) == 'c') {
                left = i - 1;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}