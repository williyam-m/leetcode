class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new int[] {0, 0, 0});
        boolean[][] seen = new boolean[m][n];
        
        seen[0][0] = true;

        while (!minHeap.isEmpty()) {
            int time = minHeap.peek()[0];
            int i = minHeap.peek()[1];
            int j = minHeap.poll()[2];
            if (i == m - 1 && j == n - 1)
               return time;
            
            for (int[] dir : dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x < 0 || y < 0 || x == m || y == n)
                   continue;
                if (seen[x][y])
                   continue;
                int extraTime = (grid[x][y] - time) % 2 == 0 ? 1 : 0;
                int nextTime = Math.max(time + 1, grid[x][y] + extraTime);
                minHeap.offer(new int[] {nextTime, x, y});
                seen[x][y] = true;
            }
        }
        return -1;
    }
}