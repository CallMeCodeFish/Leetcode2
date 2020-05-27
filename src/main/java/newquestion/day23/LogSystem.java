package newquestion.day23;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/27/20 3:08 PM
 */

/**
 * leetcode 635: Design log storage system
 */
public class LogSystem {
    private static final String YEAR_START = "01:01:00:00:00";
    private static final String YEAR_END = "12:31:23:59:59";
    private static final String MONTH_START = "01:00:00:00";
    private static final String MONTH_END = "31:23:59:59";
    private static final String DAY_START = "00:00:00";
    private static final String DAY_END = "23:59:59";
    private static final String HOUR_START = "00:00";
    private static final String HOUR_END = "59:59";
    private static final String MINUTE_START = "00";
    private static final String MINUTE_END = "59";

    private TreeMap<String, List<Integer>> map;

    public LogSystem() {
        this.map = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        if (!map.containsKey(timestamp)) map.put(timestamp, new ArrayList<>());

        map.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        switch (gra) {
            case "Year":
                s = s.substring(0, 5) + YEAR_START;
                e = e.substring(0, 5) + YEAR_END;
                break;
            case "Month":
                s = s.substring(0, 8) + MONTH_START;
                e = e.substring(0, 8) + MONTH_END;
                break;
            case "Day":
                s = s.substring(0, 11) + DAY_START;
                e = e.substring(0, 11) + DAY_END;
                break;
            case "Hour":
                s = s.substring(0, 14) + HOUR_START;
                e = e.substring(0, 14) + HOUR_END;
                break;
            case "Minute":
                s = s.substring(0, 17) + MINUTE_START;
                e = e.substring(0, 17) + MINUTE_END;
                break;
            default:
                break;
        }

        Map<String, List<Integer>> subMap = map.subMap(s, true, e, true);

        List<Integer> res = new ArrayList<>();

        for (List<Integer> value : subMap.values()) {
            res.addAll(value);
        }

        return res;
    }
}
