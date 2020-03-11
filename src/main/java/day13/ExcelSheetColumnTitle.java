package day13;

/**
 * @author Heng Yu
 * @date 3/10/20 9:52 PM
 */


public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        ExcelSheetColumnTitle solution = new ExcelSheetColumnTitle();
        String result = solution.convertToTitle(52);
        System.out.println(result);
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (0 < n) {
            int r = n % 26;
            n /= 26;
            char ch = 'Z';
            if (0 < r) {
                ch = (char) ('A' + r - 1);
            } else {
                --n;
            }
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}
