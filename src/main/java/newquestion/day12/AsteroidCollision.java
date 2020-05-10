package newquestion.day12;

/**
 * @author Heng Yu
 * @date 5/9/20 2:13 PM
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * leetcode 735: Asteroid Collision
 * solution: stack
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision solution = new AsteroidCollision();
//        int[] asteroids = {1,1,-1,-1};
        int[] asteroids = {8,-8};
        int[] result = solution.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result));
    }

    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] status = new int[len];

        int i = 0;
        while (i < len) {
            status[i] = 1;
            if (asteroids[i] > 0) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    int sum = asteroids[top] + asteroids[i];
                    if (sum > 0) {
                        status[i] = -1;
                        break;
                    } else if (sum == 0) {
                        status[i] = -1;
                        status[top] = -1;
                        stack.poll();
                        break;
                    } else {
                        status[top] = -1;
                        stack.poll();
                    }
                }
            }
            ++i;
        }

        int count = 0;
        for (i = 0; i < len; ++i) {
            if (status[i] == 1) {
                ++count;
            }
        }

        int[] res = new int[count];

        int j = 0;
        for (i = 0; i < len; ++i) {
            if (status[i] == 1) {
                res[j++] = asteroids[i];
            }
        }

        return res;
    }
}
