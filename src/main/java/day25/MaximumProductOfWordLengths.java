package day25;

/**
 * @author Heng Yu
 * @date 3/23/20 8:42 PM
 */

/**
 * leetcode 318: Maximum of Word Lengths
 */

public class MaximumProductOfWordLengths {
    public static void main(String[] args) {
        MaximumProductOfWordLengths solution = new MaximumProductOfWordLengths();
        String[] words = new String[]{"a","aa","aaa","aaaa"};
        int result = solution.maxProduct(words);
        System.out.println(result);
    }

    public int maxProduct(String[] words) {
        //edge case
        if (words == null || words.length < 2) return 0;

        int len = words.length;
        int[] alphabet = new int[len];
        for (int i = 0; i < len; ++i) {
            String word = words[i];
            for (int j = 0; j < word.length(); ++j) {
                int shift = word.charAt(j) - 'a';
                alphabet[i] |= 1 << shift;
            }
        }
        int res = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if ((alphabet[i] & alphabet[j]) == 0) {
                    int cur = words[i].length() * words[j].length();
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }
}
