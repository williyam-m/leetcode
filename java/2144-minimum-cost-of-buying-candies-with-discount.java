class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int ans = 0;
        Arrays.sort(cost);
        int i = n - 1;
        for (; i >= 2; i -= 3) {
            ans += cost[i - 1] + cost[i];
        }
        if (i == 1) {
            ans += cost[i--];
        }
        if (i == 0) {
            ans += cost[i];
        }
        return ans;
    }
}