class T {
    int i;
    int j;
    int h;
    T (int i, int j, int h) {
        this.i = i;
        this.j = j;
        this.h = h;
    }
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        PriorityQueue<T> pq = new PriorityQueue<>((a, b) -> (a.h - b.h));
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Arrays.stream(ans).forEach(A -> Arrays.fill(A, -1));

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    pq.add(new T(i, j, 0));
                }
            }
        }

        while (!pq.isEmpty()) {
            int i = pq.peek().i;
            int j = pq.peek().j;
            int h = pq.poll().h + 1;
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n)
                    continue;
                if (ans[x][y] != -1)
                    continue;
                
                ans[x][y] = h;
                pq.add(new T(x, y, h));
            }
        }
        return ans;
    }
}