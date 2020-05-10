package contest.may9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/9/20 10:30 PM
 */


public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int i = 0, j = 1;
        while (j <= n) {
            if (i == target.length) break;
            if (target[i] == j) {
                res.add("Push");
                i++;
            } else { //target[i] > j
                res.add("Push");
                res.add("Pop");
            }
            j++;
        }

        return res;
    }
}
