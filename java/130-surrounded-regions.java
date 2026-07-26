class Solution {
    private int n;
    private int m;
    private boolean[][] notSurrounded;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        notSurrounded = new boolean[n][m];
        for (int j = 0; j < m; ++j) {
            if (board[0][j] == 'O') {
                markAsNotSurrounded(0, j, board);
            }
            if (board[n - 1][j] == 'O') {
                markAsNotSurrounded(n - 1, j, board);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (board[i][0] == 'O') {
                markAsNotSurrounded(i, 0, board);
            }
            if (board[i][m - 1] == 'O') {
                markAsNotSurrounded(i, m - 1, board);
            }
        }
        for (int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < m - 1; ++j) {
                if (board[i][j] == 'O' && !notSurrounded[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void markAsNotSurrounded(int i, int j, char[][] board) {
        if (i < 0 || i > n - 1 || j < 0 || j > m - 1 || board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == 'X' || notSurrounded[i][j]) {
            return;
        }
        notSurrounded[i][j] = true;
        markAsNotSurrounded(i + 1, j, board);
        markAsNotSurrounded(i - 1, j, board);
        markAsNotSurrounded(i, j + 1, board);
        markAsNotSurrounded(i, j - 1, board);
    }
}