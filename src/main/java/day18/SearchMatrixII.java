package day18;

/**
 * @author Heng Yu
 * @date 3/15/20 6:28 PM
 */

/**
 * leetcode 240: Search a 2D Matrix II
 */

public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        //edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int n = matrix[0].length;
        for (int[] row : matrix) {
            if (target < row[0]) {
                break;
            } else if (target <= row[n - 1]) {
                boolean canFind = search(row, target);
                if (canFind) return true;
            }
        }
        return false;
    }

    private boolean search(int[] row, int target) {
        int l = 0;
        int r = row.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target <= row[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return target == row[l];
    }
}
