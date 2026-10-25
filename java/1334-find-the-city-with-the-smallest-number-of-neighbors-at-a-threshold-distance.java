class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = floydWarShall(n, edges, distanceThreshold);
        int minNeighbours = n;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int currNeighbours = 0;
            for (int j = 0; j < n; ++j) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    ++currNeighbours;
                }
            }

            if (currNeighbours <= minNeighbours) {
                minNeighbours = currNeighbours;
                ans = i;
            }
        }
        return ans;
    }
    private int[][] floydWarShall(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dist[i][j] = (i == j) ? 0 : distanceThreshold + 1;
            }
        }

        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }
}