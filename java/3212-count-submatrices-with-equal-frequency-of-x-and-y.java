class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int[] xCount = new int[grid[0].length];
        int[] yCount = new int[grid[0].length];
        int ans = 0;

        for (int i = 0; i < grid.length; ++i) {
            int xRow = 0;
            int yRow = 0;
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 'X') ++xCount[j];
                if (grid[i][j] == 'Y') ++yCount[j];
                xRow += xCount[j];
                yRow += yCount[j];
                if (xRow != 0 && xRow == yRow) ++ans;
            }
        }
        return ans;
    }
}