package day21;

/**
 * @author Heng Yu
 * @date 3/18/20 9:32 PM
 */


public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        int same = 0;
        int notSame = k;
        for (int i = 1; i < n; ++i) {
            int copySame = same;
            int copyNotSame = notSame;
            same = copyNotSame;
            notSame = (copySame + copyNotSame) * (k - 1);
        }
        return same + notSame;
    }
}
