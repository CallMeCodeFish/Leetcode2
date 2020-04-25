package newquestion.day1;

/**
 * @author Heng Yu
 * @date 4/24/20 11:16 PM
 */

/**
 * leetcode 402: Remove K Digits
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        String result = solution.removeKdigits("1432219", 3);
        System.out.println(result);
    }

    public String removeKdigits(String num, int k) {
        char[] chs = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            if (sb.length() == 0 || k == 0) {
                sb.append(c);
            } else {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && k > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                    --k;
                }
                sb.append(c);
            }
        }
        while (sb.length() > 0 && k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            --k;
        }
        if (sb.length() == 0) return "0";
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') ++i;
        if (i == sb.length()) return "0";
        return sb.substring(i);
    }
}
