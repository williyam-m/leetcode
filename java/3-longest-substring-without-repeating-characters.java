class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        int maxLenght = 0;
        int left = 0; 
        for (int right = 0; right < s.length(); ++right) {
            ++count[s.charAt(right)];
            while (count[s.charAt(right)] > 1) {
                --count[s.charAt(left++)];
            }
            maxLenght = Math.max(maxLenght, right - left + 1);
        }
        return maxLenght;
    }
}