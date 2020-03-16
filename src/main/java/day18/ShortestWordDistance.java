package day18;

/**
 * @author Heng Yu
 * @date 3/15/20 9:11 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 243: Shortest Word Distance
 */

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> indices1 = new ArrayList<>();
        List<Integer> indices2 = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (word1.equals(word)) {
                indices1.add(i);
            } else if (word2.equals(word)) {
                indices2.add(i);
            }
        }
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < indices1.size() && j < indices2.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j);
            if (index1 < index2) {
                res = Math.min(res, index2 - index1);
                ++i;
            } else {
                res = Math.min(res, index1 - index2);
                ++j;
            }
        }
        while (i < indices1.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(indices2.size() - 1);
            if (index1 < index2) {
                res = Math.min(res, index2 - index1);
                ++i;
            } else {
                break;
            }
        }
        while (j < indices2.size()) {
            int index1 = indices1.get(indices1.size() - 1);
            int index2 = indices2.get(j);
            if (index1 < index2) {
                break;
            } else {
                res = Math.min(res, index1 - index2);
                ++j;
            }
        }
        return res;
    }
}
