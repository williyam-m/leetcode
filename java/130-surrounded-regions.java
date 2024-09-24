class Solution {
    private boolean flag = false;
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    isContainEdge(board, i, j, new char[m][n]);
                    if (!flag)
                        surround(board, i, j);
                    flag = false;
                }
            }
        }
    }

    private void isContainEdge(char[][] board, int i, int j, char[][] seen) {
        if (flag)
            return;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            flag = true;
            return;
        }

        if (board[i][j] == 'X' || seen[i][j] == 'X')
            return;

        seen[i][j] = 'X';
        isContainEdge(board, i - 1, j, seen);
        isContainEdge(board, i + 1, j, seen);
        isContainEdge(board, i, j + 1, seen);
        isContainEdge(board, i, j - 1, seen);
    }

    private void surround(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;
        if (board[i][j] == 'X')
            return;

        board[i][j] = 'X';
        surround(board, i - 1, j);
        surround(board, i + 1, j);
        surround(board, i, j + 1);
        surround(board, i, j - 1);
    }
}