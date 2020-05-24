package contest.may23;

/**
 * @author Heng Yu
 * @date 5/23/20 10:34 PM
 */


public class MaximumNumberOfVowels {
    public int maxVowels(String s, int k) {
        char[] chs = s.toCharArray();
        int res = 0;

        int i = 0, j = 0;
        int count = 0;
        while (j < chs.length) {
            if (isVowel(chs[j])) ++count;

            if (j - i + 1 == k) {
                res = Math.max(res, count);

                if (isVowel(chs[i])) --count;
                ++i;
            }
            ++j;
        }

        return res;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
