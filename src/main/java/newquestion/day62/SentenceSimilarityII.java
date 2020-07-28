package newquestion.day62;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 7/27/20 8:13 PM
 */

/**
 * leetcode 737: Sentence similarity II
 * solution: union find
 */
public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        if (words1.length == 0) return true;

        Map<String, String> map = new HashMap<>();

        int len = words1.length;

        for (int i = 0; i < len; i++) {
            map.put(words1[i], words1[i]);
            map.put(words2[i], words2[i]);
        }

        for (List<String> pair : pairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);
            if (!map.containsKey(w1)) {
                map.put(w1, w1);
            }

            String p1 = w1;
            while (!map.get(p1).equals(p1)) {
                p1 = map.get(p1);
            }

            if (!map.containsKey(w2)) {
                map.put(w2, p1);
            } else {
                String p2 = w2;
                while (!map.get(p2).equals(p2)) {
                    p2 = map.get(p2);
                }
                map.put(p2, p1);
            }
        }

        for (int i = 0; i < len; i++) {
            String p1 = words1[i];
            String p2 = words2[i];
            while (!map.get(p1).equals(p1)) {
                p1 = map.get(p1);
            }
            while (!map.get(p2).equals(p2)) {
                p2 = map.get(p2);
            }
            if (!p1.equals(p2)) return false;
        }

        return true;
    }
}
