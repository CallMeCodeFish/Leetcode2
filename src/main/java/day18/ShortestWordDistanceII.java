package day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 3/15/20 9:29 PM
 */


public class ShortestWordDistanceII {
    private Map<String, List<Integer>> map;

    public ShortestWordDistanceII(String[] words) {
        this.map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (!this.map.containsKey(word)) {
                this.map.put(word, new ArrayList<>());
            }
            this.map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indices1 = map.get(word1);
        List<Integer> indices2 = map.get(word2);
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
