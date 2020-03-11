package day13;

/**
 * @author Heng Yu
 * @date 3/10/20 6:27 PM
 */

/**
 * leetcode 161: One Edit Distance
 */

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length() - 1) {
            if (s.isEmpty()) return true;
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) != t.charAt(i)) break;
                ++i;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s, 0, i);
            sb.append(t.charAt(i));
            sb.append(s.substring(i));
            return t.equals(sb.toString());
        } else if (s.length() == t.length() + 1) {
            if (t.isEmpty()) return true;
            int i = 0;
            while (i < t.length()) {
                if (t.charAt(i) != s.charAt(i)) break;
                ++i;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s, 0, i);
            sb.append(s.substring(i + 1));
            return t.equals(sb.toString());
        } else if (s.length() == t.length()) {
            if (t.equals(s)) return false;
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) != t.charAt(i)) break;
                ++i;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s, 0, i);
            sb.append(t.charAt(i));
            sb.append(s.substring(i + 1));
            return t.equals(sb.toString());
        }
        return false;
    }
}
