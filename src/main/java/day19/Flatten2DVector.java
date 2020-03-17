package day19;

/**
 * @author Heng Yu
 * @date 3/16/20 6:26 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 251: Flatten 2D Vector
 */

public class Flatten2DVector {
    private List<Integer> list;
    private int top;

    public Flatten2DVector(int[][] v) {
        this.list = new ArrayList<>();
        for (int[] row : v) {
            for (int num : row) {
                this.list.add(num);
            }
        }
        this.top = 0;
    }

    public int next() {
        return list.get(top++);
    }

    public boolean hasNext() {
        return top < list.size();
    }
}
