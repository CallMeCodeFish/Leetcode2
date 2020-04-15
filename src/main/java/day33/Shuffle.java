package day33;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 4/9/20 4:32 PM
 */


public class Shuffle {
    private int[] nums;
    private int[] shuffle;

    public Shuffle(int[] nums) {
        this.nums = nums;
        reset();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffle = Arrays.copyOf(nums, nums.length);
        return shuffle;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < shuffle.length; ++i) {
            int randIndex = i + (int) (Math.random() * (shuffle.length - i));
            int temp = shuffle[i];
            shuffle[i] = shuffle[randIndex];
            shuffle[randIndex] = temp;
        }
        return shuffle;
    }
}
