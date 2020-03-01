package day4;

/**
 * @author Heng Yu
 * @date 2/29/20 4:01 PM
 */

/**
 * leetcode 43: Multiply Strings
 */

public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings solution = new MultiplyStrings();
        String result = solution.multiply("123", "456");
        System.out.println(result);
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))   return "0";

        int[] nums = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; --i) {
            int d1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; --j) {
                int d2 = num2.charAt(j) - '0';
                int prod = d1 * d2 + nums[i + j + 1];
                nums[i + j + 1] = prod % 10;
                int carryBit = prod / 10;
                int k = i + j;
                while (carryBit != 0) {
                    int sum = carryBit + nums[k];
                    nums[k--] = sum % 10;
                    carryBit = sum / 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int num : nums) {
            if (flag) {
                sb.append(num);
            } else {
                if (num != 0) {
                    sb.append(num);
                    flag = true;
                }
            }
        }
        return sb.toString();
    }
}
