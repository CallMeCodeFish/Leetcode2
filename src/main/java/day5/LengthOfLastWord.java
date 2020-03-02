package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 9:07 PM
 */

/**
 * leetcode 58: Length of Last Word
 */

public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        int result = solution.lengthOfLastWord("Hello World");
        System.out.println(result);
    }

    public int lengthOfLastWord(String s) {
        //edge case
        if (s == null || s.isEmpty()) return 0;

        int l = -1;
        int r = -1;
        boolean isFound = false;
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (!isFound) {
                if (Character.isLetter(ch)) {
                    r = i;
                    isFound = true;
                }
            } else {
                if (ch == ' ') {
                    l = i;
                    break;
                }
            }
        }
        return r - l;
    }
}
