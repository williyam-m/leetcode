class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if (n == 1) {
            return 0;
        }
        else if (n == 2 && s.charAt(0) > s.charAt(1)) {
            return -1;
        }
        char min = s.charAt(0);
        char max = s.charAt(0);
        char prev = s.charAt(0);
        boolean isSorted = true;
        int minCount = 0, maxCount = 0;
        for (char c : s.toCharArray()) {
            if (isSorted && c < prev) {
                isSorted = false;
            }
            if (min > c) {
                min = c;
                minCount = 0;
            }
            if (max < c) {
                max = c;
                maxCount = 0;
            }
            if (min == c) {
                ++minCount;
            }
            if (max == c) {
                ++maxCount;
            }
            prev = c;
        }
        if (isSorted) {
            return 0;
        }
        else if (min == s.charAt(0) || max == s.charAt(n - 1)) {
            return 1;
        }
        else if (max == s.charAt(0) && min == s.charAt(n - 1)) {
            if (maxCount > 1 || minCount > 1) {
                return 2;
            }
            return 3;
        }
        return 2;
    }
}