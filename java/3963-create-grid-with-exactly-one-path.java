class Solution {
    public String[] createGrid(int m, int n) {
        String[] path = new String[m];
        for (int i = 0; i < m; ++i) {
            StringBuilder sd = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                sd.append((i == 0 || j == n - 1) ? '.' : '#');
            }
            path[i] = sd.toString();
        }
        return path;
    }
}