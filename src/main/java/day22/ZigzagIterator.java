package day22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/19/20 1:18 PM
 */

/**
 * leetcode 281 Zigzag Iterator
 */

public class ZigzagIterator {
    private List<Integer> list;
    private int top;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.list = new ArrayList<>();
        this.top = 0;
        int i = 0;
        int j = 0;
        while (i < v1.size() && j < v2.size()) {
            this.list.add(v1.get(i++));
            this.list.add(v2.get(j++));
        }
        while (i < v1.size()) {
            this.list.add(v1.get(i++));
        }
        while (j < v2.size()) {
            this.list.add(v2.get(j++));
        }
    }

    public int next() {
        return list.get(top++);
    }

    public boolean hasNext() {
        return top < list.size();
    }
}
