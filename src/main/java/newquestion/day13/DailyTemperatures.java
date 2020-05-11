package newquestion.day13;

/**
 * @author Heng Yu
 * @date 5/11/20 4:08 PM
 */

import java.util.Arrays;

/**
 * leetcode 739: Daily temperatures
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(T);
        System.out.println(Arrays.toString(result));
    }

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];

        for (int i = len - 2; i >= 0; --i) {
            int j = i + 1;
            while (j < len) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                }
                if (res[j] == 0) {
                    break;
                }
                j = j + res[j];
            }
        }

        return res;
    }
}
