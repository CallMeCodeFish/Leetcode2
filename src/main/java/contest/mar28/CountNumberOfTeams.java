package contest.mar28;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/28/20 10:38 PM
 */


public class CountNumberOfTeams {
    public static void main(String[] args) {
        CountNumberOfTeams solution = new CountNumberOfTeams();
        int[] rating = {1,2,3,4};
        int result = solution.numTeams(rating);
        System.out.println(result);
    }

    public int numTeams(int[] rating) {
        int res = 0;
        int len = rating.length;
        List<Integer>[] greater = new List[len];
        List<Integer>[] less = new List[len];
        for (int i = 0; i < len; ++i) {
            greater[i] = new ArrayList<>();
            less[i] = new ArrayList<>();
        }
        for (int i = 0; i < len; ++i) {
            int target = rating[i];
            for (int j = i + 1; j < len; ++j) {
                if (rating[j] < target) {
                    less[i].add(j);
                } else {
                    greater[i].add(j);
                }
            }
        }
        for (int i = 0; i < len; ++i) {
            List<Integer> nextGreaterIndex = greater[i];
            List<Integer> nextLessIndex = less[i];
            for (int j : nextGreaterIndex) {
                res += greater[j].size();
            }
            for (int j : nextLessIndex) {
                res += less[j].size();
            }
        }
        return res;
    }
}
