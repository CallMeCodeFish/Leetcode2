package hard;

/**
 * @author Heng Yu
 * @date 5/29/20 7:00 PM
 */


/**
 * leetcode 1163: Last substring in lexicographical order
 */
public class LastSubstringInLexicographicalOrder {
    public static void main(String[] args) {
        LastSubstringInLexicographicalOrder solution = new LastSubstringInLexicographicalOrder();
        String result = solution.lastSubstring("cacacb");
        System.out.println(result);
    }

    public String lastSubstring(String s) {
        char[] chs = s.toCharArray();
        char max = 'a';
        for (char c : chs) {
            if (max < c) max = c;
        }

        int start = 0;
        for (int i = 0; i < chs.length; i++) {
            if (max == chs[i]) {
                start = i;
                break;
            }
        }

        int j = start + 1;
        int i = 0;
        boolean flag = false;
        int nextStart = 0;
        while (j < chs.length) {
            if (flag) {
                if (chs[i] < chs[j]) {
                    start = nextStart;
                    flag = false;
                } else if (chs[i] > chs[j]) {
                    flag = false;
                } else {
                    if (chs[j] == max) {
                        int k = j;
                        while (k < chs.length && chs[i] == chs[k]) {
                            i++;
                            k++;
                        }
                        if (k == chs.length) break;

                        if (chs[i] < chs[k]) {
                            start = nextStart;
                        }
                        i = start + 1;
                        nextStart = j;
                    } else {
                        i++;
                    }
                }
            } else {
                if (chs[j] == max) {
                    flag = true;
                    nextStart = j;
                    i = start + 1;
                }
            }
            j++;
        }

        return s.substring(start);
    }
}
