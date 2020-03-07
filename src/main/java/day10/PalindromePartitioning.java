package day10;

/**
 * @author Heng Yu
 * @date 3/6/20 11:08 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 131: Palindrome Partitioning
 */

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        //edge case
        if (s == null) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        if (s.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add("");
            res.add(list);
            return res;
        }
        backtrack(s, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int i, List<List<String>> res, List<String> cur) {
        //edge case
        if (i == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        int j = i + 1;
        while (j <= s.length()) {
            String sub = s.substring(i, j);
            if (isPalindrome(sub)) {
                cur.add(sub);
                backtrack(s, j, res, cur);
                cur.remove(cur.size() - 1);
            }
            ++j;
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
