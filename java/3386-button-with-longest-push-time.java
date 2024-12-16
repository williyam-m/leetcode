class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int ans = Integer.MIN_VALUE;
        int index = 0;

        int[][] diff = new int[events.length][2];
        diff[0] = events[0];
        for (int i = 1; i < events.length; ++i) {
            diff[i][0] = events[i][0];
            diff[i][1] = events[i][1] - events[i - 1][1];
        }
        Arrays.sort(diff, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < diff.length; ++i) {
            if (diff[i][1] > ans) {
                ans = diff[i][1];
                index = diff[i][0];
            }
        }
        return index;
    }
}