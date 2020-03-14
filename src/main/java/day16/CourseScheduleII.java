package day16;

/**
 * @author Heng Yu
 * @date 3/13/20 9:46 PM
 */

import java.util.*;

/**
 * leetcode 210: Course Schedule II
 * dfs也可以，参考第一遍的解法
 */

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result = solution.findOrder(4, prerequisites);
        System.out.println(Arrays.toString(result));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] matrix = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            matrix[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            ++inDegree[pair[0]];
            matrix[pair[1]].add(pair[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) q.offer(i);
        }
        int[] res = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int poll = q.poll();
            res[i++] = poll;
            ++count;
            List<Integer> neighbors = matrix[poll];
            for (int neighbor : neighbors) {
                --inDegree[neighbor];
                if (inDegree[neighbor] == 0) q.offer(neighbor);
            }
        }
        if (count < numCourses) return new int[0];
        return res;
    }
}
