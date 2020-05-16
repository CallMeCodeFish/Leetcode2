package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 5/15/20 5:51 PM
 */

/**
 * leetcode 336: Palindrome pairs
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words.length < 2) return new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];

            //reverse
            String reverseWord = new StringBuilder(word).reverse().toString();
            if (map.containsKey(reverseWord) && i != map.get(reverseWord)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(map.get(reverseWord));
                res.add(list);
            }

            char[] chs = word.toCharArray();

            //prefix palindrome
            for (int j = 0; j < chs.length; ++j) {
                boolean flag = true;
                int l = 0, r = j;
                while (l <= r) {
                    if (chs[l] != chs[r]) {
                        flag = false;
                        break;
                    }
                    ++l;
                    --r;
                }
                if (flag) {
                    String check = new StringBuilder(word.substring(j + 1)).reverse().toString();
                    if (map.containsKey(check)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(check));
                        list.add(i);
                        res.add(list);
                    }
                }
            }

            //suffix palindrome
            for (int j = chs.length - 1; j >= 0; --j) {
                boolean flag = true;
                int l = j, r = chs.length - 1;
                while (l <= r) {
                    if (chs[l] != chs[r]) {
                        flag = false;
                        break;
                    }
                    ++l;
                    --r;
                }
                if (flag) {
                    String check = new StringBuilder(word.substring(0, j)).reverse().toString();
                    if (map.containsKey(check)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(check));
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }
}
