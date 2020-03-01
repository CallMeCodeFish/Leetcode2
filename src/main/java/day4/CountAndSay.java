package day4;

/**
 * @author Heng Yu
 * @date 2/29/20 3:17 PM
 */

/**
 * leetcode 38: Count and Say
 */

public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        String result = solution.countAndSay(4);
        System.out.println(result);
    }

    public String countAndSay(int n) {
        return dfs(n);
    }

    private String dfs(int n) {
        //edge case
        if (n == 1) return "1";

        String s = dfs(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char cur = s.charAt(i);
            int count = 1;
            int j = i + 1;
            while (j < s.length() && cur == s.charAt(j)) {
                ++count;
                ++j;
            }
            sb.append(count);
            sb.append(cur);
            i = j;
        }
        return sb.toString();
    }
}
