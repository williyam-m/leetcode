class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int high = days[days.length - 1];
        int[] dp = new int[high + 1];

        boolean[] travel = new boolean[high + 1];
        for (int day : days)
            travel[day] = true;
        

        for (int day = 1; day <= high; ++day) {
            if (!travel[day]) {
                dp[day] = dp[day - 1];
                continue;
            }
            dp[day] = dp[day - 1] + costs[0];
            
            dp[day] = Math.min(dp[day], dp[Math.max(0, day - 7)] + costs[1]);
            dp[day] = Math.min(dp[day], dp[Math.max(0, day - 30)] + costs[2]);
        }

        return dp[high];
    }
}