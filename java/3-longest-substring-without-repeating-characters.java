class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] count = new int[128];
        int l = 0;
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < s.length(); ++r) {
            int curr = s.charAt(r);
            ++count[curr];
            while (l < r && count[curr] == 2) {
                --count[s.charAt(l++)];
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}