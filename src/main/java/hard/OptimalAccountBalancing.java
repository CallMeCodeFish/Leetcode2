package hard;

/**
 * @author Heng Yu
 * @date 5/28/20 5:03 PM
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * leetcode 465: Optimal account balancing
 */
public class OptimalAccountBalancing {
    public static void main(String[] args) {
        OptimalAccountBalancing solution = new OptimalAccountBalancing();
        int[][] transactions = {{0,1,1},{0,2,2},{0,3,3},{0,4,3},{0,5,3}};
        int result = solution.minTransfers(transactions);
        System.out.println(result);
    }

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> accounts = new HashMap<>();
        for (int[] t : transactions) {
            int from = t[0];
            int to = t[1];
            int amount = t[2];

            accounts.put(from, accounts.getOrDefault(from, 0) - amount);
            accounts.put(to, accounts.getOrDefault(to, 0) + amount);
        }

        TreeMap<Integer, Integer> debts = new TreeMap<>((a, b) -> b - a); // needs to pay
        TreeMap<Integer, Integer> credits = new TreeMap<>((a, b) -> b - a); //needs to be paid

        for (Integer person : accounts.keySet()) {
            int amount = accounts.get(person);
            if (amount < 0) {
                // needs to be paid
                amount = -amount;
                credits.putIfAbsent(amount, 0);
                credits.replace(amount, credits.get(amount) + 1);
            }
        }

        int res = 0;

        for (Integer person : accounts.keySet()) {
            int amount = accounts.get(person);
            if (amount > 0) {
                // needs to pay
                if (credits.containsKey(amount)) {
                    res++;
                    credits.replace(amount, credits.get(amount) - 1);
                    if (credits.get(amount) == 0) credits.remove(amount);
                } else {
                    debts.putIfAbsent(amount, 0);
                    debts.replace(amount, debts.get(amount) + 1);
                }
            }
        }

        for (Integer c : credits.keySet()) {
            // needs to be paid
            int count = credits.get(c);

            for (int i = 0; i < count; i++) {
                int amount = c;
                while (amount > 0) {
                    int first = 0, second = 0;
                    for (Integer key : debts.keySet()) {
                        int diff = amount - key;
                        if (diff > 0 && debts.containsKey(diff)) {
                            if (diff == key && debts.get(key) < 2) continue;
                            first = key;
                            second = diff;
                            debts.replace(first, debts.get(first) - 1);
                            debts.replace(second, debts.get(second) - 1);
                            amount = 0;
                            break;
                        }
                    }

                    if (first == 0) {
                        int max = debts.firstKey();
                        debts.replace(max, debts.get(max) - 1);
                        if (debts.get(max) == 0) debts.remove(max);
                        if (max > amount) {
                            debts.putIfAbsent(max - amount, 0);
                            debts.replace(max - amount, debts.get(max - amount) + 1);
                            amount = 0;
                        } else {
                            amount -= max;
                        }
                        res++;
                    } else {
                        if (debts.get(first) == 0) debts.remove(first);
                        if (first != second && debts.get(second) == 0) debts.remove(second);
                        res += 2;
                    }
                }
            }
        }

        return res;
    }
}
