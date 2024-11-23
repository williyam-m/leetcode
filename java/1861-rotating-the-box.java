class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];

        for (int i = 0; i < m; ++i) {
            int stone = 0;
            for (int j = 0; j < n; ++j) {
                if (box[i][j] == '*') {
                    ans[j][m - i - 1] = '*';
                    if (stone > 0) {
                        fill(ans, m - i - 1, j - stone, j);
                        stone = 0;
                    }
                }
                else if (box[i][j] == '#') {
                    ++stone;
                }
            }
            if (stone > 0) {
                fill(ans, m - i - 1, n - stone, n);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (ans[i][j] != '#' && ans[i][j] != '*')
                   ans[i][j] = '.';
            }
        }

        return ans;
    }
    private void fill(char[][] ans, int i, int start, int end) {
        for (int k = start; k <
         end; ++k) {
            ans[k][i] = '#';
        }
    }
}