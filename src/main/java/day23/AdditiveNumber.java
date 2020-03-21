package day23;

/**
 * @author Heng Yu
 * @date 3/20/20 5:45 PM
 */

/**
 * leetcode 306: Additive Number
 */

public class AdditiveNumber {
    public static void main(String[] args) {
        AdditiveNumber solution = new AdditiveNumber();
        boolean result = solution.isAdditiveNumber("121474836472147483648");
        System.out.println(result);
    }

    public boolean isAdditiveNumber(String num) {
        //edge case
        if (num == null || num.length() < 3) return false;

        return helper(num, 0, "", "");
    }

    private boolean helper(String num, int start, String first, String second) {
        //edge case
        if (start == num.length()) return true;

        if (first.isEmpty()) {
            if ('0' == num.charAt(start)) {
                return helper(num, start + 1, "0", second);
            } else {
                for (int end = start + 1; end < num.length(); ++end) {
                    first = num.substring(start, end);
                    if (helper(num, end, first, second)) return true;
                }
            }
        } else if (second.isEmpty()) {
            if (start == num.length() - 1) return false;
            if ('0' == num.charAt(start)) {
                return helper(num, start + 1, first, "0");
            } else {
                for (int end = start + 1; end < num.length(); ++end) {
                    second = num.substring(start, end);
                    if (helper(num, end, first, second)) return true;
                }
            }
        } else {
            if ('0' == num.charAt(start)) {
                if ("0".equals(first) && "0".equals(second)) {
                    return helper(num, start + 1, second, "0");
                }
            } else {
                String target = add(first, second);
                for (int end = start + 1; end <= num.length(); ++end) {
                    String next = num.substring(start, end);
                    if (target.equals(next)) {
                        return helper(num, end, second, target);
                    }
                }
            }
        }
        return false;
    }

    private String add(String first, String second) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        char[] chs1 = first.toCharArray();
        char[] chs2 = second.toCharArray();
        int i = chs1.length - 1;
        int j = chs2.length - 1;
        while (0 <= i && 0 <= j) {
            int d1 = chs1[i] - '0';
            int d2 = chs2[j] - '0';
            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            --i;
            --j;
        }
        while (0 <= i) {
            int d1 = chs1[i] - '0';
            int sum = d1 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            --i;
        }
        while (0 <= j) {
            int d2 = chs2[j] - '0';
            int sum = d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            --j;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
