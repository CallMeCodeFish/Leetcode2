package day1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 2/26/20 10:38 PM
 */

/**
 * leetcode 12: Integer to Roman
 */

public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        String result = solution.intToRoman(1994);
        System.out.println(result);
    }

    public String intToRoman(int num) {
        String[][] dict = new String[][]{
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}};
        List<String> list = new ArrayList<>();
        int row = 0;
        while (num != 0) {
            int col = num % 10;
            list.add(dict[row][col]);
            num /= 10;
            ++row;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; --i) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
