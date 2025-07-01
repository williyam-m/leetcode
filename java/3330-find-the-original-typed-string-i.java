class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        int ans = 0;
        for (int i = 1; i < word.length(); ++i) {
            if (word.charAt(i) != word.charAt(i - 1)) {
                if (count > 1) {
                    ans += count - 1;
                }
                count = 1;
            }
            else {
                ++count;
            }
        }
        if (count > 1) {
            ans += count - 1;
        }
        return ans + 1;
    }
}