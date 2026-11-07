class Solution {
    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int[] count = new int[26];
            int max = 0;
            int min = 0;
            for (int j = i; j < n; ++j) {
                int curr = s.charAt(j) - 'a';
                max = Math.max(max, ++count[curr]);
                min = max;
                for (int k = 0; k < 26; ++k) {
                    if (count[k] == 0) {
                        continue;
                    }
                    min = Math.min(min, count[k]);
                }
                ans += max - min;
            }
        }
        return ans;
    }
}