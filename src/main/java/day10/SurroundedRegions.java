package day10;

/**
 * @author Heng Yu
 * @date 3/6/20 8:38 PM
 */

/**
 * leetcode 130: Surrounded Regions
 */

public class SurroundedRegions {
    public void solve(char[][] board) {
        //edge case
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < n; ++i) {
            if (board[0][i] == 'O' && !visited[0][i]) dfs(board, 0, i, visited);
            if (board[m - 1][i] == 'O' && !visited[m - 1][i]) dfs(board, m - 1, i, visited);
        }
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O' && !visited[i][0]) dfs(board, i, 0, visited);
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) dfs(board, i, n - 1, visited);
        }
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        visited[i][j] = true;
        if (0 <= i - 1 && board[i - 1][j] == 'O' && !visited[i - 1][j]) dfs(board, i - 1, j, visited);
        if (i + 1 < m && board[i + 1][j] == 'O' && !visited[i + 1][j]) dfs(board, i + 1, j, visited);
        if (0 <= j - 1 && board[i][j - 1] == 'O' && !visited[i][j - 1]) dfs(board, i, j - 1, visited);
        if (j + 1 < n && board[i][j + 1] == 'O' && !visited[i][j + 1]) dfs(board, i, j + 1, visited);
    }
}
