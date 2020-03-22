package contest.mar21;

/**
 * @author Heng Yu
 * @date 3/22/20 12:10 AM
 */

/**
 * leetcode 1391: Check if There is a Valid path in a Grid
 */

public class CheckValidPath {
    public static void main(String[] args) {
        CheckValidPath solution = new CheckValidPath();
        int[][] grid = new int[][]{{4, 1}, {6, 1}};
        boolean result = solution.hasValidPath(grid);
        System.out.println(result);
    }

    public boolean hasValidPath(int[][] grid) {
        if (grid[0][0] == 5) return false;

        char[] dir = new char[]{'r'};
        if (grid[0][0] == 2 || grid[0][0] == 3) {
            dir[0] = 'd';
            return helper(grid, 0, 0, dir);
        } else if (grid[0][0] == 1 || grid[0][0] == 6) {
            return helper(grid, 0, 0, dir);
        } else {
            if (helper(grid, 0, 0, dir)) return true;
            dir[0] = 'd';
            return helper(grid, 0, 0, dir);
        }
    }

    private boolean helper(int[][] grid, int i, int j, char[] dir) {
        int m = grid.length;
        int n = grid[0].length;
        //edge case
        if (i == m - 1 && j == n - 1) return true;

        if (dir[0] == 'u') {
            --i;
            if (i < 0) return false;
        } else if (dir[0] == 'd') {
            ++i;
            if (i >= m) return false;
        } else if (dir[0] == 'l') {
            --j;
            if (j < 0) return false;
        } else {
            ++j;
            if (j >= n) return false;
        }
        if (!nextPosition(dir, grid[i][j])) return false;
        return helper(grid, i, j, dir);
    }

    private boolean nextPosition(char[] dir, int type) {
        if (dir[0] == 'u') {
            if (type == 2) {
                dir[0] = 'u';
            } else if (type == 3) {
                dir[0] = 'l';
            } else if (type == 4) {
                dir[0] = 'r';
            } else {
                return false;
            }
        } else if (dir[0] == 'd') {
            if (type == 2) {
                dir[0] = 'd';
            } else if (type == 5) {
                dir[0] = 'l';
            } else if (type == 6) {
                dir[0] = 'r';
            } else {
                return false;
            }
        } else if (dir[0] == 'l') {
            if (type == 1) {
                dir[0] = 'l';
            } else if (type == 4) {
                dir[0] = 'd';
            } else if (type == 6) {
                dir[0] = 'u';
            } else {
                return false;
            }
        } else {
            if (type == 1) {
                dir[0] = 'r';
            } else if (type == 3) {
                dir[0] = 'd';
            } else if (type == 5) {
                dir[0] = 'u';
            } else {
                return false;
            }
        }
        return true;
    }
}
