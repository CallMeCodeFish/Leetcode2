package newquestion.day29;

/**
 * @author Heng Yu
 * @date 6/4/20 5:51 PM
 */

/**
 * leetcode 780 Reaching points
 * solution: work backwords
 * ref: https://www.youtube.com/watch?v=1E39PiQAGvE
 */
public class ReachingPoints {
    public static void main(String[] args) {
        ReachingPoints solution = new ReachingPoints();
        boolean result = solution.reachingPoints(35, 13, 455955547, 420098884);
        System.out.println(result);
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return false;
        if (sx == tx) return (ty - sy) % tx == 0;
        if (sy == ty) return (tx - sx) % ty == 0;

        if (tx > ty) return reachingPoints(sx, sy, tx - ty, ty);
        else if (tx < ty) return reachingPoints(sx, sy, tx, ty - tx);
        else return false;
    }
}
