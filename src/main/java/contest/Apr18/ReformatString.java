package contest.Apr18;

/**
 * @author Heng Yu
 * @date 4/18/20 10:33 PM
 */


public class ReformatString {

    public String reformat(String s) {
        char[] chs = s.toCharArray();
        int letterCount = 0;
        for (char c : chs) {
            if (Character.isLetter(c)) {
                ++letterCount;
            }
        }
        int digitCount = s.length() - letterCount;
        if (Math.abs(letterCount - digitCount) > 1) return "";

        char[] res = new char[s.length()];
        if (letterCount > digitCount) {
            int i = 0, j = 1;
            for (char c : chs) {
                if (Character.isLetter(c)) {
                    res[i] = c;
                    i += 2;
                } else {
                    res[j] = c;
                    j += 2;
                }
            }
        } else {
            int i = 0, j = 1;
            for (char c : chs) {
                if (Character.isDigit(c)) {
                    res[i] = c;
                    i += 2;
                } else {
                    res[j] = c;
                    j += 2;
                }
            }
        }
        return String.valueOf(res);
    }
}
