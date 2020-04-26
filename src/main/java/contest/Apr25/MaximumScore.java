package contest.Apr25;

/**
 * @author Heng Yu
 * @date 4/25/20 10:30 PM
 */


public class MaximumScore {
    public static void main(String[] args) {
        MaximumScore solution = new MaximumScore();
        int result = solution.maxScore("1111");
        System.out.println(result);
    }

    public int maxScore(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int[] zeroCount = new int[len];
        int[] oneCount = new int[len];

        for (int i = 0; i < len; ++i) {
            char c = chs[i];
            if (i == 0) {
                zeroCount[i] = (c == '0')? 1 : 0;
            } else {
                zeroCount[i] = (c == '0')? zeroCount[i - 1] + 1 : zeroCount[i - 1];
            }
        }

        for (int i = len - 2; i >= 0; --i) {
            char c = chs[i + 1];
            oneCount[i] = (c == '1')? oneCount[i + 1] + 1 : oneCount[i + 1];
        }

        int res = 0;
        for (int i = 0; i < len - 1; ++i) {
            int cur = zeroCount[i] + oneCount[i];
            res = Math.max(res, cur);
        }

        return res;
    }
}
