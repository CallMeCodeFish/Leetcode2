package day22;

/**
 * @author Heng Yu
 * @date 3/19/20 4:15 PM
 */

/**
 * leetcode 286: Walls and Gates
 */

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        //edge case
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) dfs(rooms, i, j);
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j) {
        int m = rooms.length;
        int n = rooms[0].length;
        int d = rooms[i][j] + 1;
        if (i - 1 >= 0 && d < rooms[i - 1][j]) {
            rooms[i - 1][j] = d;
            dfs(rooms, i - 1, j);
        }
        if (i + 1 < m && d < rooms[i + 1][j]) {
            rooms[i + 1][j] = d;
            dfs(rooms, i + 1, j);
        }
        if (j - 1 >= 0 && d < rooms[i][j - 1]) {
            rooms[i][j - 1] = d;
            dfs(rooms, i, j - 1);
        }
        if (j + 1 < n && d < rooms[i][j + 1]) {
            rooms[i][j + 1] = d;
            dfs(rooms, i, j + 1);
        }
    }
}
