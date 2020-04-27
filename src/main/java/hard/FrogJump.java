package hard;

/**
 * @author Heng Yu
 * @date 4/27/20 5:48 PM
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 403: Frog jump
 */
public class FrogJump {
    public static void main(String[] args) {
        FrogJump solution = new FrogJump();
        int[] stones = {0,1,2,3,4,8,9,11};
        boolean result = solution.canCross(stones);
        System.out.println(result);
    }

    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);

        for (int stone : stones) {
            Set<Integer> steps = map.get(stone);
            if (stone == stones[stones.length - 1] && !steps.isEmpty()) return true;
            for (int step : steps) {
                if (step - 1 > 0 && map.containsKey(stone + step - 1)) {
                    map.get(stone + step - 1).add(step - 1);
                }

                if (step > 0 && map.containsKey(stone + step)) {
                    map.get(stone + step).add(step);
                }

                if (map.containsKey(stone + step + 1)) {
                    map.get(stone + step + 1).add(step + 1);
                }
            }
        }

        return false;
    }
}
