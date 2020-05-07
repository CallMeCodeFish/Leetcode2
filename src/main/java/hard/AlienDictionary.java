package hard;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/6/20 8:31 PM
 */

/**
 * leetcode 269: Alien dictionary
 * solution: topological sorting
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> ins = new HashMap<>();
        Map<Character, Set<Character>> outs = new HashMap<>();

        int total = 0;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!ins.containsKey(c)) {
                    ins.put(c, new HashSet<>());
                    outs.put(c, new HashSet<>());
                    ++total;
                }
            }
        }

        for (int i = 0; i < words.length - 1; ++i) {
            char[] w1 = words[i].toCharArray();
            char[] w2 = words[i + 1].toCharArray();
            int j = 0, k = 0;
            while (j < w1.length && k < w2.length) {
                if (w1[j] != w2[k]) {
                    outs.get(w1[j]).add(w2[k]);
                    ins.get(w2[k]).add(w1[j]);
                    break;
                }
                ++j;
                ++k;
            }
            if (j < w1.length && k == w2.length) return "";
        }

        Queue<Character> q = new LinkedList<>();

        for (char c : ins.keySet()) {
            if (ins.get(c).isEmpty()) {
                q.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            count += size;
            for (int i = 0; i < size; ++i) {
                char poll = q.poll();
                sb.append(poll);
                Set<Character> out = outs.get(poll);
                for (char next : out) {
                    Set<Character> nextIn = ins.get(next);
                    nextIn.remove(poll);
                    if (nextIn.isEmpty()) q.offer(next);
                }
            }
        }

        return (count == total)? sb.toString() : "";
    }
}
