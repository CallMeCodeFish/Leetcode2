package newquestion.day41;

/**
 * @author Heng Yu
 * @date 6/22/20 8:32 PM
 */

/**
 * leetcode 622: Design circular queue
 */
public class MyCircularQueue {
    private int[] arr;
    private int size;
    private int head;
    private int tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.size = 0;
        this.head = 0;
        this.tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == arr.length) return false;

        if (++tail == arr.length) tail = 0;

        arr[tail] = value;

        size++;

        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0) return false;

        size--;

        if (++head == arr.length) head = 0;

        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return size == 0 ? -1 : arr[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return size == 0 ? -1 : arr[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}
