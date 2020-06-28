package newquestion.day43;

/**
 * @author Heng Yu
 * @date 6/27/20 5:56 PM
 */

/**
 * leetcode 1358: Number of substrings containing three characters
 */
public class NumberOfSubstrings {
    public int numberOfSubstrings(String s) {
        char[] chs = s.toCharArray();

        int i = 0, j = 0;

        int[] freq = new int[3];

        int res = 0;

        while (j < chs.length) {
            int index = chs[j] - 'a';
            freq[index]++;

            int count = 0;
            for (int f : freq) {
                if (f != 0) count++;
            }

            if (count == 3) {
                int r = chs.length - j;
                int l = 0;
                while (i < j) {
                    index = chs[i++] - 'a';
                    l++;
                    if (--freq[index] == 0) break;
                }
                res += l * r;
            }

            j++;
        }

        return res;
    }
}
