package newquestion.day14;

/**
 * @author Heng Yu
 * @date 5/12/20 2:34 PM
 */

/**
 * leetcode 767: Reorganize string
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] count = new int[26];

        char maxChar = 'a';
        int maxCount = 0;
        for (char c : S.toCharArray()) {
            if (++count[c - 'a'] > maxCount) {
                maxCount = count[c - 'a'];
                maxChar = c;
            }
        }

        if (maxCount - 1 > S.length() - maxCount) return "";

        StringBuilder[] groups = new StringBuilder[maxCount];
        for (int i = 0; i < groups.length; ++i) {
            groups[i] = new StringBuilder();
            groups[i].append(maxChar);
        }
        count[maxChar- 'a'] = 0;

        int i = 0;
        for (int j = 0; j < count.length; ++j) {
            while (count[j]-- > 0) {
                char c = (char) (j + 'a');
                groups[i].append(c);
                i = (i + 1) % maxCount;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (StringBuilder group : groups) {
            sb.append(group);
        }

        return sb.toString();
    }
}
