class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int b : banned) {
            set.add(b);
        }
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            if (!set.contains(i)) {
                if (sum + i > maxSum) {
                    return count;
                }
                sum += i;
                ++count;
            }
        }
        return count;
    }
}