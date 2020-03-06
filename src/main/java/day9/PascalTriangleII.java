package day9;

/**
 * @author Heng Yu
 * @date 3/6/20 12:19 AM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 119: Pascal's Triangle II
 */

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        //edge case
        if (rowIndex == 0) {
            res.add(1);
            return res;
        }

        int[] dp = new int[rowIndex + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = 1;
            for (int j = i - 1; j > 0; --j) {
                dp[j] += dp[j - 1];
            }
        }
        for (int num : dp) {
            res.add(num);
        }
        return res;
    }
}
