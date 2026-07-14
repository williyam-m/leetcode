class Solution {
    private int m;
    private int n;
    private int originalColor;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color == image[sr][sc]) {
            return image;
        }
        originalColor = image[sr][sc];
        m = image.length;
        n = image[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sr, sc});
        image[sr][sc] = color;
        
        while (!queue.isEmpty()) {
            for (int len = queue.size(); len > 0; --len) {
                int i = queue.peek()[0];
                int j = queue.pop()[1];
                checkAndUpdate(i, j, image, color, queue);
            }
        }
        return image;
    }
    private void checkAndUpdate(int i, int j, int[][] image, int color, Deque<int[]> queue) {
        for (int[] pos : direction) {
            int x = i + pos[0];
            int y = j + pos[1];
            if (x >= 0 && y >= 0 && x < m && y < n && image[x][y] == originalColor) {
                image[x][y] = color;
                queue.add(new int[] {x, y});
            }
        }
    }
}