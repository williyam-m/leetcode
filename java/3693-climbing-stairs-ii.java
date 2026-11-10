class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = costs[0] + 1;
        if (n == 1) {
            return minCost[0];
        }
        minCost[1] = Math.min(minCost[0] + costs[1] + 1, costs[1] + 4);
        if (n == 2) {
            return minCost[1];
        }
        minCost[2] = Math.min(minCost[1] + costs[2] + 1, minCost[0] + costs[2] + 4);
        minCost[2] = Math.min(minCost[2], costs[2] + 9);
        for (int i = 3; i < n; ++i) {
            minCost[i] = Math.min(minCost[i - 1] + costs[i] + 1, minCost[i - 2] + costs[i] + 4);
            minCost[i] = Math.min(minCost[i], minCost[i - 3] + costs[i] + 9);
        }
        return minCost[n - 1];
    }
}