package day1;

/**
 * @author Heng Yu
 * @date 2/26/20 8:17 PM
 */

/**
 * leetcode 6: ZigZag Conversion
 *
 */

public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion solution = new ZigZagConversion();
        String result = solution.convert("PAYPALISHIRING", 4);
        String target = "PINALSIGYAHRPI";
        System.out.println(result.equals(target));
    }

    public String convert(String s, int numRows) {
        //edge case
        if (s == null || s.isEmpty())
            return "";

        if (numRows == 1)
            return s;

        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; ++i) {
            builders[i] = new StringBuilder();
        }
        boolean top2bottom = true;
        int i = 0;
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            builders[i].append(ch);
            if (top2bottom) {
                if (i == builders.length - 1) {
                    --i;
                    top2bottom = false;
                } else {
                    ++i;
                }
            } else {
                if (i == 0) {
                    ++i;
                    top2bottom = true;
                } else {
                    --i;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : builders) {
            res.append(builder);
        }
        return res.toString();
    }
}
