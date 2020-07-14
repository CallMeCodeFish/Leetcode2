package newquestion.day54;

/**
 * @author Heng Yu
 * @date 7/13/20 8:25 PM
 */

/**
 * leetcode 467: Unique substrings in wraparound string
 * solution: sliding window
 */
public class UniqueSubstrings {
    public int findSubstringInWraproundString(String p) {
        if (p.isEmpty()) return 0;

        char[] chs = p.toCharArray();
        int[] lens = new int[26];
        int i = 0, j = 0;
        char target = chs[0];
        while (j < chs.length) {
            if (target == chs[j]) {
                j++;
                target = target == 'z' ? 'a' : (char) (target + 1);
            } else {
                while (i < j) {
                    int index = chs[i] - 'a';
                    lens[index] = Math.max(lens[index], j - i);
                    i++;
                }
                target = chs[i];
            }
        }

        while (i < chs.length) {
            int index = chs[i] - 'a';
            lens[index] = Math.max(lens[index], j - i);
            i++;
        }

        int res = 0;
        for (int len : lens) res += len;

        return res;
    }
}
