package newquestion.day7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/2/20 7:18 PM
 */

/**
 * leetcode 438: Find all anagrams in a string
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        //edge case
        if (p.length() > s.length()) return new ArrayList<>();

        int[] pattern = new int[26];
        for (char c : p.toCharArray()) {
            ++pattern[c - 'a'];
        }

        int[] text = new int[26];
        int i = 0, j = 0;
        char[] chs = s.toCharArray();
        boolean flag = false;
        List<Integer> res = new ArrayList<>();

        while (j < chs.length) {
            char c = chs[j];
            ++text[c - 'a'];
            if (j - i + 1 == p.length()) {
                if (flag) {
                    if (chs[i - 1] == chs[j]) {
                        res.add(i);
                    } else {
                        flag = false;
                    }
                } else {
                    flag = true;
                    for (int k = 0; k < 26; ++k) {
                        if (text[k] != pattern[k]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        res.add(i);
                    }
                }
                --text[chs[i] - 'a'];
                ++i;
            }
            ++j;
        }

        return res;
    }
}
