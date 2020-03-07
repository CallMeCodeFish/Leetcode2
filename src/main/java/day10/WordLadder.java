package day10;

/**
 * @author Heng Yu
 * @date 3/6/20 4:48 PM
 */

import java.util.*;

/**
 * leetcode 127: Word Ladder
 */

public class WordLadder {
    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        String[] strs = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        int result = solution.ladderLength("hit", "cog", Arrays.asList(strs));
        System.out.println(result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String word : wordList) {
            List<String> patterns = getPatternList(word);
            for (String p : patterns) {
                if (!map.containsKey(p)) {
                    map.put(p, new HashSet<>());
                }
                map.get(p).add(word);
            }
        }
        boolean isExisted = false;
        for (String p : map.keySet()) {
            if (map.get(p).contains(endWord)) {
                isExisted = true;
                break;
            }
        }
        if (!isExisted) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(beginWord);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++res;
            for (int i = 0; i < size; ++i) {
                String poll = queue.poll();
                List<String> patterns = getPatternList(poll);
                for (String p : patterns) {
                    if (map.containsKey(p)) {
                        for (String neighbor : map.get(p)) {
                            if (!visited.contains(neighbor)) {
                                if (endWord.equals(neighbor)) {
                                    return res + 1;
                                }
                                visited.add(neighbor);
                                queue.offer(neighbor);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    private List<String> getPatternList(String word) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < word.length(); ++i) {
            StringBuilder sb = new StringBuilder();
            sb.append(word.substring(0, i));
            sb.append('.');
            sb.append(word.substring(i + 1));
            ret.add(sb.toString());
        }
        return ret;
    }
}
