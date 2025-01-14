class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<Integer>();
        int count = 0;
        int m = grid[0].length;

        for (int i = 0; i < grid.length; ++i) {
            if (i % 2 == 0)
                for (int j = 0; j < m; ++j) {
                    if (++count % 2 == 1)
                       ans.add(grid[i][j]);
            }
            else {
                for (int j = m - 1; j >= 0; --j)
                    if (++count % 2 == 1)
                       ans.add(grid[i][j]);
            }
        }

        return ans;
    }
}