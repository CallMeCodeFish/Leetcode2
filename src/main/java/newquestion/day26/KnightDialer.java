package newquestion.day26;

/**
 * @author Heng Yu
 * @date 6/1/20 2:16 PM
 */

/**
 * leetcode 935: Knight dialer
 */
public class KnightDialer {
    public static void main(String[] args) {
        KnightDialer solution = new KnightDialer();
        int result = solution.knightDialer(161);
        System.out.println(result);
    }

    public int knightDialer(int N) {
        final int MODULO = 1000_000_007;

        int[][] dp = new int[N][10];

        for (int i = 0; i < 10; i++) {
            dp[N - 1][i] = 1;
        }

        int[][] skipTable = new int[10][];

        skipTable[0] = new int[]{4, 6};
        skipTable[1] = new int[]{6, 8};
        skipTable[2] = new int[]{7, 9};
        skipTable[3] = new int[]{4, 8};
        skipTable[4] = new int[]{0, 3, 9};
        skipTable[5] = new int[]{};
        skipTable[6] = new int[]{0, 1, 7};
        skipTable[7] = new int[]{2, 6};
        skipTable[8] = new int[]{1, 3};
        skipTable[9] = new int[]{2, 4};

        for (int i = N - 2; i > -1; i--) {
            for (int j = 0; j < 10; j++) {
                int[] next = skipTable[j];
                for (int k : next) {
                    dp[i][j] += dp[i + 1][k];
                    dp[i][j] %= MODULO;
                }
            }
        }

        int res = 0;

        for (int i = 0; i < 10; i++) {
            res += dp[0][i];
            res %= MODULO;
        }

        return res;
    }
}
