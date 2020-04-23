package day35;

/**
 * @author Heng Yu
 * @date 4/22/20 9:55 PM
 */

/**
 * leetcode 388: Longest Absolute File Path
 */
public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        LongestAbsoluteFilePath solution = new LongestAbsoluteFilePath();
        int result = solution.lengthLongestPath("dir\n\t        file.txt\n\tfile2.txt");
        System.out.println(result);
    }

    public int lengthLongestPath(String input) {
        char sep = ' ';
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '\t') {
                sep = '\t';
                break;
            } else if (input.charAt(i) == ' ') {
                break;
            }
        }
        String[] rows = input.split("\\n");
        int[] cur = {0};
        int level = 0;
        return helper(rows, cur, sep, level);
    }

    private int helper(String[] rows, int[] cur, char sep, int level) {
        int max = 0;
        int len = 0;
        while (cur[0] < rows.length) {
            String row = rows[cur[0]];
            int targetCount = level;
            if (sep == ' ') {
                targetCount = 4 * level;
            }
            int sepCount = 0;
            int i = 0;
            while (i < row.length()) {
                if (row.charAt(i) != sep) {
                    break;
                }
                ++sepCount;
                ++i;
            }
            if (sepCount == targetCount) {
                if (row.split("\\.").length > 1) {
                    int length = (level == 0) ? row.length() - targetCount : row.length() + 1 - targetCount;
                    max = Math.max(max, length);
                } else {
                    len = (level == 0) ? row.length() - targetCount : row.length() + 1 - targetCount;
                }
                ++cur[0];
            } else if (sepCount > targetCount) {
                int length = 0;
                if (sep == ' ' && sepCount > targetCount + 4) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < targetCount + 4; ++j) {
                        sb.append(sep);
                    }
                    sb.append(row.trim());
                    rows[cur[0]] = sb.toString();
                    length = helper(rows, cur, sep, level + 1) + sepCount - targetCount - 4;
                } else {
                    length = helper(rows, cur, sep, level + 1);
                }
                if (length != 0) {
                    max = Math.max(max, len + length);
                }
            } else {
                break;
            }
        }
        return max;
    }
}
