package day29;

/**
 * @author Heng Yu
 * @date 4/1/20 10:41 PM
 */

/**
 * leetcode 351: Android Unlock Patterns
 */

public class AndroidUnlockPatterns {
    public static void main(String[] args) {
        AndroidUnlockPatterns solution = new AndroidUnlockPatterns();
        int result = solution.numberOfPatterns(3, 3);
        System.out.println(result);
    }

    public int numberOfPatterns(int m, int n) {
        int[][] bridge = new int[10][10];
        bridge[1][3] = bridge[3][1] = 2;
        bridge[1][7] = bridge[7][1] = 4;
        bridge[1][9] = bridge[9][1] = bridge[3][7] = bridge[7][3] = bridge[2][8] = bridge[8][2] = bridge[4][6] = bridge[6][4] = 5;
        bridge[3][9] = bridge[9][3] = 6;
        bridge[7][9] = bridge[9][7] = 8;
        boolean[] visited = new boolean[10];
        int res = 0;
        int[] count = {0};
        backtrack(bridge, visited, 1, m, n, 0, count);
        res += 4 * count[0];
        count[0] = 0;
        backtrack(bridge, visited, 2, m, n, 0, count);
        res += 4 * count[0];
        count[0] = 0;
        backtrack(bridge, visited, 5, m, n, 0, count);
        res += count[0];

        return res;
    }

    private void backtrack(int[][] bridge, boolean[] visited, int cur, int m, int n, int len, int[] res) {
        visited[cur] = true;
        ++len;
        if (m <= len && len <= n) {
            ++res[0];
            if (len == n) {
                visited[cur] = false;
                return;
            }
        }

        for (int next = 1; next <= 9; ++next) {
            if (next == cur) continue;
            int mid = bridge[cur][next];
            if (!visited[next] && (mid == 0 || visited[mid])) {
                backtrack(bridge, visited, next, m, n, len, res);
            }
        }
        visited[cur] = false;
    }
}
