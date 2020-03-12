package day14;

/**
 * @author Heng Yu
 * @date 3/11/20 2:39 PM
 */

/**
 * leetcode 171: Excel Sheet Column Number
 */

public class ExcelColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            int num = ch - 'A' + 1;
            res *= 26;
            res += num;
        }
        return res;
    }
}
