package newquestion.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Heng Yu
 * @date 5/19/20 3:04 PM
 */

/**
 * leetcode 1229: Meeting scheduler
 */
public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int len1 = slots1.length;
        int len2 = slots2.length;
        int len = len1 + len2;
        int[][] slots = new int[len][];

        int k = 0;
        for (int[] slot : slots1) {
            slots[k++] = slot;
        }
        for (int[] slot : slots2) {
            slots[k++] = slot;
        }

        Arrays.sort(slots, (a, b) -> a[0] - b[0]);

        List<Integer> res = new ArrayList<>();
        int maxEnd = -1;

        for (int[] slot : slots) {
            if (slot[0] < maxEnd) {
                int d = Math.min(maxEnd, slot[1]) - slot[0];
                if (d >= duration) {
                    res = Arrays.asList(slot[0], slot[0] + duration);
                    break;
                }
            }
            maxEnd = Math.max(maxEnd, slot[1]);
        }

        return res;
    }

    public List<Integer> minAvailableDuration1(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res = new ArrayList<>();

        List<int[]> list = new ArrayList<>();

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int[] slot : slots1) {
            int start = slot[0];
            int end = slot[1];
            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());
            map.get(start).add(slot);
            map.get(end).add(slot);
        }

        for (int[] slot : slots2) {
            int start = slot[0];
            int end = slot[1];
            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());
            map.get(start).add(slot);
            map.get(end).add(slot);
        }

        for (int key : map.keySet()) {
            List<int[]> slots = map.get(key);
            for (int[] slot : slots) {
                if (key == slot[0]) {
                    list.add(slot);
                } else {
                    list.remove(slot);
                }
            }

            if (list.size() == 2) {
                int[] s1 = list.get(0);
                int[] s2 = list.get(1);
                int start = Math.max(s1[0], s2[0]);
                int end = Math.min(s1[1], s2[1]);
                if (end - start >= duration) {
                    res.add(start);
                    res.add(start + duration);
                    break;
                }
            }
        }

        return res;
    }
}
