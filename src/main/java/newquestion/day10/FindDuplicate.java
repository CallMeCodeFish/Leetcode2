package newquestion.day10;

/**
 * @author Heng Yu
 * @date 5/7/20 3:39 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 609: Find duplicate file in system
 */
public class FindDuplicate {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String path : paths) {
            String[] splits = path.split(" ");
            String prefix = splits[0];
            for (int i = 1; i < splits.length; ++i) {
                String fileAndContent = splits[i];
                int index = fileAndContent.indexOf('(');
                String filename = fileAndContent.substring(0, index);
                String content = fileAndContent.substring(index + 1, fileAndContent.length() - 1);
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                StringBuilder sb = new StringBuilder();
                sb.append(prefix);
                sb.append("/");
                sb.append(filename);
                list.add(sb.toString());
                map.put(content, list);
            }
        }

        for (List<String> list : map.values()) {
            if (list.size() > 1) res.add(list);
        }

        return res;
    }
}
