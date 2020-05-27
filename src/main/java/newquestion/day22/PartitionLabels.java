package newquestion.day22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/26/20 5:51 PM
 */

/**
 * leetcode 763: Partition labels
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        char[] chs = S.toCharArray();

        int[] letters = new int[26];

        for (char c : chs) {
            ++letters[c - 'a'];
        }

        int[] current = new int[26];

        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();

        while (j < chs.length) {
            ++current[chs[j] - 'a'];

            boolean canPartition = true;
            for (int k = 0; k < current.length; ++k) {
                if (current[k] > 0 && current[k] != letters[k]) {
                    canPartition = false;
                    break;
                }
            }

            if (canPartition) {
                res.add(j - i + 1);
                i = j + 1;
            }
            ++j;
        }

        return res;
    }
}
