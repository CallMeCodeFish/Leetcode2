package newquestion.day47;

import java.util.TreeSet;

/**
 * @author Heng Yu
 * @date 7/3/20 9:16 PM
 */

/**
 * leetcode 363: Max sum of rectangle no larger than k
 * solution: prefix
 */
public class MaxSumOfRectangle {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int res = Integer.MIN_VALUE;

        if (m <= n) {
            for (int j = 0; j < n; j++) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = i; j < m; j++) {
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);
                    int sum = 0;
                    for (int x = 0; x < n; x++) {
                        sum += i == 0 ? matrix[j][x] : matrix[j][x] - matrix[i - 1][x];
                        int target = sum - k;
                        Integer ceiling = set.ceiling(target);
                        if (ceiling != null) {
                            int cur = sum - ceiling;
                            if (cur == k) return k;
                            res = Math.max(res, cur);
                        }
                        if (!set.contains(sum)) {
                            set.add(sum);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] += matrix[i][j - 1];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);
                    int sum = 0;
                    for (int x = 0; x < m; x++) {
                        sum += i == 0 ? matrix[x][j] : matrix[x][j] - matrix[x][i - 1];
                        int target = sum - k;
                        Integer ceiling = set.ceiling(target);
                        if (ceiling != null) {
                            int cur = sum - ceiling;
                            if (cur == k) return k;
                            res = Math.max(res, cur);
                        }
                        if (!set.contains(sum)) {
                            set.add(sum);
                        }
                    }
                }
            }
        }

        return res;
    }
}
