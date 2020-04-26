package newquestion.day2;

/**
 * @author Heng Yu
 * @date 4/25/20 5:50 PM
 */

import java.util.*;

/**
 * leetcode 406: Queue reconstruction by height
 */
public class QueueReconstruction {
    public static void main(String[] args) {
        QueueReconstruction solution = new QueueReconstruction();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = solution.reconstructQueue(people);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new LinkedList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for (int[] nums : people) {
            list.add(nums[1], nums);
        }
        int[][] res = new int[people.length][];
        for (int i = 0; i < res.length; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
