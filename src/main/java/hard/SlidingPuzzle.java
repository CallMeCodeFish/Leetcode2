package hard;

/**
 * @author Heng Yu
 * @date 5/6/20 9:54 PM
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * leetcode 773: Sliding puzzle
 */
public class SlidingPuzzle {
    public static void main(String[] args) {
        SlidingPuzzle solution = new SlidingPuzzle();
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        int result = solution.slidingPuzzle(board);
        System.out.println(result);
    }

    private static class Node {
        int[][] board;
        int x;
        int y;
        int cost;
        int move;

        public Node(int[][] board, int x, int y) {
            this.board = board;
            this.x = x;
            this.y = y;
            this.move = 0;
            calculateCost();
        }

        public Node(int[][] board, int x, int y, int nx, int ny, int move) {
            this.board = new int[2][];
            for (int i = 0; i < 2; ++i) {
                this.board[i] = board[i].clone();
            }
            this.x = nx;
            this.y = ny;
            this.move = move;
            this.board[x][y] = this.board[nx][ny];
            this.board[nx][ny] = 0;
            calculateCost();
        }

        private void calculateCost() {
            int cost = 0;
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (board[i][j] != 0 && board[i][j] != 3 * i + j + 1) ++cost;
                }
            }
            this.cost = cost;
        }
    }

    public int slidingPuzzle(int[][] board) {
        int x = 0, y = 0;
        search:
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                    break search;
                }
            }
        }

        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> (a.move + a.cost) - (b.move + b.cost));
        Set<String> visited = new HashSet<>();

        Node node = new Node(board, x, y);
        heap.offer(node);
        visited.add(Arrays.deepToString(board));
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!heap.isEmpty()) {
            Node min = heap.poll();
            if (min.cost == 0) {
                return min.move;
            }

            for (int[] dir : dirs) {
                int nx = min.x + dir[0];
                int ny = min.y + dir[1];
                if (nx >= 0 && nx < 2 && ny >= 0 && ny < 3) {
                    node = new Node(min.board, min.x, min.y, nx, ny, min.move + 1);
                    String deepString = Arrays.deepToString(node.board);
                    if (!visited.contains(deepString)) {
                        heap.offer(node);
                        visited.add(deepString);
                    }
                }
            }
        }

        return -1;
    }
}
