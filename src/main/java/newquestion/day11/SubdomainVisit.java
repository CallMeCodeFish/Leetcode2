package newquestion.day11;

/**
 * @author Heng Yu
 * @date 5/8/20 4:58 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 811: Subdomain visit count
 */
public class SubdomainVisit {
    public List<String> subdomainVisits(String[] domains) {
        Map<String, Integer> counts = new HashMap<>();

        for (String domain : domains) {
            String[] splits = domain.split(" ");
            int count = Integer.parseInt(splits[0]);
            String[] parts = splits[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = parts.length - 1; i >= 0; --i) {
                if (i != parts.length - 1) sb.insert(0, '.');
                sb.insert(0, parts[i]);
                String key = sb.toString();
                counts.put(key, counts.getOrDefault(key, 0) + count);
            }
        }

        List<String> res = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue());
            sb.append(' ');
            sb.append(entry.getKey());
            res.add(sb.toString());
        }

        return res;
    }
}
