package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 4:36 PM
 */

import java.util.*;

/**
 * leetcode 71: Simplify Path
 */

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/a//b////c/d//././/..");
        System.out.println(result);
    }

    public String simplifyPath(String path) {
        String[] splits = path.split("/");
        List<String> list = new ArrayList<>();
        for (String s : splits) {
            if (!"".equals(s)) {
                if (!".".equals(s) && !"..".equals(s)) {
                    list.add(s);
                } else if ("..".equals(s)) {
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/");
            sb.append(s);
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
