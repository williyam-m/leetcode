class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> row = new HashMap<>();
        Map<List<Integer>, Integer> col = new HashMap<>();

        for (int[] r : grid) {
            List<Integer> list = new ArrayList<>();
            for (int n : r)
                list.add(n);
            row.merge(list, 1, Integer::sum);
        }

        for (int j = 0; j < grid[0].length; ++j) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < grid.length; ++i) {
                list.add(grid[i][j]);
            }
            col.merge(list, 1, Integer::sum);
        }

        int ans = 0;
        for (List<Integer> r : row.keySet()) {
            if (col.containsKey(r)) {
                ans += row.get(r) * col.get(r);
            }
        }
        return ans;
    }
}