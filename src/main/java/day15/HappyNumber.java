package day15;

/**
 * @author Heng Yu
 * @date 3/12/20 10:54 PM
 */

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 202: Happy Number
 */

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        boolean result = solution.isHappy(19);
        System.out.println(result);
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        boolean res = false;
        while (true) {
            if (set.contains(n)) break;
            set.add(n);
            int next = 0;
            while (0 < n) {
                int digit = n % 10;
                next += digit * digit;
                n /= 10;
            }
            if (next == 1) {
                res = true;
                break;
            }
            n = next;
        }
        return res;
    }
}
