class Solution {
    public int minimumObstacles(int[][] grid) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new int[] {grid[0][0], 0, 0});
        int[][] dist = new int[m][n];
        Arrays.stream(dist).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE));
        dist[0][0] = grid[0][0];

        while (!minHeap.isEmpty()) {
            int d = minHeap.peek()[0];
            int i = minHeap.peek()[1];
            int j = minHeap.poll()[2];
            if (i == m - 1 && j == n - 1)
               return d;
            
            for (int[] dir : dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x < 0 || y < 0 || x == m || y == n)
                   continue;
                int distance = d + grid[i][j];
                if (distance < dist[x][y]) {
                    dist[x][y] = distance;
                    minHeap.offer(new int[] {distance, x, y});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}