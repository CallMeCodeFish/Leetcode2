package newquestion.day9;

/**
 * @author Heng Yu
 * @date 5/6/20 6:24 PM
 */

import java.util.PriorityQueue;

/**
 * leetcode 937: Reorder data in log files
 */
public class ReorderData {
    private static class Log {
        String identifier;
        String content;
        String log;

        public Log(String identifier, String content, String log) {
            this.identifier = identifier;
            this.content = content;
            this.log = log;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        int len = logs.length;
        String[] res = new String[len];
        boolean[] isDigit = new boolean[len];

        PriorityQueue<Log> heap = new PriorityQueue<>(100, (a, b) -> {
            int contentResult = a.content.compareTo(b.content);
            if (contentResult != 0) return contentResult;
            return a.identifier.compareTo(b.identifier);
        });

        for (int i = 0; i < len; ++i) {
            String log = logs[i];
            int index = log.indexOf(' ');
            if (Character.isLetter(log.charAt(index + 1))) {
                heap.offer(new Log(log.substring(0, index), log.substring(index + 1), log));
            } else {
                isDigit[i] = true;
            }
        }

        int j = 0;
        while (!heap.isEmpty()) {
            Log log = heap.poll();
            res[j++] = log.log;
        }

        for (int i = 0; i < len; ++i) {
            if (isDigit[i]) {
                res[j++] = logs[i];
            }
        }

        return res;
    }
}
