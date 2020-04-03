package day29;

/**
 * @author Heng Yu
 * @date 4/2/20 8:33 PM
 */

import java.util.*;

/**
 * leetcode 353: Design Snake Game
 */

public class SnakeGame {
    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private int score;
    private Pair head;
    private Queue<Pair> body;
    private Set<Pair> set;
    private int width;
    private int height;
    private int[][] food;
    private int index;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.score = 0;
        this.head = new Pair(0, 0);
        this.body = new LinkedList<>();
        this.set = new HashSet<>();
        this.index = 0;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        if (score == -1) return -1;

        int x = head.x;
        int y = head.y;
        if ("L".equals(direction)) {
            --y;
        } else if ("R".equals(direction)) {
            ++y;
        } else if ("U".equals(direction)) {
            --x;
        } else {
            ++x;
        }
        if (x == height || y == width || x < 0 || y < 0) {
            score = -1;
            return score;
        }
        if (score == 0) {
            if (index < food.length && food[index][0] == x && food[index][1] == y) {
                body.offer(head);
                set.add(head);
                head = new Pair(x, y);
                ++score;
                ++index;
            } else {
                head.x = x;
                head.y = y;
            }
        } else {
            if (index < food.length && food[index][0] == x && food[index][1] == y) {
                body.offer(head);
                set.add(head);
                head = new Pair(x, y);
                ++score;
                ++index;
            } else {
                Pair poll = body.poll();
                set.remove(poll);
                body.offer(head);
                set.add(head);
                head = new Pair(x, y);
                if (set.contains(head)) {
                    score = -1;
                    return score;
                }
            }
        }
        return score;
    }
}
