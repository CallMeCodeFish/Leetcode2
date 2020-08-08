package newquestion.day67;


import java.util.TreeMap;

/**
 * leetcode 726: Number of atoms (hard)
 */
public class NumberOfAtoms {
    private void helper(char[] chs, int l, int r, TreeMap<String, Integer> map, int multiplier) {
        int i = l;

        while (i < r) {
            char c = chs[i];
            if (Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                i++;
                while (i < r && Character.isLowerCase(chs[i])) {
                    sb.append(chs[i++]);
                }

                String atom = sb.toString();

                int count = 1;
                if (i < r && Character.isDigit(chs[i])) {
                    sb = new StringBuilder();
                    while (i < r && Character.isDigit(chs[i])) {
                        sb.append(chs[i++]);
                    }
                    count = Integer.parseInt(sb.toString());
                }
                count *= multiplier;
                int cur = map.getOrDefault(atom, 0);
                map.put(atom, cur + count);
            } else {
                int bracket = 0;
                int j = i;
                while (j < r) {
                    if (chs[j] == '(') {
                        bracket++;
                    } else if (chs[j] == ')') {
                        bracket--;
                    }
                    j++;
                    if (bracket == 0) break;
                }
                int k = j - 1;
                int count = 1;
                if (j < r && Character.isDigit(chs[j])) {
                    StringBuilder sb = new StringBuilder();
                    while (j < r && Character.isDigit(chs[j])) {
                        sb.append(chs[j++]);
                    }
                    count = Integer.parseInt(sb.toString());
                }
                helper(chs, i + 1, k, map, multiplier * count);
                i = j;
            }
        }
    }

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();

        helper(formula.toCharArray(), 0, formula.length(), map, 1);

        StringBuilder sb = new StringBuilder();

        for (String s : map.keySet()) {
            sb.append(s);
            int count = map.get(s);
            if (count > 1) sb.append(count);
        }

        return sb.toString();
    }
}
