package newquestion.day51;

/**
 * @author Heng Yu
 * @date 7/9/20 4:03 PM
 */

/**
 * leetcode 796: Rotate string
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        int len = A.length();
        if (len == 0) return true;

        char[] chs1 = A.toCharArray();
        char[] chs2 = B.toCharArray();

        for (int i = 0; i < len; i++) {
            if (chs2[0] == chs1[i]) {
                if (canRotate(chs2, chs1, i)) return true;
            }
        }

        return false;
    }

    private boolean canRotate(char[] target, char[] chs, int i) {
        int len = chs.length;
        int j = 0;
        while (j < len) {
            if (target[j] != chs[i]) return false;
            j++;
            i++;
            if (i == len) i = 0;
        }

        return true;
    }
}
