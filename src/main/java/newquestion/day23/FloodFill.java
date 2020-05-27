package newquestion.day23;

/**
 * @author Heng Yu
 * @date 5/27/20 2:30 PM
 */

/**
 * leetcode 733: Flood fill
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        dfs(image, sr, sc, oldColor, newColor, dirs);

        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor, int[][] dirs) {
        if (oldColor == newColor) return;

        image[x][y] = newColor;

        int m = image.length;
        int n = image[0].length;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && image[nx][ny] == oldColor) dfs(image, nx, ny, oldColor, newColor, dirs);
        }
    }
}
