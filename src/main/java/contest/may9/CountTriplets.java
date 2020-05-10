package contest.may9;

/**
 * @author Heng Yu
 * @date 5/9/20 10:41 PM
 */


public class CountTriplets {
    public static void main(String[] args) {
        CountTriplets solution = new CountTriplets();
        int[] arr = {1,1,1,1,1};
        int result = solution.countTriplets(arr);
        System.out.println(result);
    }

    public int countTriplets(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; ++i) {
            int cur = 0;
            for (int j = i; j < arr.length; ++j) {
                cur ^= arr[j];
                if (cur == 0) res += j - i;
            }
        }

        return res;
    }
}
