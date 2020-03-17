package day19;

import java.util.*;

/**
 * @author Heng Yu
 * @date 3/16/20 5:33 PM
 */

/**
 * leetcode 249: Group Shifted Strings
 */

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, Map<String, List<String>>> map = new HashMap<>();
        for (String s : strings) {
            int len = s.length();
            if (!map.containsKey(len)) {
                map.put(len, new HashMap<>());
            }
            Map<String, List<String>> groups = map.get(len);
            if (groups.isEmpty()) {
                groups.put(s, new ArrayList<>());
                groups.get(s).add(s);
            } else {
                Set<String> formats = groups.keySet();
                String key = null;
                for (String format : formats) {
                    boolean flag = true;
                    int target = s.charAt(0) - format.charAt(0);
                    if (target < 0) target += 26;
                    for (int i = 1; i < format.length(); ++i) {
                        int dif = s.charAt(i) - format.charAt(i);
                        if (dif < 0) dif += 26;
                        if (target != dif) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        key = format;
                        break;
                    }
                }
                if (key != null) {
                    groups.get(key).add(s);
                } else {
                    groups.put(s, new ArrayList<>());
                    groups.get(s).add(s);
                }
            }
        }
        for (Map<String, List<String>> groups : map.values()) {
            res.addAll(groups.values());
        }
        return res;
    }
}
