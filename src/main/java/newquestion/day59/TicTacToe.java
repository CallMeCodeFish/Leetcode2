package newquestion.day59;

/**
 * @author Heng Yu
 * @date 7/22/20 6:28 PM
 */

/**
 * leetcode 1275: Find a winner on a tic tac toe game
 */
public class TicTacToe {
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            grid[x][y] = i % 2 == 0 ? 1 : 2;
        }

        boolean isDraw = true;

        //rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == 0) {
                isDraw = false;
            } else {
                if (grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
                    return grid[i][0] == 1? "A" : "B";
                } else {
                    if (grid[i][1] == 0 || grid[i][2] == 0) {
                        isDraw = false;
                    }
                }
            }
        }

        //columns
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] != 0 && grid[0][j] == grid[1][j] && grid[0][j] == grid[2][j]) {
                return grid[0][j] == 1 ? "A" : "B";
            }
        }

        //diagonals
        if (grid[0][0] != 0 && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) {
            return grid[0][0] == 1 ? "A" : "B";
        }

        if (grid[0][2] != 0 && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]) {
            return grid[0][2] == 1 ? "A" : "B";
        }

        return isDraw ? "Draw" : "Pending";
    }
}
