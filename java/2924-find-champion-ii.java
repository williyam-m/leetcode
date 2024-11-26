class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] degree = new int[n];
        for (int[] edge : edges) {
            ++degree[edge[1]];
        }

        int count = 0;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 0) {
                ans = i;
                ++count;
            }
        }
        return count > 1 ? -1 : ans;
    }
}