package newquestion.day47;

/**
 * @author Heng Yu
 * @date 7/3/20 5:28 PM
 */

/**
 * leetcode 557: Reverse words in a string III
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s.isEmpty()) return s;

        StringBuilder sb = new StringBuilder();

        String[] split = s.split(" ");
        boolean isBlank = true;

        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            if (word.isEmpty()) {
                sb.append(' ');
            } else {
                isBlank = false;
                for (int j = word.length() - 1; j >= 0; j--) {
                    sb.append(word.charAt(j));
                }
                sb.append(' ');
            }
        }

        if (!isBlank) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
