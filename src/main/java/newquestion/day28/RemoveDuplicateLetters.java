package newquestion.day28;

/**
 * @author Heng Yu
 * @date 6/3/20 3:57 PM
 */

import java.util.TreeSet;

/**
 * leetcode 316: Remove duplicate letters
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        String result = solution.removeDuplicateLetters("cbaddabaa");
        System.out.println(result);
    }

    public String removeDuplicateLetters(String s) {
        //edge case
        if (s.isEmpty()) return "";

        char[] chs = s.toCharArray();

        TreeSet<Integer>[] indices = new TreeSet[26];
        boolean[] visited = new boolean[26];
        int n = 0;

        for (int i = 0; i < chs.length; i++) {
            int idx = chs[i] - 'a';
            if (indices[idx] == null) {
                indices[idx] = new TreeSet<>();
                n++;
            }
            indices[idx].add(i);
        }

        int curIndex = -1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < indices.length; j++) {
                if (indices[j] != null && !visited[j]) {
                    int firstIndex = indices[j].higher(curIndex);
                    boolean isValid = true;
                    for (int k = 0; k < indices.length; k++) {
                        if (indices[k] != null && !visited[k]) {
                            if (indices[k].last() < firstIndex) {
                                isValid = false;
                                break;
                            }
                        }
                    }

                    if (isValid) {
                        char toAppend = (char) ('a' + j);
                        sb.append(toAppend);
                        curIndex = firstIndex;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        return sb.toString();
    }
}
