package newquestion.day57;

/**
 * @author Heng Yu
 * @date 7/19/20 3:06 PM
 */

/**
 * leetcode 605: Can place flowers
 */
public class CanPlace {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int i = 0;
        boolean leftZero = true;
        while (i < len) {
            if (n == 0) break;

            if (flowerbed[i] == 0){
                if (!leftZero) {
                    i++;
                    leftZero = true;
                } else {
                    if (i + 1 == len || flowerbed[i + 1]  == 0) {
                        n--;
                    } else {
                        leftZero = false;
                    }
                    i += 2;
                }
            } else {
                i++;
                leftZero = false;
            }
        }

        return n == 0;
    }
}
