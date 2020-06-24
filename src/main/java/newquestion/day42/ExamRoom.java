package newquestion.day42;

import java.util.*;

/**
 * @author Heng Yu
 * @date 6/23/20 9:28 PM
 */

/**
 * leetcode 855: Exam room
 */
public class ExamRoom {
    private List<Integer> list;
    private int capacity;

    public ExamRoom(int N) {
        list = new ArrayList<>();
        capacity = N;
    }

    public int seat() {
        if (list.isEmpty()) {
            list.add(0);
            return 0;
        }

        int max = 0;
        int index = -1;
        int res = -1;
        int l = 0, r = list.get(0);
        if (r - l > max) {
            max = r - l;
            index = l;
            res = 0;
        }

        for (int i = 1; i < list.size(); i++) {
            l = r;
            r = list.get(i);
            int mid = l + (r - l) / 2;
            int cur = mid - l;
            if (cur > max) {
                max = cur;
                index = i;
                res = mid;
            }
        }

        l = r;
        r = capacity - 1;
        if (r - l > max) {
            max = r - l;
            index = list.size();
            res = r;
        }

        list.add(index, res);

        return res;
    }

    public void leave(int p) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == p) {
                list.remove(i);
            }
        }
    }
}
