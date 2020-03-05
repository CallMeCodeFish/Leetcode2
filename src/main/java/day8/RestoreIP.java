package day8;

/**
 * @author Heng Yu
 * @date 3/4/20 5:39 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 93: Restore IP Address
 */

public class RestoreIP {
    public static void main(String[] args) {
        RestoreIP solution = new RestoreIP();
        List<String> result = solution.restoreIpAddresses("1111");
        System.out.println(result);
    }

    public List<String> restoreIpAddresses(String s) {
        //edge case
        if (s == null || s.isEmpty()) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        char[] chs = s.toCharArray();
        backtrack(chs, 0, res, new ArrayList<>(), 4);
        return res;
    }

    private void backtrack(char[] s, int i, List<String> res, List<Integer> cur, int total) {
        //edge case
        int len = s.length - i;
        if (len < total || total * 3 < len) return;

        if (total == 0) {
            StringBuilder sb = new StringBuilder();
            for (int num : cur) {
                sb.append(num);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        int first = s[i] - '0';
        cur.add(first);
        backtrack(s, i + 1, res, cur, total - 1);
        cur.remove(cur.size() - 1);
        if (0 < first && i + 1 < s.length) {
            int second = s[i + 1] - '0';
            int sum = first * 10 + second;
            cur.add(sum);
            backtrack(s, i + 2, res, cur, total - 1);
            cur.remove(cur.size() - 1);
            if (i + 2 < s.length && sum <= 25) {
                int third = s[i + 2] - '0';
                sum = sum * 10 + third;
                if (sum <= 255) {
                    cur.add(sum);
                    backtrack(s, i + 3, res, cur, total - 1);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
