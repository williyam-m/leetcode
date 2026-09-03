class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int oddCount = 0;
        int minOddValue = Integer.MAX_VALUE;
        int minEvenValue = Integer.MAX_VALUE;
        for (int num : nums1) {
            if (num % 2 == 1) {
                ++oddCount;
                minOddValue = Math.min(minOddValue, num);
            }
            else {
                minEvenValue = Math.min(minEvenValue, num);
            }
        }
        return oddCount == n || oddCount == 0 || minOddValue < minEvenValue;
    }
}