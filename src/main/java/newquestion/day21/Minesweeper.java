package newquestion.day21;

/**
 * @author Heng Yu
 * @date 5/25/20 3:15 PM
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 529: Minesweeper
 */
public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        //edge case
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(click[0]);
        qy.offer(click[1]);
        visited[click[0]][click[1]] = true;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};

        while (!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();

            int count = 0;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'M') ++count;
            }

            if (count == 0) {
                board[x][y] = 'B';
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        qx.offer(nx);
                        qy.offer(ny);
                    }
                }
            } else {
                board[x][y] = (char) ('0' + count);
            }
        }

        return board;
    }
}
