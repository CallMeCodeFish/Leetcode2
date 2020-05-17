package contest.may16;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 5/16/20 10:34 PM
 */


public class RearrangeWords {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(words[0].charAt(0)));
        sb.append(words[0].substring(1));

        for (int i = 1; i < words.length; ++i) {
            sb.append(' ');
            sb.append(words[i]);
        }

        return sb.toString();
    }
}
