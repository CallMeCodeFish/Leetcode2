package day22;

import java.util.Iterator;

/**
 * @author Heng Yu
 * @date 3/19/20 3:51 PM
 */

/**
 * leetcode 284: Peeking Iterator
 */

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer peek;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.peek = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == null) {
            peek = iterator.next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = null;
        if (peek != null) {
            res = peek;
            peek = null;
        } else {
            res = iterator.next();
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return peek != null || iterator.hasNext();
    }
}
