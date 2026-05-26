class Solution {
    public int numberOfSpecialChars(String word) {
        int[] count = new int[53];
        int ans = 0;
        for (char c : word.toCharArray()) {
            if (count[Character.toLowerCase(c) - 'a'] == -1 || count[Character.toLowerCase(c) - 'a' + 26] == -1) {
                continue;
            }
            if (Character.isLowerCase(c)) {
                if (count[c - 'a' + 26] > 0) {
                    ++ans;
                    count[c - 'a' + 26] = -1;
                }
                ++count[c - 'a'];
            }
            else {
                if (count[c - 'A'] > 0) {
                    ++ans;
                    count[c - 'A'] = -1;
                }
                ++count[c - 'A' + 26];
            }
        }
        return ans;
    }
}