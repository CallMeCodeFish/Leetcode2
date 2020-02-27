package day1;

/**
 * @author Heng Yu
 * @date 2/26/20 10:08 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 9: Palindrome Number
 *
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        if (x == 0)
            return true;

        List<Integer> digits = new ArrayList<>();
        while (x != 0) {
            digits.add(x % 10);
            x /= 10;
        }
        int i = 0;
        int j = digits.size() - 1;
        while (i <= j) {
            if (!digits.get(i).equals(digits.get(j))) return false;
            ++i;
            --j;
        }
        return true;
    }
}
