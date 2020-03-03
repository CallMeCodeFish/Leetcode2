package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 3:27 PM
 */

/**
 * leetcode 67: Add Binary
 */

public class AddBinary {
    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        String result = solution.addBinary("1010", "1011");
        System.out.println(result);
    }

    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        int[] digits = new int[maxLen];
        int carryBit = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = digits.length - 1;
        while (0 <= i && 0 <= j) {
            int num1 = a.charAt(i--) - '0';
            int num2 = b.charAt(j--) - '0';
            int sum = num1 + num2 + carryBit;
            digits[k--] = sum % 2;
            carryBit = sum / 2;
        }
        while (0 <= i) {
            int num = a.charAt(i--) - '0';
            int sum = num + carryBit;
            digits[k--] = sum % 2;
            carryBit = sum / 2;
        }
        while (0 <= j) {
            int num = b.charAt(j--) - '0';
            int sum = num + carryBit;
            digits[k--] = sum % 2;
            carryBit = sum / 2;
        }
        StringBuilder sb = new StringBuilder();
        if (carryBit != 0) {
            sb.append(1);
        }
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }
}
