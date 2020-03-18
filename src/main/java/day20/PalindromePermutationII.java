package day20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/17/20 9:58 PM
 */

/**
 * leetcode 267: Palindrome Permutation II
 */

public class PalindromePermutationII {
    public static void main(String[] args) {
        PalindromePermutationII solution = new PalindromePermutationII();
        List<String> result = solution.generatePalindromes("aaa");
        System.out.println(result);
    }

    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 2) {
            res.add(s);
            return res;
        }
        char[] chs = s.toCharArray();
        int[] freq = new int[128];
        for (char c : chs) {
            ++freq[c];
        }
        int count = 0;
        for (int n : freq) {
            if (n % 2 != 0) ++count;
        }
        if (count > 1) return res;
        char[] cur = new char[s.length()];
        backtrack(freq, cur, 0, cur.length - 1, res);
        return res;
    }

    private void backtrack(int[] freq, char[] cur, int l, int r, List<String> res) {
        //edge case
        if (r < l) {
            res.add(String.valueOf(cur));
            return;
        }
        if (l == r) {
            for (int i = 0; i < freq.length; ++i) {
                int count = freq[i];
                if (count != 0) {
                    cur[l] = (char) i;
                    break;
                }
            }
            res.add(String.valueOf(cur));
            return;
        }

        for (int i = 0; i < freq.length; ++i) {
            int count = freq[i];
            if (count > 1) {
                char ch = (char) i;
                cur[l] = cur[r] = ch;
                freq[i] -= 2;
                backtrack(freq, cur, l + 1, r - 1, res);
                freq[i] += 2;
            }
        }
    }
}
