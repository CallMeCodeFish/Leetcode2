package newquestion.day10;

/**
 * @author Heng Yu
 * @date 5/7/20 3:02 PM
 */

import java.util.*;

/**
 * leetcode 692: Top k frequent words
 */
public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();
        String[] words = {"aaa", "aa", "a"};
        List<String> result = solution.topKFrequent(words, 1);
        System.out.println(result);
    }

    private static class Word {
        String word;
        int count;

        public Word(String word) {
            this.word = word;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Word> map = new HashMap<>();
        PriorityQueue<Word> heap = new PriorityQueue<>(words.length, (a, b) -> {
            if (a.count != b.count) {
                return b.count - a.count;
            }

            return a.word.compareTo(b.word);
        });

        for (String w : words) {
            if (!map.containsKey(w)) {
                Word word = new Word(w);
                map.put(w, word);
            }

            Word word = map.get(w);
            ++word.count;
        }

        for (Word word : map.values()) {
            heap.offer(word);
        }

        while (!heap.isEmpty()) {
            if (k == 0) break;
            res.add(heap.poll().word);
            --k;
        }

        return res;
    }
}
