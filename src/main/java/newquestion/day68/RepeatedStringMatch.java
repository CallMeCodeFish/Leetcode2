package newquestion.day68;

/**
 * leetcode 686: Repeated string match
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        char[] chs1 = A.toCharArray();
        char[] chs2 = B.toCharArray();

        for (int i = 0; i < chs1.length; i++) {
            int j = i;
            int cur = 1;
            int k = 0;
            while (k < chs2.length) {
                if (j == chs1.length) {
                    cur++;
                    j = 0;
                }
                if (chs1[j] != chs2[k]) break;
                k++;
                j++;
            }
            if (k == chs2.length) return cur;
        }

        return -1;
    }
}
