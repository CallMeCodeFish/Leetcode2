package newquestion.day2;

/**
 * @author Heng Yu
 * @date 4/25/20 9:31 PM
 */

/**
 * leetcode 408: Valid word abbreviation
 */
public class ValidAbbreviation {
    public static void main(String[] args) {
        ValidAbbreviation solution = new ValidAbbreviation();
        String word = "apple";
        String abbr = "a2l2";
        boolean result = solution.validWordAbbreviation(word, abbr);
        System.out.println(result);
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        //edge case

        char[] chs1 = word.toCharArray();
        char[] chs2 = abbr.toCharArray();

        int i = 0, j = 0;
        while (i < chs1.length && j < chs2.length) {
            char t = chs1[i];
            char p = chs2[j];

            if (!Character.isDigit(p) || p == '0') {
                if (t != p) return false;
                ++i;
                ++j;
            } else {
                int num = 0;
                while (j < chs2.length && Character.isDigit(chs2[j])) {
                    num = num * 10 + chs2[j] - '0';
                    ++j;
                }
                i += num;
            }
        }
        return i == chs1.length && j == chs2.length;
    }
}
