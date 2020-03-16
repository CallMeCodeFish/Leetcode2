package day18;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heng Yu
 * @date 3/15/20 4:31 PM
 */


public class ImplementQueueUsingStack {
    private Deque<Integer> s;
    private int top;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStack() {
        this.s = new ArrayDeque<>();
        this.top = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s.isEmpty()) top = x;
        s.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int size = s.size() - 1;
        if (size == 0) {
            top = 0;
            return s.pop();
        }
        Deque<Integer> temp = new ArrayDeque<>();
        for (int i = 0; i < size; ++i) {
            int pop = s.pop();
            if (i == size - 1) top = pop;
            temp.push(pop);
        }
        int res = s.pop();
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.isEmpty();
    }
}
