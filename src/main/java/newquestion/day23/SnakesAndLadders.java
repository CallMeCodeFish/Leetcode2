package newquestion.day23;

/**
 * @author Heng Yu
 * @date 5/27/20 2:52 PM
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * leetcode 909: Snakes and ladders
 * Solution: BFS
 */
public class SnakesAndLadders {
    public static void main(String[] args) {
        SnakesAndLadders solution = new SnakesAndLadders();
        int[][] board = {{-1,4,-1},{6,2,6},{-1,3,-1}};
        int result = solution.snakesAndLadders(board);
        System.out.println(result);
    }

    private static class Pair {
        int x;
        int y;
        int value;

        public Pair(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        int fromLeft = (n - 1) % 2;
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(new Pair(n - 1, 0, 1));
        visited.add(1);

        int res = 0;
        boolean hasResult = false;
        final int LIMIT = n * n;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; ++i) {
                Pair cur = q.poll();
                if (cur.value == LIMIT) {
                    hasResult = true;
                    break;
                }

                for (int step = 1; step < 7; ++step) {
                    int nextValue = cur.value + step;
                    if (nextValue > LIMIT) break;

                    if (!visited.contains(nextValue)) {
                        visited.add(nextValue);
                        int nx = n - 1 - (nextValue - 1) / n;
                        int ny = (nx % 2 == fromLeft)? (nextValue - 1) % n : n - 1 - (nextValue - 1) % n;

                        if (board[nx][ny] > 0) {
                            //there is a snake or ladder
                            nextValue = board[nx][ny];
                            if (!visited.contains(nextValue)) {
                                nx = n - 1 - (nextValue - 1) / n;
                                ny = (nx % 2 == fromLeft)? (nextValue - 1) % n : n - 1 - (nextValue - 1) % n;
                                q.offer(new Pair(nx, ny, nextValue));
                            }
                        } else {
                            q.offer(new Pair(nx, ny, nextValue));
                        }
                    }
                }
            }

            if (hasResult) break;
            ++res;
        }

        return (hasResult)? res : -1;
    }
}
