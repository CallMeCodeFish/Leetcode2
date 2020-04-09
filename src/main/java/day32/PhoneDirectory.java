package day32;

/**
 * @author Heng Yu
 * @date 4/8/20 7:28 PM
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * leetcode 379: Design Phone Directory
 */

public class PhoneDirectory {
    private Set<Integer> used;
    private Queue<Integer> unused;
    private int max;


    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.used = new HashSet<>();
        this.unused = new LinkedList<>();
        this.max = maxNumbers;
        init();
    }

    private void init() {
        for (int i = 0; i < max; ++i) {
            unused.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (unused.isEmpty()) return -1;
        int res = unused.poll();
        used.add(res);
        return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return number < max && !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.contains(number)) {
            used.remove(number);
            unused.offer(number);
        }
    }
}
