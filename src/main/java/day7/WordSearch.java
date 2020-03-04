package day7;

/**
 * @author Heng Yu
 * @date 3/3/20 4:01 PM
 */

/**
 * leetcode 79: Word Search
 */

public class WordSearch {
    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = new char[][]{{'a'}};
        boolean result = solution.exist(board, "a");
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        //edge case
        if (board == null || board.length == 0 || board[0].length == 0) return false;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (backtrack(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
        char ch = word.charAt(idx);
        //edge case
        if (idx == word.length() - 1) {
            return ch == board[i][j];
        }

        if (ch == board[i][j]) {
            visited[i][j] = true;
            if (0 <= i - 1 && !visited[i - 1][j]) {
                boolean top = backtrack(board, i - 1, j, word, idx + 1, visited);
                if (top) return true;
            }
            if (i + 1 < board.length && !visited[i + 1][j]) {
                boolean bottom = backtrack(board, i + 1, j, word, idx + 1, visited);
                if (bottom) return true;
            }
            if (0 <= j - 1 && !visited[i][j - 1]) {
                boolean left = backtrack(board, i, j - 1, word, idx + 1, visited);
                if (left) return true;
            }
            if (j + 1 < board[0].length && !visited[i][j + 1]) {
                boolean right = backtrack(board, i, j + 1, word, idx + 1, visited);
                if (right) return true;
            }
            visited[i][j] = false;
        }
        return false;
    }
}
