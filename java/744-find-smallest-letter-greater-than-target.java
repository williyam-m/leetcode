class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0;
        int right = n;
        char answer = letters[0];
        while (left < right) {
            final int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                answer = letters[mid];
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return answer;
    }
}