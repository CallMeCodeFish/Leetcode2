package day13;

/**
 * @author Heng Yu
 * @date 3/10/20 9:01 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 166: Fraction to Recurring Decimal
 */

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        FractionToRecurringDecimal solution = new FractionToRecurringDecimal();
        String result = solution.fractionToDecimal(1, 7);
        System.out.println(result);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 && 0 < denominator || 0 < numerator && denominator < 0) sb.append('-');
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        sb.append(n / d);
        n %= d;
        if (n == 0) return sb.toString();
        sb.append('.');
        Map<Long, Integer> index = new HashMap<>();
        while (0 < n) {
            n *= 10;
            while (n < d) {
                n *= 10;
                sb.append(0);
            }
            if (index.containsKey(n)) {
                int idx = index.get(n);
                sb.insert(idx, '(');
                sb.append(')');
                break;
            } else {
                index.put(n, sb.length());
            }
            sb.append(n / d);
            n %= d;
        }
        return sb.toString();
    }
}
