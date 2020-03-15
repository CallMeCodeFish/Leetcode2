package contest.mar14;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Heng Yu
 * @date 3/14/20 10:45 PM
 */

/**
 * leetcode 1381: Design a Stack With Increment Operation
 */

public class CustomStack {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        int result = customStack.pop();// return 2 --> Return top of the stack 2, stack becomes [1]
        System.out.println(result);
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        result = customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println(result);
        customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
        customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
        customStack.pop();                            // return -1 --> Stack is empty return -1.
    }

    private Deque<Integer> stack;
    private int capacity;

    public CustomStack(int maxSize) {
        this.stack = new LinkedList<>();
        this.capacity = maxSize;
    }

    public void push(int x) {
        if (stack.size() < capacity) stack.offer(x);
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        return stack.pollLast();
    }

    public void increment(int k, int val) {
        if (stack.size() < k) k = stack.size();
        for (int i = 0; i < stack.size(); ++i) {
            int poll = stack.poll();
            if (i < k) poll += val;
            stack.offer(poll);
        }
    }
}
