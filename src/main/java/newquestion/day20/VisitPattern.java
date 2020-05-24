package newquestion.day20;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/23/20 4:28 PM
 */

/**
 * leetcode 1152: Analyze user website pattern
 */
public class VisitPattern {
    public static void main(String[] args) {
        VisitPattern solution = new VisitPattern();
        String[] username = {"zkiikgv","zkiikgv","zkiikgv","zkiikgv"};
        int[] timestamp = {436363475,710406388,386655081,797150921};
        String[] website = {"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"};
        List<String> result = solution.mostVisitedPattern(username, timestamp, website);
        System.out.println(result);
    }

    private static class Visit {
        String user;
        int timestamp;
        String website;

        public Visit(String user, int timestamp, String website) {
            this.user = user;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int len = username.length;
        Visit[] visits = new Visit[len];
        for (int i = 0; i < len; ++i) {
            visits[i] = new Visit(username[i], timestamp[i], website[i]);
        }

        Arrays.sort(visits, (a, b) -> a.timestamp - b.timestamp);

        Map<String, List<String>> map = new HashMap<>();

        for (Visit visit : visits) {
            if (!map.containsKey(visit.user)) map.put(visit.user, new ArrayList<>());
            map.get(visit.user).add(visit.website);
        }

        Map<String, Integer> count = new HashMap<>();

        for (String user : map.keySet()) {
            List<String> list = map.get(user);
            int size = list.size();
            Set<String> seen = new HashSet<>();
            for (int i = 0; i < size; ++i) {
                for (int j = i + 1; j < size; ++j) {
                    for (int k = j + 1; k < size; ++k) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(list.get(i));
                        sb.append(',');
                        sb.append(list.get(j));
                        sb.append(',');
                        sb.append(list.get(k));
                        String s = sb.toString();
                        if (!seen.contains(s)) {
                            seen.add(s);
                            count.put(s, count.getOrDefault(s, 0) + 1);
                        }
                    }
                }
            }
        }

        int max = 0;
        for (String s : count.keySet()) {
            max = Math.max(max, count.get(s));
        }

        List<String> list = new ArrayList<>();

        for (String s : count.keySet()) {
            if (max == count.get(s)) list.add(s);
        }

        list.sort(String::compareTo);

        String[] splits = list.get(0).split(",");

        List<String> res = new ArrayList<>();
        for (String split : splits) {
            res.add(split);
        }

        return res;
    }
}
