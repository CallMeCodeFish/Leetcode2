package day17;

/**
 * @author Heng Yu
 * @date 3/14/20 6:37 PM
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 225: Implement Stack Using Queues
 */

public class ImplementStackUsingQueue {
    Queue<Integer> q;
    int top;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueue() {
        this.q = new LinkedList<>();
        this.top = 0;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.offer(x);
        top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = q.size() - 1;
        if (size == 0) {
            top = 0;
            return q.poll();
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; ++i) {
            int poll = q.poll();
            if (i == size - 1) {
                top = poll;
            }
            queue.offer(poll);
        }
        int res = q.poll();
        q = queue;
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}
