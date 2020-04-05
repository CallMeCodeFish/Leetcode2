package contest.Apr4;

/**
 * @author Heng Yu
 * @date 4/4/20 10:56 PM
 */


public class NumberOfSteps {
    public static void main(String[] args) {
        NumberOfSteps solution = new NumberOfSteps();
        int result = solution.numSteps("1");
        System.out.println(result);
    }

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int res = 0;
        while (sb.length() > 1) {
            if (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                addOne(sb);
            }
            ++res;
        }
        return res;
    }

    private void addOne(StringBuilder sb) {
        int carry = 1;
        for (int i = sb.length() - 1; i >= 0; --i) {
            int digit = sb.charAt(i) - '0';
            int sum = digit + carry;
            carry = sum / 2;
            char ch = (char) (sum % 2 + '0');
            sb.setCharAt(i, ch);
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
    }
}
