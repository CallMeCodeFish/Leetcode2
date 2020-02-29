package day3;

/**
 * @author Heng Yu
 * @date 2/28/20 6:29 PM
 */

/**
 * leetcode 28: Implement substr()
 */

public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr solution = new ImplementStrStr();
        int result = solution.strStr("aaaaa", "bba");
        System.out.println(result);
    }

    public int strStr(String haystack, String needle) {
        //edge case
        if (needle == null || needle.isEmpty()) return 0;
        if (haystack == null || haystack.isEmpty()) return -1;

        int len = needle.length();
        int res = -1;
        for (int i = 0; i < haystack.length() - len + 1; ++i) {
            if (needle.equals(haystack.substring(i, i + len))) {
                res = i;
                break;
            }
        }
        return res;
    }
}
