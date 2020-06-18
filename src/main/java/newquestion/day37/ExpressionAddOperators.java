package newquestion.day37;

/**
 * @author Heng Yu
 * @date 6/17/20 5:53 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 282: Expression Add Operators
 */
public class ExpressionAddOperators {
    public static void main(String[] args) {
        ExpressionAddOperators solution = new ExpressionAddOperators();
        List<String> result = solution.addOperators("2147483648", -2147483648);
        System.out.println(result);
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();

        char[] digits = num.toCharArray();

        backtracking(digits, 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), res, target);

        return res;
    }

    private void backtracking(char[] digits, int start, List<Long> numsToWrite, List<Character> optsToWrite, List<Long> nums, List<Character> opts, List<String> res, int target) {
        if (start == digits.length) {
            long sum = 0;
            for (long num : nums) {
                sum += num;
            }
            if (sum == target) {
                StringBuilder sb = new StringBuilder();
                sb.append(numsToWrite.get(0));
                for (int i = 0; i < optsToWrite.size(); i++) {
                    sb.append(optsToWrite.get(i));
                    sb.append(numsToWrite.get(i + 1));
                }
                res.add(sb.toString());
            }
            return;
        }

        long num = 0;

        for (int i = start; i < digits.length; i++) {
            num *= 10;
            num += digits[i] - '0';

            if (numsToWrite.isEmpty()) {
                numsToWrite.add(num);
                nums.add(num);
                backtracking(digits, i + 1, numsToWrite, optsToWrite, nums, opts, res, target);
                nums.remove(nums.size() - 1);
                numsToWrite.remove(0);
            } else {
                numsToWrite.add(num);

                //add
                optsToWrite.add('+');
                opts.add('+');
                nums.add(num);
                backtracking(digits, i + 1, numsToWrite, optsToWrite, nums, opts, res, target);
                nums.remove(nums.size() - 1);
                opts.remove(opts.size() - 1);
                optsToWrite.remove(optsToWrite.size() - 1);

                //subtract
                optsToWrite.add('-');
                opts.add('+');
                nums.add(-num);
                backtracking(digits, i + 1, numsToWrite, optsToWrite, nums, opts, res, target);
                nums.remove(nums.size() - 1);
                opts.remove(opts.size() - 1);
                optsToWrite.remove(optsToWrite.size() - 1);

                //multiply
                optsToWrite.add('*');
                long temp = nums.get(nums.size() - 1);
                nums.set(nums.size() - 1, temp * num);
                backtracking(digits, i + 1, numsToWrite, optsToWrite, nums, opts, res, target);
                nums.set(nums.size() - 1, temp);
                optsToWrite.remove(optsToWrite.size() - 1);

                numsToWrite.remove(numsToWrite.size() - 1);
            }

            if (digits[start] == '0') break;
        }
    }
}
