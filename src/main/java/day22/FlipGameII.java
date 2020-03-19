package day22;

/**
 * @author Heng Yu
 * @date 3/19/20 7:08 PM
 */

import java.util.HashMap;

/**
 * leetcode 294: Flip Game II
 */

public class FlipGameII {
    public static void main(String[] args) {
        FlipGameII solution = new FlipGameII();
        boolean result = solution.canWin("++++");
        System.out.println(result);
    }

    public boolean canWin(String s) {
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(s.toCharArray(), map);
    }

    private boolean helper(char[] s, HashMap<String, Boolean> map) {
        String cur = String.valueOf(s);
        if (map.containsKey(cur)) return map.get(cur);

        boolean res = false;
        for (int i = 0; i < s.length - 1; ++i) {
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = s[i + 1] = '-';
                if (!helper(s, map)) {
                    res = true;
                    s[i] = s[i + 1] = '+';
                    break;
                }
                s[i] = s[i + 1] = '+';
            }
        }
        map.put(cur, res);
        return res;
    }
}
