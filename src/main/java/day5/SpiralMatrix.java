package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 5:55 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 54: Spiral Matrix
 */

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        //edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        dfs(matrix, 0, m, 0, n, res);
        return res;
    }

    private void dfs(int[][] matrix, int rStart, int rEnd, int cStart, int cEnd, List<Integer> res) {
        //edge case
        if (rStart == rEnd || cStart == cEnd) return;

        if (rStart == rEnd - 1) {
            for (int i = cStart; i < cEnd; ++i) {
                res.add(matrix[rStart][i]);
            }
            return;
        }

        if (cStart == cEnd - 1) {
            for (int i = rStart; i < rEnd; ++i) {
                res.add(matrix[i][cStart]);
            }
            return;
        }

        for (int i = cStart; i < cEnd - 1; ++i) {
            res.add(matrix[rStart][i]);
        }
        for (int i = rStart; i < rEnd - 1; ++i) {
            res.add(matrix[i][cEnd - 1]);
        }
        for (int i = cEnd - 1; i > cStart; --i) {
            res.add(matrix[rEnd - 1][i]);
        }
        for (int i = rEnd - 1; i > rStart; --i) {
            res.add(matrix[i][cStart]);
        }
        dfs(matrix, rStart + 1, rEnd - 1, cStart + 1, cEnd - 1, res);
    }
}
