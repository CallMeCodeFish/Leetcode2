package day19;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 3/16/20 4:23 PM
 */

/**
 * leetcode 246: Strobogrammatic Number
 */

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        //edge case
        if (num == null || num.isEmpty()) return true;

        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        char[] chs = num.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        while (i <= j) {
            if (!map.containsKey(chs[i]) || chs[j] != map.get(chs[i])) return false;
            ++i;
            --j;
        }
        return true;
    }
}
