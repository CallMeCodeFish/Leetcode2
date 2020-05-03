package contest.May2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 5/2/20 10:30 PM
 */


public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> starts = new HashSet<>();
        Set<String> ends = new HashSet<>();

        for (List<String> path : paths) {
            starts.add(path.get(0));
            ends.add(path.get(1));
        }

        String res = null;

        for (String end : ends) {
            if (!starts.contains(end)) {
                res = end;
            }
        }

        return res;
    }
}
