class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int ans = 0;
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                ++zeros;
            else if (c == '1' && zeros > 0)
                ans = Math.max(ans + 1, zeros);
        }
        return ans;
    }
}