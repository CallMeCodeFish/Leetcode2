package day15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/13/20 12:01 AM
 */


public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        boolean result = solution.canFinish(2, prerequisites);
        System.out.println(result);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<Integer>[] matrix = new List[numCourses];
        for (int[] pair : prerequisites) {
            if (matrix[pair[1]] == null) {
                matrix[pair[1]] = new ArrayList<>();
            }
            matrix[pair[1]].add(pair[0]);
        }
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0) {
                boolean canFinish = dfs(i, matrix, visited);
                if (!canFinish) return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, List<Integer>[] matrix, int[] visited) {
        visited[i] = 1;
        if (matrix[i] != null) {
            List<Integer> neighbors = matrix[i];
            for (int j : neighbors) {
                if (visited[j] == 1) return false;
                if (visited[j] == 0) {
                    boolean canFinish = dfs(j, matrix, visited);
                    if (!canFinish) return false;
                }
            }
        }
        visited[i] = 2;
        return true;
    }
}
