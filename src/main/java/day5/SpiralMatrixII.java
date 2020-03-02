package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 9:18 PM
 */

import java.util.Arrays;

/**
 * leetcode 59: Spiral Matrix II
 */

public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII solution = new SpiralMatrixII();
        int[][] result = solution.generateMatrix(3);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        dfs(1, res, 0, n - 1);
        return res;
    }

    private void dfs(int num, int[][] res, int start, int end) {
        //edge case
        if (end < start) return;
        if (start == end) {
            res[start][start] = num;
            return;
        }


        for (int i = start; i < end; ++i) {
            res[start][i] = num++;
        }
        for (int i = start; i < end; ++i) {
            res[i][end] = num++;
        }
        for (int i = end; i > start; --i) {
            res[end][i] = num++;
        }
        for (int i = end; i > start; --i) {
            res[i][start] = num++;
        }
        dfs(num, res, start + 1, end - 1);
    }
}
