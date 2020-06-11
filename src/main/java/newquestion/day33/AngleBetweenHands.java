package newquestion.day33;

/**
 * @author Heng Yu
 * @date 6/10/20 4:31 PM
 */

/**
 * leetcode 1344: Angle between hands of a clock
 */
public class AngleBetweenHands {
    public double angleClock(int hour, int minutes) {
        double h = (hour == 12) ? 0 : hour * 30;
        h += minutes * 0.5;

        double m = minutes * 6.0;

        double diff = Math.abs(h - m);

        return (diff <= 180) ? diff : 360 - diff;
    }
}
