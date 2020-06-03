package newquestion.day27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heng Yu
 * @date 6/2/20 5:40 pm
 */


/**
 * leetcode 158 Read N characters
 */
public class ReadNCharacters {
    private final Queue<Character> q = new LinkedList<>();
    private boolean isEnded = false;
    private final char[] buf4 = new char[4];

    public int read(char[] buf, int n) {
        if (n == 0 || isEnded) return 0;

        int res = readHelper(buf, n);

        if (res == 0) isEnded = true;

        return res;
    }

    private int readHelper(char[] buf, int n) {
        int j = 0;

        if (!q.isEmpty()) {
            while (!q.isEmpty()) {
                if (n == 0) break;
                buf[j++] = q.poll();
                n--;
            }
            if (n == 0) return j;
        }

        while (n > 0) {
            int r = read4(buf4);
            if (r == 0) break;
            if (n < r) {
                for (int i = 0; i < n; i++) {
                    buf[j++] = buf4[i];
                }
                for (int i = n; i < r; i++) {
                    q.offer(buf4[i]);
                }
                n = 0;
            } else {
                for (int i = 0; i < r; i++) {
                    buf[j++] = buf4[i];
                }
                n -= r;
            }
        }

        return j;
    }

    private int read4(char[] buf) {
        return (int) (Math.random() * 5);
    }
}
