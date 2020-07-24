package newquestion.day60;

/**
 * @author Heng Yu
 * @date 7/23/20 6:02 PM
 */

/**
 * leetcode 1047: Remove all adjacent duplicates in string
 */
public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chs = S.toCharArray();

        for (char c : chs) {
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
