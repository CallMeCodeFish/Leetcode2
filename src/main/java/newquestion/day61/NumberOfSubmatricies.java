package newquestion.day61;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 7/25/20 5:35 PM
 */

/**
 * leetcode 1074: Number of Submatrices that sum to target (hard)
 * solution: submatrices + prefix
 */
public class NumberOfSubmatricies {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        int res = 0;

        for (int w = 1; w <= n; w++) {
            for (int i = 0; i < n; i++) {
                int j = i + w - 1;
                if (j == n) break;
                Map<Integer, Integer> prefix = new HashMap<>();
                prefix.put(0, 1);
                int k = 0;
                int sum = 0;
                while (k < m) {
                    sum += i == 0 ? matrix[k][j] : matrix[k][j] - matrix[k][i - 1];
                    int num = sum - target;
                    if (prefix.containsKey(num)) {
                        res += prefix.get(num);
                    }
                    int count = prefix.getOrDefault(sum, 0);
                    prefix.put(sum, count + 1);
                    k++;
                }
            }
        }

        return res;
    }
}
