package newquestion.day30;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 6/5/20 4:14 PM
 */

/**
 * leetcode 51: N-Queues
 */
public class NQueues {
    public List<List<String>> solveNQueens(int n) {
        //edge case
        if (n < 1) return new ArrayList<>();

        int numDiag = 2 * n - 1;

        boolean[] col = new boolean[n];
        boolean[] firstDiag = new boolean[numDiag];
        boolean[] secondDiag = new boolean[numDiag];
        String[] mapping = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            mapping[i] = sb.toString();
        }

        List<List<String>> res = new ArrayList<>();

        backtracking(0, n, col, firstDiag, secondDiag, res, new ArrayList<>(), mapping);

        return res;
    }

    private void backtracking(int i, int n, boolean[] col, boolean[] firstDiag, boolean[] secondDiag, List<List<String>> res, List<Integer> list, String[] mapping) {
        //edge case
        if (i == n) {
            List<String> cur = new ArrayList<>();
            for (int num : list) {
                cur.add(mapping[num]);
            }
            res.add(cur);
            return;
        }

        for (int j = 0; j < n; j++) {
            int firstIndex = j - i + n - 1;
            int secondIndex = i + j;
            if (!col[j] && !firstDiag[firstIndex] && !secondDiag[secondIndex]) {
                col[j] = firstDiag[firstIndex] = secondDiag[secondIndex] = true;
                list.add(j);
                backtracking(i + 1, n, col, firstDiag, secondDiag, res, list, mapping);
                list.remove(list.size() - 1);
                col[j] = firstDiag[firstIndex] = secondDiag[secondIndex] = false;
            }
        }
    }
}
