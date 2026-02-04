class Solution {
    public int smallestAbsent(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int maxValue = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            sum += n;
            set.add(n);
            maxValue = Math.max(maxValue, n);
        }
        if (maxValue <= 0) {
            return 1;
        }
        int average = Math.max(0, sum / len);
        while (++average <= maxValue) {
            if (!set.contains(average)) {
                return average;
            }
        }
        return maxValue + 1;
    }
}