package newquestion.day37;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Heng Yu
 * @date 6/17/20 3:56 PM
 */

/**
 * leetcode 1209: Remove all adjacent duplicates in string II
 */
public class RemoveAdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        if (s.length() < k) return s;

        char[] chs = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();

        int i = 0;
        while (i < chs.length) {
            char c = chs[i];
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                stack.push(1);
            } else {
                int top = stack.peek();
                if (top == k - 1) {
                    while (top > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                        stack.pop();
                        top--;
                    }
                } else {
                    sb.append(c);
                    stack.push(top + 1);
                }
            }
            i++;
        }

        return sb.toString();
    }
}
