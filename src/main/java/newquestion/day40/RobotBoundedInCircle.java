package newquestion.day40;

/**
 * @author Heng Yu
 * @date 6/21/20 6:19 PM
 */

/**
 * leetcode 1041: Robot bounded in a circle
 */
public class RobotBoundedInCircle {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int[] dir = dirs[0];
        char[] chs = instructions.toCharArray();

        for (int i = 0; i < 4; i++) {
            for (char ins : chs) {
                if ('G' == ins) {
                    x += dir[0];
                    y += dir[1];
                } else {
                    dir = getNextDir(dir, ins);
                }
            }
        }

        return x == 0 && y == 0;
    }

    private int[] getNextDir(int[] cur, char ins) {
        int[][] dirs = this.dirs;

        if (cur == dirs[0]) {
            return 'L' == ins ? dirs[3] : dirs[2];
        } else if (cur == dirs[1]) {
            return 'L' == ins ? dirs[2] : dirs[3];
        } else if (cur == dirs[2]) {
            return 'L' == ins ? dirs[0] : dirs[1];
        } else {
            return 'L' == ins ? dirs[1] : dirs[0];
        }
    }
}
