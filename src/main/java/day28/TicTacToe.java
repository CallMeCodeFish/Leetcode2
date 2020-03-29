package day28;

/**
 * @author Heng Yu
 * @date 3/28/20 8:16 PM
 */

/**
 * leetcode 348: Design Tic-Tac-Toe
 */

public class TicTacToe {
    /**
     * Initialize your data structure here.
     */
    private class Info {
        int player;
        boolean canWin;
        int count;

        public Info(int player) {
            this.player = player;
            this.canWin = true;
            this.count = 0;
        }
    }

    private Info[] rows;
    private Info[] cols;
    private Info[] diags;
    private int winner;
    private int size;

    public TicTacToe(int n) {
        this.size = n;
        this.rows = new Info[n];
        this.cols = new Info[n];
        this.diags = new Info[2];
        this.winner = 0;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        //if there is already a winner, players cannot move any more
        if (winner != 0) return winner;

        if (rows[row] == null) {
            rows[row] = new Info(player);
        }
        Info rowInfo = rows[row];
        if (rowInfo.canWin) {
            if (rowInfo.player == player) {
                ++rowInfo.count;
                if (rowInfo.count == size) {
                    winner = player;
                    return winner;
                }
            } else {
                rowInfo.canWin = false;
            }
        }

        if (cols[col] == null) {
            cols[col] = new Info(player);
        }
        Info colInfo = cols[col];
        if (colInfo.canWin) {
            if (colInfo.player == player) {
                ++colInfo.count;
                if (colInfo.count == size) {
                    winner = player;
                    return winner;
                }
            } else {
                colInfo.canWin = false;
            }
        }

        if (row == col) {
            if (diags[0] == null) {
                diags[0] = new Info(player);
            }
            Info firstDiagInfo = diags[0];
            if (firstDiagInfo.canWin) {
                if (firstDiagInfo.player == player) {
                    ++firstDiagInfo.count;
                    if (firstDiagInfo.count == size) {
                        winner = player;
                        return winner;
                    }
                } else {
                    firstDiagInfo.canWin = false;
                }
            }
        }

        if (row + col == size - 1) {
            if (diags[1] == null) {
                diags[1] = new Info(player);
            }
            Info secondDiagInfo = diags[1];
            if (secondDiagInfo.canWin) {
                if (secondDiagInfo.player == player) {
                    ++secondDiagInfo.count;
                    if (secondDiagInfo.count == size) {
                        winner = player;
                        return winner;
                    }
                } else {
                    secondDiagInfo.canWin = false;
                }
            }
        }
        return 0;
    }
}
