class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int score = 0;
            for (int j = 0; j < n - 1; ++j) {
                int pos = i + j;
                if (s.charAt(pos % n) == s.charAt((pos + 1) % n)) {
                    ++score;
                }
            }
            if (score == k) {
                ++ans;
            }
        }
        return ans;
    }
}