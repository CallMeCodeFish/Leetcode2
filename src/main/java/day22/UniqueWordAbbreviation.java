package day22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 3/19/20 5:29 PM
 */


public class UniqueWordAbbreviation {
    private Map<String, Set<String>> map;

    public UniqueWordAbbreviation(String[] dictionary) {
        this.map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = getAbbreviation(word);
            if (!map.containsKey(abbr)) {
                map.put(abbr, new HashSet<>());
            }
            map.get(abbr).add(word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        if (!map.containsKey(abbr)) return true;
        return map.get(abbr).size() == 1 && map.get(abbr).contains(word);
    }

    private String getAbbreviation(String word) {
        if (word.length() < 3) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}
