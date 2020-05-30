package hard;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/29/20 5:31 PM
 */

/**
 * leetcode 126: Word ladder II
 */
public class WordLadderII {
    public static void main(String[] args) {
        WordLadderII solution = new WordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> result = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }

    private static class WordNode {
        String word;
        WordNode parent;

        public WordNode(String word, WordNode parent) {
            this.word = word;
            this.parent = parent;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> wordToPatterns = new HashMap<>();
        Map<String, List<String>> patternToWords = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>(); // 0 -> unvisited; 1 -> visited

        visited.put(beginWord, false);
        List<String> beginWordPatterns = getWordPatterns(beginWord);
        wordToPatterns.put(beginWord, beginWordPatterns);
        for (String p : beginWordPatterns) {
            if (!patternToWords.containsKey(p)) patternToWords.put(p, new ArrayList<>());
        }


        for (String word : wordList) {
            visited.put(word, false);
            List<String> patterns = getWordPatterns(word);
            wordToPatterns.put(word, patterns);
            for (String pattern : patterns) {
                if (!patternToWords.containsKey(pattern)) patternToWords.put(pattern, new ArrayList<>());
                patternToWords.get(pattern).add(word);
            }
        }

        // BFS
        WordNode beginNode = new WordNode(beginWord, null);
        Queue<WordNode> q = new LinkedList<>();
        q.offer(beginNode);
        List<WordNode> endNodes = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            boolean canStop = false;

            for (int i = 0; i < size; i++) {
                WordNode currNode = q.poll();
                // mark as visited
                visited.replace(currNode.word, true);

                // see if the current word is the end word
                if (endWord.equals(currNode.word)) {
                    canStop = true;
                    endNodes.add(currNode);
                }

                // add unvisited words in the next round into queue
                if (wordToPatterns.containsKey(currNode.word)) {
                    List<String> currPatterns = wordToPatterns.get(currNode.word);
                    for (String cp : currPatterns) {
                        List<String> nextWords = patternToWords.get(cp);
                        for (String nextWord : nextWords) {
                            if (!visited.get(nextWord)) {
                                WordNode nextNode = new WordNode(nextWord, currNode);
                                q.offer(nextNode);
                            }
                        }
                    }
                }
            }

            if (canStop) break;
        }

        List<List<String>> res = new ArrayList<>();

        if (!endNodes.isEmpty()) {
            for (WordNode endNode : endNodes) {
                WordNode currNode = endNode;
                List<String> list = new LinkedList<>();
                while (currNode != null) {
                    list.add(0, currNode.word);
                    currNode = currNode.parent;
                }
                res.add(list);
            }
        }

        return res;
    }

    private List<String> getWordPatterns(String word) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
            res.add(pattern);
        }

        return res;
    }
}
