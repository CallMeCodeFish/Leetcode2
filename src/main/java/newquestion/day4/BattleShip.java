package newquestion.day4;

/**
 * @author Heng Yu
 * @date 4/27/20 4:57 PM
 */

/**
 * leetcode 419: Battleship in a board
 */
public class BattleShip {
    public static void main(String[] args) {
        BattleShip solution = new BattleShip();
        char[][] board = {{'.', '.', '.', 'X'},{'X', 'X', 'X', 'X'},{'.', '.', '.', 'X'}};
        int result = solution.test(board);
        System.out.println(result);
    }

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        int res = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    if (helper(i, j, board, visited, 0)) {
                        ++res;
                    } else {
                        return 0;
                    }
                }
            }
        }

        return res;
    }

    private boolean helper(int i, int j, char[][] board, boolean[][] visited, int dir) {
        visited[i][j] = true;

        int m = board.length;
        int n = board[0].length;

        boolean left = j - 1 >= 0 && board[i][j - 1] == 'X' && !visited[i][j - 1];
        boolean right = j + 1 < n && board[i][j + 1] == 'X' && !visited[i][j + 1];
        boolean up = i - 1 >= 0 && board[i - 1][j] == 'X' && !visited[i - 1][j];
        boolean down = i + 1 < m && board[i + 1][j] == 'X' && !visited[i + 1][j];
        boolean h = false;
        boolean v = false;
        if (left || right) h = true;
        if (up || down) v = true;

        if (dir == 0) {
            if (h && v) {
                return false;
            } else if (h) { //1
                if (left) {
                    if (!helper(i, j - 1, board, visited, 1)) return false;
                }
                if (right) {
                    return helper(i, j + 1, board, visited, 1);
                }
                return true;
            } else if (v) { //2
                if (up) {
                    if (!helper(i - 1, j, board, visited, 2)) return false;
                }
                if (down) {
                    return helper(i + 1, j, board, visited, 2);
                }
                return true;
            } else {
                return true;
            }
        } else if (dir == 1) {
            if (v) return false;
            if (left) {
                if (!helper(i, j - 1, board, visited, 1)) return false;
            }
            if (right) {
                return helper(i, j + 1, board, visited, 1);
            }
            return true;
        } else {
            if (h) return false;
            if (up) {
                if (!helper(i - 1, j, board, visited, 2)) return false;
            }
            if (down) {
                return helper(i + 1, j, board, visited, 2);
            }
            return true;
        }
    }

    public int test(char[][] board) {
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                res++;
            }
        }

        return res;

    }
}
