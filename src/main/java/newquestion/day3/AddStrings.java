package newquestion.day3;

/**
 * @author Heng Yu
 * @date 4/26/20 7:38 PM
 */

/**
 * leetcode 415: Add Strings
 */
public class AddStrings {
    public static void main(String[] args) {
        AddStrings solution = new AddStrings();
        String result = solution.addStrings("9", "99");
        System.out.println(result);
    }

    public String addStrings(String num1, String num2) {
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();

        int carry = 0;
        int len = Math.max(chs1.length, chs2.length);
        int[] array = new int[len];

        int i = chs1.length - 1, j = chs2.length - 1, k = len - 1;
        while (i >= 0 && j >= 0) {
            int sum = carry + chs1[i] - '0' + chs2[j] - '0';
            array[k--] = sum % 10;
            carry = sum / 10;
            --i;
            --j;
        }

        while (i >= 0) {
            int sum = carry + chs1[i] - '0';
            array[k--] = sum % 10;
            carry = sum / 10;
            --i;
        }

        while (j >= 0) {
            int sum = carry + chs2[j] - '0';
            array[k--] = sum % 10;
            carry = sum / 10;
            --j;
        }

        StringBuilder sb = new StringBuilder();
        if (carry != 0) {
            sb.append(carry);
        }
        for (int num : array) {
            sb.append(num);
        }

        return sb.toString();
    }
}
