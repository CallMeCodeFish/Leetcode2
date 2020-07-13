package newquestion.day53;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 7/12/20 7:07 PM
 */

/**
 * leetcode 1073: Adding two negabinary numbers
 */
public class AddingTwoNegabinaryNumbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int len = Math.max(arr1.length, arr2.length) + 2;
        int[] res = new int[len];
        int i = arr1.length - 1, j = arr2.length - 1, k = len - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = arr1[i--] + arr2[j--] + carry;
            if (sum == -1) {
                res[k--] = 1;
                carry = 1;
            } else {
                res[k--] = sum % 2;
                carry = -sum / 2;
            }
        }

        while (i >= 0) {
            int sum = arr1[i--] + carry;
            if (sum == -1) {
                res[k--] = 1;
                carry = 1;
            } else {
                res[k--] = sum % 2;
                carry = -sum / 2;
            }
        }

        while (j >= 0) {
            int sum = arr2[j--] + carry;
            if (sum == -1) {
                res[k--] = 1;
                carry = 1;
            } else {
                res[k--] = sum % 2;
                carry = -sum / 2;
            }
        }

        while (carry != 0) {
            if (carry == -1) {
                res[k--] = 1;
                carry = 1;
            } else {
                res[k--] = 1;
                carry = 0;
            }
        }

        i = 0;
        while (i < len) {
            if (res[i] != 0) {
                break;
            }
            i++;
        }

        return i == len ? new int[]{0} : Arrays.copyOfRange(res, i, len);
    }
}
