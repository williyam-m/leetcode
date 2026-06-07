class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        long totalInterval = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; ++i) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            
            if (currStart <= end) {
                end = Math.max(end, currEnd);
            }
            else {
                totalInterval += (end - start + 1);
                start = currStart;
                end = currEnd;
            }
        }
        totalInterval += (end - start + 1);

        return ((brightness + 2) / 3) * totalInterval;
    }
}