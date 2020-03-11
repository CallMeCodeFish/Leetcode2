package day13;

/**
 * @author Heng Yu
 * @date 3/10/20 8:37 PM
 */

/**
 * leetcode 165: Compare Version Numbers
 */

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < v1.length && j < v2.length) {
            int n1 = Integer.parseInt(v1[i++]);
            int n2 = Integer.parseInt(v2[j++]);
            if (n1 < n2) return -1;
            if (n2 < n1) return 1;
        }
        while (i < v1.length) {
            int n1 = Integer.parseInt(v1[i++]);
            int n2 = 0;
            if (n1 < n2) return -1;
            if (n2 < n1) return 1;
        }
        while (j < v2.length) {
            int n1 = 0;
            int n2 = Integer.parseInt(v2[j++]);
            if (n1 < n2) return -1;
            if (n2 < n1) return 1;
        }
        return 0;
    }
}
