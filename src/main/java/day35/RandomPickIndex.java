package day35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 4/22/20 6:27 PM
 */


public class RandomPickIndex {
    private Map<Integer, List<Integer>> indices;

    public RandomPickIndex(int[] nums) {
        indices = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (!indices.containsKey(num)) {
                indices.put(num, new ArrayList<>());
            }
            indices.get(num).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = indices.get(target);
        int size = list.size();
        int randIndex = (int) (Math.random() * size);
        return list.get(randIndex);
    }
}
