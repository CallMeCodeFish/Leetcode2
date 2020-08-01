package newquestion.day63;

/**
 * @author Heng Yu
 * @date 7/31/20 5:33 PM
 */


public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if (n < 10) return -1;

        StringBuilder sb = new StringBuilder();
        sb.append(n);

        int start = findStart(sb);
        if (start == -1) return -1;

        char first = sb.charAt(start);
        int end = sb.length() - 1;
        while (end > start + 1) {
            if (first < sb.charAt(end)) break;
            end--;
        }

        char c = sb.charAt(start);
        sb.setCharAt(start, sb.charAt(end));
        sb.setCharAt(end, c);

        int i = start + 1, j = sb.length() - 1;
        while (i <= j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
            i++;
            j--;
        }

        long res = Long.parseLong(sb.toString());

        return res >= Integer.MAX_VALUE ? -1 : (int) res;
    }

    private int findStart(StringBuilder sb) {
        int i = sb.length() - 2;

        while (i >= 0) {
            if (sb.charAt(i) < sb.charAt(i + 1)) break;
            i--;
        }

        return i;
    }
}
