package newquestion.day11;

/**
 * @author Heng Yu
 * @date 5/8/20 6:32 PM
 */

/**
 * leetcode 1130: Minimum cost tree from leaf values
 */
public class MinimumCost {
    public static void main(String[] args) {
        MinimumCost solution = new MinimumCost();
        int[] arr = {5,2,6,4};
        int result = solution.mctFromLeafValues(arr);
        System.out.println(result);
    }

    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        int[][] indices = new int[len][len];

        for (int i = 0; i < len; ++i) {
            int max = 0;
            int index = -1;
            for (int j = i; j < len; ++j) {
                if (max < arr[j]) {
                    max = arr[j];
                    index = j;
                }
                indices[i][j] = index;
            }
        }

        return helper(arr, indices, 0, len - 1);
    }

    private int helper(int[] arr, int[][] indices, int l, int r) {
        //edge case
        if (l == r) return 0;

        int res = 0;
        int index = indices[l][r];
        if (index == l) {
            int first = arr[index];
            int second = arr[indices[index + 1][r]];
            res += first * second + helper(arr, indices, l, index) + helper(arr, indices, index + 1, r);
        } else {
            int first = arr[indices[l][index - 1]];
            int second = arr[index];
            res += first * second + helper(arr, indices, l, index - 1) + helper(arr, indices, index, r);
        }

        return res;
    }
}
