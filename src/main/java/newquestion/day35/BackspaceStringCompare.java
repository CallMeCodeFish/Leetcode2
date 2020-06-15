package newquestion.day35;

/**
 * @author Heng Yu
 * @date 6/13/20 5:30 PM
 */

/**
 * leetcode 844: Backspace string compare
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        char[] chs1 = S.toCharArray();
        char[] chs2 = T.toCharArray();

        StringBuilder stack1 = new StringBuilder();
        StringBuilder stack2 = new StringBuilder();

        for (int i = 0; i < chs1.length; i++) {
            char c = chs1[i];
            if (c == '#') {
                if (stack1.length() != 0) {
                    stack1.deleteCharAt(stack1.length() - 1);
                }
            } else {
                stack1.append(c);
            }
        }

        for (int i = 0; i < chs2.length; i++) {
            char c = chs2[i];
            if (c == '#') {
                if (stack2.length() != 0) {
                    stack2.deleteCharAt(stack2.length() - 1);
                }
            } else {
                stack2.append(c);
            }
        }

        return stack1.toString().equals(stack2.toString());
    }
}
