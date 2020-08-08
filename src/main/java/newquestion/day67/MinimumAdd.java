package newquestion.day67;

/**
 * leetcode 921: Minimum add to make parentheses valid
 */
public class MinimumAdd {
    public int minAddToMakeValid(String S) {
        char[] chs = S.toCharArray();

        int res = 0;

        int count = 0;


        for (char c : chs) {
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    res++;
                } else {
                    count--;
                }
            }
        }

        res += count;

        return res;
    }
}
