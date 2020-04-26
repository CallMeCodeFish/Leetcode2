package contest.Apr25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 4/25/20 11:17 PM
 */


public class DiagonalTraversal {
    public static void main(String[] args) {
        DiagonalTraversal solution = new DiagonalTraversal();
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1,2,3,4,5,6));
        int[] result = solution.findDiagonalOrder(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();
        int n = 0;
        int len = 0;
        for (List<Integer> num : nums) {
            len += num.size();
            if (num.size() > n) {
                n = num.size();
            }
        }

        List<Integer>[] diagonal = new List[m + n];
        for (int i = 0; i < diagonal.length; ++i) {
            diagonal[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < nums.get(i).size(); ++j) {
                diagonal[i + j].add(0, nums.get(i).get(j));
            }
        }

        int[] res = new int[len];
        int i = 0;
        for (List<Integer> d : diagonal) {
            for (int val : d) {
                res[i++] = val;
            }
        }

        return res;
    }
}
