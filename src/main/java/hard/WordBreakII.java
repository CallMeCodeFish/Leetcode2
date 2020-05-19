package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 5/18/20 5:23 PM
 */

/**
 * leetcode 140: Word break II
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();

        Set<String> set = new HashSet<>(wordDict);

        List<String>[] memo = new List[len];

        return helper(s, 0, memo, set);
    }

    private List<String> helper(String s, int start, List<String>[] memo, Set<String> set) {
        if (memo[start] != null) return memo[start];

        List<String> res = new ArrayList<>();
        for (int end = start + 1; end <= s.length(); ++end) {
            String left = s.substring(start, end);
            if (set.contains(left)) {
                if (end == s.length()) {
                    res.add(left);
                } else {
                    List<String> rightList = helper(s, end, memo, set);
                    for (String right : rightList) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(left);
                        sb.append(' ');
                        sb.append(right);
                        res.add(sb.toString());
                    }
                }
            }
        }

        memo[start] = res;
        return res;
    }
}
