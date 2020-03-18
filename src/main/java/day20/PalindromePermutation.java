package day20;

/**
 * @author Heng Yu
 * @date 3/17/20 9:28 PM
 */


public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        //edge case
        if (s == null || s.isEmpty()) return true;

        char[] chs = s.toCharArray();
        int[] freq = new int[128];
        for (char c : chs) {
            ++freq[c];
        }
        int count = 0;
        for (int n : freq) {
            if (n % 2 == 1) ++count;
        }
        return count < 2;
    }
}
