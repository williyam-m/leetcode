class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int total = 0;
        int left = 0;
        int len = s.length();
        for (int right = 0; right < len; ++right) {
            ++count[s.charAt(right) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                total += len - right;
                --count[s.charAt(left++) - 'a'];
            }
        }
        return total;
    }
}