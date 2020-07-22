package newquestion.day59;

/**
 * @author Heng Yu
 * @date 7/22/20 6:48 PM
 */


public class ValidateIP {
    public String validIPAddress(String IP) {
        String[] split = IP.split("[.:]", -1);
        if (split.length != 4 && split.length != 8) return "Neither";

        if (split.length == 4) {
            for (String s : split) {
                if (s.length() == 0 || s.length() > 3) return "Neither";

                if (s.length() > 1 && '0' == s.charAt(0)) return "Neither";

                for (int i = 0; i < s.length(); i++) {
                    if (Character.isLetter(s.charAt(i))) return "Neither";
                }

                if (Integer.parseInt(s) > 255) return "Neither";
            }

            return "IPv4";
        } else {
            for (String s : split) {
                if (s.isEmpty() || s.length() > 4) return "Neither";
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (Character.isLetter(c)) {
                        if (!('a' <= c && c <= 'f') && !('A' <= c && c <= 'F')) return "Neither";
                    }
                }
            }

            return "IPv6";
        }
    }
}
