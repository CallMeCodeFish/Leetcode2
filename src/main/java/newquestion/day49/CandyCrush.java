package newquestion.day49;

/**
 * @author Heng Yu
 * @date 7/6/20 7:43 PM
 */

/**
 * leetcode 723: Candy crush
 * ref: https://leetcode.com/problems/candy-crush/discuss/178366/Another-Java-Solution
 */
public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean canStop = true;

        //crush horizontally
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                int target = Math.abs(board[i][j]);
                if (target > 0 && target == Math.abs(board[i][j + 1]) && target == Math.abs(board[i][j + 2])) {
                    canStop = false;
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -target;
                }
            }
        }

        //crush vertically
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m - 2; i++) {
                int target = Math.abs(board[i][j]);
                if (target > 0 && target == Math.abs(board[i + 1][j]) && target == Math.abs(board[i + 2][j])) {
                    canStop = false;
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -target;
                }
            }
        }

        if (canStop) return board;

        //drop vertically
        for (int j = 0; j < n; j++) {
            int w = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[w--][j] = board[i][j];
                }
            }

            for (int i = w; i >= 0; i--) {
                board[i][j] = 0;
            }
        }

        return candyCrush(board);
    }
}
