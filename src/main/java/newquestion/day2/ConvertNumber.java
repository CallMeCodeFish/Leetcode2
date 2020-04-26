package newquestion.day2;

/**
 * @author Heng Yu
 * @date 4/25/20 5:24 PM
 */


public class ConvertNumber {
    public static void main(String[] args) {
        ConvertNumber solution = new ConvertNumber();
        String result = solution.toHex(-1);
        System.out.println(result);
    }

    public String toHex(int num) {
        char[] chs = new char[6];
        chs[0] = 'a';
        chs[1] = 'b';
        chs[2] = 'c';
        chs[3] = 'd';
        chs[4] = 'e';
        chs[5] = 'f';

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; ++i) {
            int n = 0;
            for (int j = 0; j < 4; ++j) {
                n += (num >>> j & 1) << j;
            }
            if (n < 10) {
                sb.append(n);
            } else {
                sb.append(chs[n - 10]);
            }
            num >>>= 4;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.length() == 0) return "0";
        return sb.reverse().toString();
    }
}
