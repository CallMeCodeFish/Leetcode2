package newquestion.day10;

/**
 * @author Heng Yu
 * @date 5/7/20 4:02 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 1249: Minimum remove to make valid parentheses
 */
public class MinimumRemove {
    public static void main(String[] args) {
        MinimumRemove solution = new MinimumRemove();
        String s = "(a(b(c)d)";
        String result = solution.minRemoveToMakeValid(s);
        System.out.println(result);
    }

    public String minRemoveToMakeValid(String s) {
        char[] chs = s.toCharArray();
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < chs.length; ++i) {
            if (chs[i] == '(') {
                ++count;
            } else if (chs[i] == ')') {
                if (count == 0) {
                    chs[i] = '\0';
                    list.add(i);
                } else {
                    --count;
                }
            }
        }

        count = 0;

        for (int i = chs.length - 1; i >= 0; --i) {
            if (chs[i] == ')') {
                ++count;
            } else if (chs[i] == '(') {
                if (count == 0) {
                    chs[i] = '\0';
                    list.add(i);
                } else {
                    --count;
                }
            }
        }

        list.sort(Integer::compareTo);

        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (int j : list) {
            sb.append(chs, i, j - i);
            i = j + 1;
        }

        sb.append(chs, i, chs.length - i);

        return sb.toString();
    }
}
