package day22;

/**
 * @author Heng Yu
 * @date 3/19/20 5:42 PM
 */

/**
 * leetcode 289: Game of Life
 */

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        //edge case
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                updateStatus(board, i, j);
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == Integer.MIN_VALUE) {
                    board[i][j] = 0;
                } else if (board[i][j] == Integer.MAX_VALUE) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private void updateStatus(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        if (i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == Integer.MIN_VALUE)) ++count;
        if (i + 1 < m && (board[i + 1][j] == 1 || board[i + 1][j] == Integer.MIN_VALUE)) ++count;
        if (j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == Integer.MIN_VALUE)) ++count;
        if (j + 1 < n && (board[i][j + 1] == 1 || board[i][j + 1] == Integer.MIN_VALUE)) ++count;
        if (i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == Integer.MIN_VALUE)) ++count;
        if (i + 1 < m && j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == Integer.MIN_VALUE)) ++count;
        if (i - 1 >= 0 && j + 1 < n && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == Integer.MIN_VALUE)) ++count;
        if (i + 1 < m && j + 1 < n && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == Integer.MIN_VALUE)) ++count;
        if (board[i][j] == 1) {
            if (count < 2 || count > 3) {
                board[i][j] = Integer.MIN_VALUE;
            }
        } else {
            if (count == 3) {
                board[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
