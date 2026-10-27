class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        for (int i = 0; i < m; ++i) {
            StringBuilder sb = new StringBuilder(".");
            for (int j = 0; j < n - 1; ++j) {
                sb.append(i == m - 1 ? "." : '#');
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}