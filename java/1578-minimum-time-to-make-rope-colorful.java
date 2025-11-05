class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int ans = 0;
        char prev;
        char curr;
        int maxTime = neededTime[0];
        int totalTime = neededTime[0];
        for (int i = 1; i < n; ++i) {
            prev = colors.charAt(i - 1);
            curr = colors.charAt(i);
            if (prev != curr) {
                ans += Math.max(maxTime, neededTime[i - 1]);
                System.out.println(ans);
                maxTime = Integer.MIN_VALUE;
            }
            else {
                maxTime = Math.max(maxTime, neededTime[i - 1]);
            }
            totalTime += neededTime[i];
        }
        ans += Math.max(maxTime, neededTime[n - 1]);
        return totalTime - ans;
    }
}