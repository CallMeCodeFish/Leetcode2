package hard;

/**
 * @author Heng Yu
 * @date 5/5/20 8:21 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 273: Integer to English words
 */
public class IntegerToEnglishWords {
    public static void main(String[] args) {
        IntegerToEnglishWords solution = new IntegerToEnglishWords();
        String result = solution.numberToWords(1000000);
        System.out.println(result);
        System.out.println("One Million".equals(result));
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        char[] digits = String.valueOf(num).toCharArray();
        int n = (digits.length - 1) / 3 + 1;

        String[] magnitude = {"", "Thousand", "Million", "Billion"};
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] hundreds = {"", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred", "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred"};

        List<String> resultList = new ArrayList<>();

        int j = digits.length - 1;
        for (int k = 0; k < n; ++k) {
            int i = j;
            if (i - 2 >= 0) {
                i -= 2;
            } else if (i - 1 >= 0) {
                --i;
            }

            int temp = j;
            boolean skip = true;
            while (temp >= i) {
                if (digits[temp] != '0') {
                    skip = false;
                    break;
                }
                --temp;
            }

            if (skip) {
                j = i - 1;
                continue;
            }

            List<String> list = new ArrayList<>();
            list.add(magnitude[k]);

            if (i == j) {
                list.add(ones[digits[j] - '0']);
            } else {
                if (digits[j - 1] == '1' && digits[j] != '0') {
                    list.add(teens[digits[j] - '0']);
                } else {
                    String one = ones[digits[j] - '0'];
                    if (!one.isEmpty()) list.add(one);
                    String ten = tens[digits[j - 1] - '0'];
                    if (!ten.isEmpty()) list.add(ten);
                }
                if (i == j - 2) {
                    String hundred = hundreds[digits[i] - '0'];
                    if (!hundred.isEmpty()) list.add(hundred);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int idx = list.size() - 1; idx >= 0; --idx) {
                sb.append(list.get(idx));
                sb.append(" ");
            }

            resultList.add(sb.toString().trim());

            j = i - 1;
        }

        StringBuilder res = new StringBuilder();
        for (int i = resultList.size() - 1; i >= 0; --i) {
            res.append(resultList.get(i));
            res.append(" ");
        }

        return res.toString().trim();
    }
}
