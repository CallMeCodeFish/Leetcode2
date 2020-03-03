package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 5:32 PM
 */

/**
 * leetcode 74: Search a 2D Matrix
 */

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int n = matrix[0].length;
        for (int[] row : matrix) {
            if (target < row[0]) {
                return false;
            } else if (target <= row[n - 1]) {
                int l = 0;
                int r = n;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (target < row[mid]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                --l;
                return 0 <= l && target == row[l];
            }
        }
        return false;
    }
}
