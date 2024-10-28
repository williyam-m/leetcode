class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int n : nums) {
            int sqrt_n = (int) Math.sqrt(n);
            if (isPerfectSquare(sqrt_n, n) && map.containsKey(sqrt_n)) {
                map.put(n, map.get(sqrt_n) + 1);
                ans = Math.max(ans, map.get(n));
            }
            else
               map.put(n, 1);
        }
        return ans;
    }
    private boolean isPerfectSquare (int sqrt_n, int n) {
        return sqrt_n * sqrt_n == n;
    }
}