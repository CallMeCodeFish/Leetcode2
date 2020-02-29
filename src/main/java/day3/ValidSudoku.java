package day3;

/**
 * @author Heng Yu
 * @date 2/29/20 12:27 AM
 */

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 36: Valid Sudoku
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[][] subs = new Set[3][3];
        for (int i = 0; i < 9; ++i) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                subs[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char ch = board[i][j];
                if (Character.isDigit(ch)) {
                    if (rows[i].contains(ch))   return false;
                    rows[i].add(ch);
                    if (cols[j].contains(ch))   return false;
                    cols[j].add(ch);
                    if (subs[i / 3][j / 3].contains(ch))    return false;
                    subs[i / 3][j / 3].add(ch);
                }
            }
        }
        return true;
    }
}
