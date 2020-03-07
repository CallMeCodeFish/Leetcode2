package day10;

import java.util.List;

/**
 * @author Heng Yu
 * @date 3/6/20 3:33 PM
 */

/**
 * leetcode 120: Triangle
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; ++i) {
            for (int j = i; j >= 0; --j) {
                if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    dp[j] += triangle.get(i).get(j);
                } else {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j - 1], dp[j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int num : dp) {
            res = Math.min(res, num);
        }
        return res;
    }
}
