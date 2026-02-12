class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int len = 1;
        int[] count = new int[26];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(count, 0);
            for (int j = i; j < n; ++j) {
                if (areAllOccurrencesEqual(count, ++count[s.charAt(j) - 'a'])) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
    private boolean areAllOccurrencesEqual(int[] arr, int n) {
        for (int value : arr) {
            if (value > 0 && value != n) {
                return false;
            }
        }
        return true;
    }
}