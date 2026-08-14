class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int max = 0;
        int l = 0;
        for (int r = 0; r < s.length(); ++r) {
            ++count[s.charAt(r) - 'a'];
            while (count[s.charAt(r) - 'a'] > 2) {
                --count[s.charAt(l++) - 'a'];
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}