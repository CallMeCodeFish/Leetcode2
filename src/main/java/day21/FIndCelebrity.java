package day21;

/**
 * @author Heng Yu
 * @date 3/18/20 9:49 PM
 */


public class FIndCelebrity {
    public int findCelebrity(int n) {
        int res = -1;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n) {
                if (knows(i, j) || !knows(j, i)) break;
                ++j;
            }
            if (j == n) {
                int k = 0;
                while (k < i) {
                    if (knows(i, k) || !knows(k, i)) break;
                    ++k;
                }
                if (k == i) {
                    res = i;
                    break;
                }
            }
            i = j;
        }
        return res;
    }

    private boolean knows(int a, int b) {
        return true;
    }
}
