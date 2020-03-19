package day22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/19/20 6:57 PM
 */

/**
 * leetcode 293: Flip Game
 */

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        //edge case
        if (s == null || s.length() < 2) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length() - 1) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder sb = new StringBuilder();
                sb.append(s, 0, i);
                sb.append("--");
                sb.append(s.substring(i + 2));
                res.add(sb.toString());
            }
            ++i;
        }
        return res;
    }
}
