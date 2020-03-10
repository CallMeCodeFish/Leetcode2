package day12;

/**
 * @author Heng Yu
 * @date 3/9/20 4:58 PM
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 155: Min Stack
 */

public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        this.min = new ArrayDeque<>();
        this.stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            min.push(Math.min(min.peek(), x));
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
