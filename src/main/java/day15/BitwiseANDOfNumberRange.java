package day15;

/**
 * @author Heng Yu
 * @date 3/12/20 9:56 PM
 */

/**
 * leetcode 201: Bitwise AND of Number Range
 */

public class BitwiseANDOfNumberRange {
    public int rangeBitwiseAnd(int m, int n) {
        //edge case
        if (m == 0) return 0;
        if (m == n) return m;

        int shift = 0;
        for (int i = 0; i < 32; ++i) {
            if ((m >> i & 1) == 1) {
                shift = i;
            }
        }
        if (shift < 31 && 0 < (n >> shift + 1)) return 0;
        int res = 0;
        while (0 <= shift) {
            int d1 = m >> shift & 1;
            int d2 = n >> shift & 1;
            if (d1 != d2) break;
            res += d1 << shift;
            --shift;
        }
        return res;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        int shift = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}
