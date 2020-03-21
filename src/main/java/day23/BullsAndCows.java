package day23;

/**
 * @author Heng Yu
 * @date 3/20/20 3:52 PM
 */

/**
 * leetcode 299: Bulls and Cows
 */

public class BullsAndCows {
    public static void main(String[] args) {
        BullsAndCows solution = new BullsAndCows();
        String secret = "1123";
        String guess = "0111";
        String result = solution.getHint(secret, guess);
        System.out.println(result);
    }

    public String getHint(String secret, String guess) {
        int[] freq = new int[10];
        char[] chs1 = secret.toCharArray();
        char[] chs2 = guess.toCharArray();
        int cows = 0;
        int bulls = 0;
        int len = secret.length();
        boolean[] visited = new boolean[len];
        for (char c : chs1) {
            ++freq[c - '0'];
        }
        for (int i = 0; i < len; ++i) {
            char c = chs2[i];
            if (c == chs1[i]) {
                ++bulls;
                --freq[c - '0'];
                visited[i] = true;
            }
        }
        for (int i = 0; i < len; ++i) {
            if (!visited[i]) {
                char c = chs2[i];
                if (freq[c - '0'] > 0) {
                    ++cows;
                    --freq[c - '0'];
                    visited[i] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append('A');
        sb.append(cows);
        sb.append('B');
        return sb.toString();
    }
}
