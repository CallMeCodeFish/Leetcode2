package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 5:03 PM
 */

/**
 * leetcode 14: Longest Common Prefix
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = new String[]{"dog", "racecar", "car"};
        String result = solution.longestCommonPrefix(strs);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; ++i) {
            char target = strs[0].charAt(i);
            boolean isCommon = true;
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != target) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) {
                sb.append(target);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
