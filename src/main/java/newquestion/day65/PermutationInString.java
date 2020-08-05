package newquestion.day65;

/**
 * @author Tim
 * @date 8/5/20 6:02 PM
 */

/**
 * leetcode 567: Permutation in string
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] target = new int[26];
        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }

        int[] count = new int[26];
        char[] chs = s2.toCharArray();
        int i = 0, j = 0;

        while (j < chs.length) {
            count[chs[j] - 'a']++;
            int len = j - i + 1;
            if (len == s1.length()) {
                boolean isContained = true;
                for (int k = 0; k < 26; k++) {
                    if (count[k] != target[k]) {
                        isContained = false;
                        break;
                    }
                }
                if (isContained) return true;
                count[chs[i++] - 'a']--;
            }
            j++;
        }

        return false;
    }
}
