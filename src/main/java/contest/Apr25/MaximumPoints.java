package contest.Apr25;

/**
 * @author Heng Yu
 * @date 4/25/20 10:46 PM
 */


public class MaximumPoints {
    public static void main(String[] args) {
        MaximumPoints solution = new MaximumPoints();
        int[] cards = {1,79,80,1,1,1,200,1};
        int k = 3;
        int result = solution.maxScore(cards, k);
        System.out.println(result);
    }

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 0; i < len; ++i) {
            if (i == 0) {
                left[i] = cardPoints[i];
            } else {
                left[i] = left[i - 1] + cardPoints[i];
            }
        }

        for (int i = len - 1; i >= 0; --i) {
            if (i == len - 1) {
                right[i] = cardPoints[i];
            } else {
                right[i] = right[i + 1] + cardPoints[i];
            }
        }

        int res = 0;

        int i = 0, j = len - 1;
        while (k > 0) {
            int leftRemain = 0;
            if (i == 0) {
                leftRemain = left[i + k - 1];
            } else {
                leftRemain = left[i + k - 1] - left[i - 1];
            }

            int rightRemain = 0;
            if (j == len - 1) {
                rightRemain = right[j - k + 1];
            } else {
                rightRemain = right[j - k + 1] - right[j + 1];
            }

            if (leftRemain >= rightRemain) {
                res += cardPoints[i++];
            } else {
                res += cardPoints[j--];
            }
            --k;
        }

        return res;
    }
}
