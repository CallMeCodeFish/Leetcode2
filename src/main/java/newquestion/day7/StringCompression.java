package newquestion.day7;

/**
 * @author Heng Yu
 * @date 5/2/20 9:02 PM
 */

/**
 * leetcode 443: String compression
 */
public class StringCompression {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        while (j < chars.length) {
            chars[i++] = chars[j];
            int count = 0;
            while (j < chars.length && chars[i - 1] == chars[j]) {
                ++count;
                ++j;
            }
            if (count > 1) {
                String str = String.valueOf(count);
                for (char digit : str.toCharArray()) {
                    chars[i++] = digit;
                }
            }
        }

        return i;
    }
}
