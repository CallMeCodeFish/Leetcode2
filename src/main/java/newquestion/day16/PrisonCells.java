package newquestion.day16;

/**
 * @author Heng Yu
 * @date 5/15/20 2:39 PM
 */

import java.util.*;

/**
 * leetcode 957: Prison cells after N days
 */
public class PrisonCells {
    public static void main(String[] args) {
        PrisonCells solution = new PrisonCells();
        int[] cells = {0,1,0,1,1,0,0,1};
        int[] result = solution.prisonAfterNDays(cells, 15);
        System.out.println(Arrays.toString(result));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N <= 0) return cells;

        int prev = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < cells.length; ++i) {
            prev += cells[i] << (7 - i);
        }

        map.put(prev, list.size());
        list.add(prev);
        int startIndex = 0;

        for (int i = 1; i <= N; ++i) {
            int cur = 0;
            for (int j = 1; j < 7; ++j) {
                int d1 = prev >> (j - 1) & 1;
                int d2 = prev >> (j + 1) & 1;
                int d = (d1 == d2)? 1 : 0;
                cur += d << j;
            }

            prev = cur;
            if (map.containsKey(prev)) {
                startIndex = map.get(prev);
                break;
            }
            map.put(prev, list.size());
            list.add(prev);
        }

        int index = startIndex + (N - startIndex) % (list.size() - startIndex);
        int num = list.get(index);
        int[] res = new int[8];
        int i = 0;
        for (int j = 7; j >= 0; --j) {
            res[i++] = num >> j & 1;
        }

        return res;
    }
}
