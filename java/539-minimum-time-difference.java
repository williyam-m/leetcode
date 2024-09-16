class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] min = new int[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i)
            min[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60
                    + Integer.parseInt(timePoints.get(i).substring(3));

        Arrays.sort(min);
        for (int i = 0; i < n - 1; ++i)
            ans = Math.min(ans, min[i + 1] - min[i]);

        return Math.min(ans, 24 * 60 - min[n - 1] + min[0]);
    }
}