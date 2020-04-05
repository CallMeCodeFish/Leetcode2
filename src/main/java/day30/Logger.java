package day30;

/**
 * @author Heng Yu
 * @date 4/4/20 9:58 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 359: Logger Rate Limiter
 */

public class Logger {
    private Map<String, Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
        this.map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            int lastTime = map.get(message);
            if (timestamp - lastTime < 10) return false;
            map.replace(message, timestamp);
            return true;
        }
    }
}
