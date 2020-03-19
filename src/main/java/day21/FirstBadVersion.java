package day21;

/**
 * @author Heng Yu
 * @date 3/18/20 10:13 PM
 */

/**
 * leetcode 278: First Bad Version
 */

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        while (first <= last) {
            if (first == last) break;
            int mid = first + (last - first) / 2;
            if (isBadVersion(mid)) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }
        return first;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
