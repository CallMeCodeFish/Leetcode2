package newquestion.day65;

import java.util.List;

/**
 * @author Tim
 * @date 8/5/20 6:00 PM
 */

/**
 * leetcode 1428: Leftmost column with at least a one
 */
public class LeftmostColumn {
    public int leftMostColumnWithOne(BinaryMatrix bm) {
        List<Integer> dimensions = bm.dimensions();
        int m = dimensions.get(0);
        int n = dimensions.get(1);

        int res = n;

        for (int i = 0; i < m; i++) {
            int l = 0, r = res;
            int cur = search(bm, i, l, r);
            res = Math.min(res, cur);
        }

        return res == n ? -1 : res;
    }

    private int search(BinaryMatrix bm, int row, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (1 == bm.get(row, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}

interface BinaryMatrix {
    int get(int row, int col);
    List<Integer> dimensions();
}
