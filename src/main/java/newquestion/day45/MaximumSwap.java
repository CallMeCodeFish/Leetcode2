package newquestion.day45;

/**
 * @author Heng Yu
 * @date 6/29/20 4:59 PM
 */

/**
 * leetcode 670: Maximum swap
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        String max = String.valueOf(num);
        char[] chs = max.toCharArray();
        int len = chs.length;

        for (int i = 0; i < chs.length; i++) {
            for (int j = i + 1; j < chs.length; j++) {
                char temp = chs[i];
                chs[i] = chs[j];
                chs[j] = temp;

                String s = String.valueOf(chs);
                if (max.compareTo(s) < 0) {
                    max = s;
                }
                chs[j] = chs[i];
                chs[i] = temp;
            }
        }

        return Integer.parseInt(max);
    }
}
