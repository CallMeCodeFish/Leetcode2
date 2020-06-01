package hard;

/**
 * @author Heng Yu
 * @date 5/31/20 6:44 PM
 */

/**
 * leetcode 1467: Probability of a two boxes having the same number of distinct balls
 */
public class ProbabilityOfTwoBoxes {
    public static void main(String[] args) {
        ProbabilityOfTwoBoxes solution = new ProbabilityOfTwoBoxes();
        int[] balls = {6,6,6,6,6,6};
        double result = solution.getProbability(balls);
        System.out.println(result);
    }

    private double[] factorial;

    public double getProbability(int[] balls) {
        int sum = 0;
        int max = 0;
        for (int num : balls) {
            sum += num;
            max = Math.max(max, num);
        }

        double total = 1;
        for (int i = sum / 2 + 1; i <= sum; i++) {
            total *= i;
        }

        for (int i = 1; i <= sum / 2; i++) {
            total /= i;
        }

        factorial = new double[max + 1];
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = i * factorial[i - 1];
        }


        double count = helper(balls, 0, 0, 0, 0, 0);

        return count / total;
    }

    private double helper(int[] balls, int index, int count1, int count2, int colorCount1, int colorCount2) {
        if (index == balls.length) {
            return (count1 == count2 && colorCount1 == colorCount2)? 1 : 0;
        }

        double res = 0;
        for (int i = 0; i <= balls[index]; i++) {
            res += combination(balls[index], i) * helper(balls, index + 1, count1 + i, count2 + (balls[index] - i), colorCount1 + ((i == 0)? 0 : 1), colorCount2 + ((i == balls[index])? 0 : 1));
        }

        return res;
    }

    private double combination(int n, int k) {
        return factorial[n] / (factorial[k] * factorial[n - k]);
    }
}
