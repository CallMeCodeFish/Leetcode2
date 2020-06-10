package newquestion.day32;

/**
 * @author Heng Yu
 * @date 6/9/20 8:01 PM
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 946: Validate stack sequences
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int len = pushed.length;

        int i = 0, j = 0;

        while (true) {
            if (stack.isEmpty() && i == len && j == len) break;

            if (stack.isEmpty() || stack.peek() != popped[j]) {
                if (i == len) return false;
                stack.push(pushed[i++]);
            } else {
                stack.pop();
                j++;
            }
        }

        return true;
    }
}
