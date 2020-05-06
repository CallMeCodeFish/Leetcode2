package newquestion.day8;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Heng Yu
 * @date 5/5/20 9:49 PM
 */


public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        TreeMap<Integer, String> timedValues = map.get(key);
        Map.Entry<Integer, String> entry = timedValues.floorEntry(timestamp);
        if (entry == null) return "";
        return entry.getValue();
    }
}
