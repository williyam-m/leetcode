class Solution {
    public int minCost(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        int[][] mem = new int[m][n];
        Arrays.stream(mem).forEach(A -> Arrays.fill(A, -1));

        dfs(grid, 0, 0, 0, mem, q);

        for (int cost = 1; !q.isEmpty(); ++cost) {
            for (int size = q.size(); size > 0; --size) {
                int i = q.peek().getKey();
                int j = q.poll().getValue();
                for (int[] dir : dirs) {
                    dfs(grid, i + dir[0], j + dir[1], cost, mem, q);
                }
            }
        }
        return mem[m - 1][n - 1];
    }
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int[][] grid, int i, int j, int cost, int[][] mem, Queue<Pair<Integer, Integer>> q) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
           return ;
        if (mem[i][j] != -1)
           return ;
        
        mem[i][j] = cost;
        q.add(new Pair<>(i, j));
        int[] dir = dirs[grid[i][j] - 1];
        dfs(grid, i + dir[0], j + dir[1], cost, mem, q);
    }
}