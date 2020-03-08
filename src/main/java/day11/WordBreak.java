package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 3:53 PM
 */

import java.util.*;

/**
 * leetcode 139: Word Break
 */

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //edge case
        if (wordDict.isEmpty()) return false;

        Set<String> dict = new HashSet<>(wordDict);
        if (dict.contains(s)) return true;
        boolean[] dp = new boolean[s.length()];
        for (int i = dp.length - 1; i >= 0; --i) {
            if (dict.contains(s.substring(i))) {
                dp[i] = true;
                continue;
            }
            for (int j = i + 1; j < s.length(); ++j) {
                if (dp[j] && dict.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
