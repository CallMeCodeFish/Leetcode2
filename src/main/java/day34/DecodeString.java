package day34;

/**
 * @author Heng Yu
 * @date 4/21/20 10:17 PM
 */

/**
 * leetcode 394: Decode String
 */
public class DecodeString {
    public String decodeString(String s) {
        //edge case
        if (s.isEmpty()) return "";

        char[] chs = s.toCharArray();
        return helper(chs, 0, chs.length);
    }

    private String helper(char[] chs, int start, int end) {
        StringBuilder sb = new StringBuilder();
        int i = start;
        while (i < end) {
            char c = chs[i];
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < end && chs[i] != '[') {
                    num *= 10;
                    num += chs[i] - '0';
                    ++i;
                }
                int count = 0;
                int j = i;
                while (j < end) {
                    if (chs[j] == '[') {
                        ++count;
                    } else if (chs[j] == ']') {
                        --count;
                    }
                    if (count == 0) break;
                    ++j;
                }
                String substring = helper(chs, i + 1, j);
                while (num > 0) {
                    sb.append(substring);
                    --num;
                }
                i = j + 1;
            } else {
                sb.append(c);
                ++i;
            }
        }
        return sb.toString();
    }
}
