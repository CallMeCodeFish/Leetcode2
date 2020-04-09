package day32;

/**
 * @author Heng Yu
 * @date 4/8/20 7:51 PM
 */

import java.util.*;

/**
 * leetcode 380: Insert Delete GetRandom O(1)
 */

public class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet solution = new RandomizedSet();
        solution.insert(0);
        solution.insert(1);
        solution.remove(0);
        solution.insert(2);
        solution.remove(1);
        int result = solution.getRandom();
        System.out.println(result);
    }

    private List<Integer> list;
    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.remove(val);
        list.set(index, list.get(list.size() - 1));
        map.replace(list.get(index), index);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }
}
