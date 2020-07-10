package newquestion.day51;

/**
 * @author Heng Yu
 * @date 7/9/20 10:37 PM
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 489: Robot room cleaner
 * solution: dfs
 */
public class RobotRoomCleaner {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();

        int[] start = {0, 0};

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        robot.clean();
        visited.add(Arrays.toString(start));

        if (robot.move()) helper(robot, visited, start, dirs[1], dirs);

        robot.turnRight();
        if (robot.move()) helper(robot, visited, start, dirs[2], dirs);

        robot.turnRight();
        if (robot.move()) helper(robot, visited, start, dirs[0], dirs);

        robot.turnRight();
        if (robot.move()) helper(robot, visited, start, dirs[3], dirs);
    }

    private void helper(Robot robot, Set<String> visited, int[] position, int[] curDir, int[][] dirs) {
        position[0] += curDir[0];
        position[1] += curDir[1];

        String s = Arrays.toString(position);
        if (!visited.contains(s)) {
            visited.add(s);
            robot.clean();

            if (robot.move()) {
                helper(robot, visited, position, curDir, dirs);
            }

            //turn left
            robot.turnLeft();
            int[] leftDir = getNextDir(curDir, dirs, 'l');
            if (robot.move()) {
                helper(robot, visited, position, leftDir, dirs);
            }
            robot.turnRight();

            //turn right
            robot.turnRight();
            int[] rightDir = getNextDir(curDir, dirs, 'r');
            if (robot.move()) {
                helper(robot, visited, position, rightDir, dirs);
            }
            robot.turnLeft();
        }

        position[0] -= curDir[0];
        position[1] -= curDir[1];
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }

    private int[] getNextDir(int[] cur, int[][] dirs, char c) {
        if (cur == dirs[0]) {
            //down
            return c == 'l' ? dirs[2] : dirs[3];
        } else if (cur == dirs[1]) {
            //up
            return c == 'l' ? dirs[3] : dirs[2];
        } else if (cur == dirs[2]) {
            //right
            return c == 'l' ? dirs[1] : dirs[0];
        } else {
            //left
            return c == 'l' ? dirs[0] : dirs[1];
        }
    }
}

interface Robot {
    boolean move();

    void turnLeft();

    void turnRight();

    void clean();
}
