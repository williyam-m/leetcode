class Solution {
    public int numberOfSpecialChars(String word) {
        int[] count = new int[26];
        int[] ansArr = new int[26];
        int ans = 0;
        for (char c : word.toCharArray()) {
            if (ansArr[Character.toLowerCase(c) - 'a'] == -1) {
                continue; 
            }
            if (Character.isLowerCase(c)) {
                ++count[c - 'a'];
                if (ansArr[c - 'a'] > 0) {
                    ansArr[c - 'a'] = -1;
                }
            }
            else {
                if (count[c - 'A'] > 0) {
                    ++ansArr[c - 'A'];
                }
                else {
                    ansArr[c - 'A'] = -1;
                }
            }
        }
        for (int a : ansArr) {
            if (a > 0) {
                ++ans;
            }
        }
        return ans;
    }
}