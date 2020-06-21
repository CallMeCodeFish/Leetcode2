package newquestion.day39;

/**
 * @author Heng Yu
 * @date 6/20/20 6:39 PM
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * leetcode 752: Open the lock
 */
public class OpenTheLock {
    public static void main(String[] args) {
        OpenTheLock solution = new OpenTheLock();
        String[] deadends = {"8888"};
        int result = solution.openLock(deadends, "0009");
        System.out.println(result);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> seen = new HashSet<>();
        for (String d : deadends) {
            seen.add(d);
        }

        if (seen.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        seen.add("0000");
        int res = 1;

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                String poll = q.poll();
                String[] next = getNext(poll);
                for (String s : next) {
                    if (!seen.contains(s)) {
                        if (target.equals(s)) return res;
                        seen.add(s);
                        q.offer(s);
                    }
                }
            }

            res++;
        }

        return -1;
    }

    private String[] getNext(String s) {
        String[] res = new String[2 * s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String prefix = s.substring(0, i);
            String suffix = s.substring(i + 1);
            if (c == '0') {
                StringBuilder sb = new StringBuilder();
                sb.append(prefix);
                sb.append('9');
                sb.append(suffix);
                res[j++] = sb.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(prefix);
                sb.append((char) (c - 1));
                sb.append(suffix);
                res[j++] = sb.toString();
            }

            if (c == '9') {
                StringBuilder sb = new StringBuilder();
                sb.append(prefix);
                sb.append('0');
                sb.append(suffix);
                res[j++] = sb.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(prefix);
                sb.append((char) (c + 1));
                sb.append(suffix);
                res[j++] = sb.toString();
            }
        }

        return res;
    }
}
