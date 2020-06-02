package newquestion.day26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 6/1/20 7:42 PM
 */

/**
 * leetcode 37: Sudoku solver (hard)
 */
public class SudokuSolver {
    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solveSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Set<Character>[] rows = new Set[m];
        for (int i = 0; i < m; i++) {
            rows[i] = new HashSet<>();
        }

        Set<Character>[] cols = new Set[n];
        for (int j = 0; j < n; j++) {
            cols[j] = new HashSet<>();
        }

        int p = m / 3;
        int q = n / 3;

        Set<Character>[][] subBoxes = new Set[m][q];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                subBoxes[i][j] = new HashSet<>();
            }
        }

        List<Pair> positions = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char num = board[i][j];
                if (num == '.') {
                    positions.add(new Pair(i, j));
                } else {
                    rows[i].add(num);
                    cols[j].add(num);
                    subBoxes[i / 3][j / 3].add(num);
                }
            }
        }

        backtracking(board, positions, 0, rows, cols, subBoxes);
    }

    private boolean backtracking(char[][] board, List<Pair> positions, int index, Set<Character>[] rows, Set<Character>[] cols, Set<Character>[][] subBoxes) {
        if (index == positions.size()) return true;

        Pair position = positions.get(index);
        int i = position.x;
        int j = position.y;
        int p = i / 3;
        int q = j / 3;

        for (int offset = 1; offset <= 9; offset++) {
            char num = (char) ('0' + offset);
            if (!rows[i].contains(num) && !cols[j].contains(num) && !subBoxes[p][q].contains(num)) {
                board[i][j] = num;
                rows[i].add(num);
                cols[j].add(num);
                subBoxes[p][q].add(num);

                if (backtracking(board, positions, index + 1, rows, cols, subBoxes)) return true;

                subBoxes[p][q].remove(num);
                cols[j].remove(num);
                rows[i].remove(num);
                board[i][j] = '.';
            }
        }

        return false;
    }
}
