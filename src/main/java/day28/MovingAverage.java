package day28;

/**
 * @author Heng Yu
 * @date 3/28/20 7:42 PM
 */


public class MovingAverage {
    /** Initialize your data structure here. */
    private int[] nums;
    private int index;
    private int size;
    private double average;

    public MovingAverage(int size) {
        this.nums = new int[size];
        this.index = 0;
        this.size = 0;
        this.average = 0;
    }

    public double next(int val) {
        if (size == nums.length) {
            double sum = average * size;
            sum -= nums[index];
            nums[index] = val;
            sum += val;
            average = sum / size;
            index = (index + 1) % nums.length;
        } else {
            double sum = average * size;
            nums[index] = val;
            sum += val;
            ++size;
            average = sum / size;
            index = (index + 1) % nums.length;
        }
        return average;
    }
}
