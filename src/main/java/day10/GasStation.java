package day10;

/**
 * @author Heng Yu
 * @date 3/7/20 12:07 AM
 */

/**
 * leetcode 134: Gas Station
 */

public class GasStation {
    public static void main(String[] args) {
        GasStation solution = new GasStation();
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            gas[i] -= cost[i];
            sum += gas[i];
        }
        if (sum < 0) return -1;
        int res = -1;
        int i = 0;
        while (i < len) {
            if (gas[i] < 0) {
                ++i;
            } else {
                sum = gas[i];
                int j = (i + 1) % len;
                boolean flag = true;
                while (j != i) {
                    sum += gas[j];
                    if (sum < 0) {
                        flag = false;
                        break;
                    }
                    j = (j + 1) % len;
                }
                if (flag) {
                    res = i;
                    break;
                } else {
                    i = (j + 1);
                }
            }
        }
        return res;
    }
}
