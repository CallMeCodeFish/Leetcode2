package newquestion.day46;

import java.util.*;

/**
 * @author Heng Yu
 * @date 7/2/20 10:18 PM
 */

/**
 * leetcode 305: Number of Islands II
 * solution: union find
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        Map<Integer, Integer> mapping = new HashMap<>();
        Map<Integer, List<Integer>> roots = new HashMap<>();

        int gid = 0, cid = 0;

        List<Integer> res = new ArrayList<>();

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            if (groups.containsKey(x) && groups.get(x).containsKey(y)) {
                res.add(roots.size());
                continue;
            }
            List<Integer> l = new ArrayList<>();

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (groups.containsKey(nx) && groups.get(nx).containsKey(ny)) {
                    l.add(groups.get(nx).get(ny));
                }
            }

            if (l.isEmpty()) {
                groups.putIfAbsent(x, new HashMap<>());
                groups.get(x).put(y, gid);
                mapping.put(gid, cid);
                List<Integer> list = new ArrayList<>();
                list.add(gid);
                roots.put(cid, list);
                gid++;
                cid++;
            } else {
                int groupId = l.get(0);
                int componentId = mapping.get(groupId);
                for (int i = 1; i < l.size(); i++) {
                    int c = mapping.get(l.get(i));
                    if (c != componentId) {
                        List<Integer> list = roots.get(c);
                        for (int g : list) {
                            mapping.replace(g, componentId);
                            roots.get(componentId).add(g);
                        }
                        roots.remove(c);
                    }
                }
                groups.putIfAbsent(x, new HashMap<>());
                groups.get(x).put(y, groupId);
            }
            res.add(roots.size());
        }

        return res;
    }
}
