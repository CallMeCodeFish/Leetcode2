package newquestion.day20;

/**
 * @author Heng Yu
 * @date 5/23/20 6:44 PM
 */

import java.util.Arrays;

/**
 * leetcode 593: Valid square
 */
public class ValidSquare {
    public static void main(String[] args) {
        ValidSquare solution = new ValidSquare();
        int[] p1 = {1,0};
        int[] p2 = {-1,0};
        int[] p3 = {0,1};
        int[] p4 = {0,-1};
        boolean result = solution.validSquare(p1, p2, p3, p4);
        System.out.println(result);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[4][];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;

        Arrays.sort(points, (a, b) -> (a[0] != b[0])? a[0] - b[0] : a[1] - b[1]);

        int[] vLeft = new int[]{points[0][0] - points[2][0], points[0][1] - points[2][1]};
        int[] vRight = new int[]{points[1][0] - points[3][0], points[1][1] - points[3][1]};
        int[] hTop = new int[]{points[0][0] - points[1][0], points[0][1] - points[1][1]};
        int[] hBottom = new int[]{points[2][0] - points[3][0], points[2][1] - points[3][1]};

        if (!(isPerpendicular(hTop, vLeft) && isPerpendicular(hTop, vRight) && isPerpendicular(hBottom, vLeft) && isPerpendicular(hBottom, vRight))) return false;

        return getEdgeLengthSquare(points[0], points[1]) == getEdgeLengthSquare(points[0], points[2]);
    }

    private boolean isPerpendicular(int[] l1, int[] l2) {
        if (l1[0] == 0 && l1[1] == 0 || l2[0] == 0 && l2[1] == 0) return false;
        return 0 == l1[0] * l2[0] + l1[1] * l2[1];
    }

    private int getEdgeLengthSquare(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
