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
    public int trapRainWater(int[][] heightMap) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int n = heightMap[0].length;
        int m = heightMap.length;
        int ans = 0;
        Queue<T> pq = new PriorityQueue<>((a, b) -> a.h - b.h);
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            pq.add(new T(i, 0, heightMap[i][0]));
            pq.add(new T(i, n - 1, heightMap[i][n - 1]));
            seen[i][0] = true;
            seen[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; ++j) {
            pq.add(new T(0, j, heightMap[0][j]));
            pq.add(new T(m - 1, j, heightMap[m - 1][j]));
            seen[0][j] = true;
            seen[m - 1][j] = true;
        }

        while (!pq.isEmpty()) {
            int i = pq.peek().i;
            int j = pq.peek().j;
            int h = pq.poll().h;
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n)
                   continue;
                if (seen[x][y])
                   continue;
                
                seen[x][y] = true;

                if (heightMap[x][y] < h) {
                    ans += h - heightMap[x][y];
                    pq.add(new T(x, y, h));
                }
                else {
                    pq.add(new T(x, y, heightMap[x][y]));
                }
            }
        }

        return ans;
    }
}