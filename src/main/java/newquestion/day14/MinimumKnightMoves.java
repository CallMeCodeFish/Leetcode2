package newquestion.day14;

/**
 * @author Heng Yu
 * @date 5/12/20 2:07 PM
 */

import java.util.*;

/**
 * leetcode 1197: Minimum knight moves
 */
public class MinimumKnightMoves {
    public static void main(String[] args) {
        MinimumKnightMoves solution = new MinimumKnightMoves();
        long start = System.nanoTime();
        int result = solution.minKnightMoves(-84, 170);
        System.out.println("duration: " + (System.nanoTime() - start));
        System.out.println(result);
    }

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        int[] point = {0, 0};
        visited.add(Arrays.toString(point));
        q.offer(point);

        int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] poll = q.poll();
                if (poll[0] == x && poll[1] == y) return res;

                for (int[] dir : dirs) {
                    poll[0] += dir[0];
                    poll[1] += dir[1];

                    if (poll[0] >= 0 && poll[1] >= 0) {
                        String s = Arrays.toString(poll);
                        if (!visited.contains(s)) {
                            visited.add(s);
                            point = poll.clone();
                            q.offer(point);
                        }
                    }

                    poll[0] -= dir[0];
                    poll[1] -= dir[1];
                }
            }
            ++res;
        }

        return -1;
    }
}
