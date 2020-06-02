package newquestion.day26;

/**
 * @author Heng Yu
 * @date 6/1/20 3:38 PM
 */

import java.util.Arrays;
import java.util.List;

/**
 * leetcode 1239: Maximum length of a concatenated string with unique characters
 * solution: bitmask + backtracking
 */
public class MaximumLength {
    public static void main(String[] args) {
        MaximumLength solution = new MaximumLength();
        int result = solution.maxLength(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"));
        System.out.println(result);
    }

    public int maxLength(List<String> arr) {
        int len = arr.size();
        int[] bitmasks = new int[len];
        for (int i = 0; i < len; i++) {
            String s = arr.get(i);
            int[] letters = new int[26];
            boolean isValid = true;
            for (char c : s.toCharArray()) {
                if (letters[c - 'a'] > 0) {
                    isValid = false;
                    break;
                }
                ++letters[c - 'a'];
            }
            if (isValid) {
                for (int j = 0; j < letters.length; j++) {
                    if (letters[j] > 0) {
                        bitmasks[i] |= (1 << j);
                    }
                }
            } else {
                bitmasks[i] = Integer.MIN_VALUE;
            }
        }

        return helper(arr, bitmasks, 0, 0);
    }

    private int helper(List<String> arr, int[] bitmasks, int start, int curMask) {
        int res = 0;

        for (int i = start; i < bitmasks.length; i++) {
            if (bitmasks[i] != Integer.MIN_VALUE) {
                if ((curMask & bitmasks[i]) == 0) {
                    int cur = arr.get(i).length();
                    if (i + 1 < bitmasks.length) {
                        cur += helper(arr, bitmasks, i + 1, curMask | bitmasks[i]);
                    }
                    res = Math.max(res, cur);
                }
            }
        }

        return res;
    }
}
