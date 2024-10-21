class Solution {
    public int numberOfSubstrings(String s, int k) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int[] count = new int[26];
            
            for (int j = i; j < n; ++j) {
                if (++count[s.charAt(j) - 'a'] == k) {
                    ans += n - j;
                    break;
                }
            }
        }
        return ans;
    }
}