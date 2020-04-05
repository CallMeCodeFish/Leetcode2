package contest.Apr4;

/**
 * @author Heng Yu
 * @date 4/4/20 11:15 PM
 */


public class LongestHappyString {
    public static void main(String[] args) {
        LongestHappyString solution = new LongestHappyString();
        String result = solution.longestDiverseString(1, 0, 3);
        System.out.println(result);
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        if (a < 3 && b < 3 && c < 3) {
            for (int i = 0; i < a; ++i) {
                sb.append('a');
            }
            for (int i = 0; i < b; ++i) {
                sb.append('b');
            }
            for (int i = 0; i < c; ++i) {
                sb.append('c');
            }
            return sb.toString();
        }

        int max = 0, min1 = 0, min2 = 0;
        char maxChar = 'a', minChar1 = 'a', minChar2 = 'a';
        if (a < b) {
            if (b < c) {
                max = c;
                maxChar = 'c';
                min1 = a;
                minChar1 = 'a';
                min2 = b;
                minChar2 = 'b';
            } else {
                max = b;
                maxChar = 'b';
                min1 = a;
                minChar1 = 'a';
                min2 = c;
                minChar2 = 'c';
            }
        } else {
            if (a < c) {
                max = c;
                maxChar = 'c';
                min1 = a;
                minChar1 = 'a';
                min2 = b;
                minChar2 = 'b';
            } else {
                max = a;
                maxChar = 'a';
                min1 = b;
                minChar1 = 'b';
                min2 = c;
                minChar2 = 'c';
            }
        }
        int spaceNumber = (max % 2 == 0) ? max / 2 : max / 2 + 1;
        int sum = min1 + min2;
        if (sum <= spaceNumber) {
            for (int i = 0; i < sum; ++i) {
                sb.append(maxChar);
                if (i < spaceNumber - 1 || max % 2 == 0) {
                    sb.append(maxChar);
                }
                if (min1 > 0) {
                    sb.append(minChar1);
                    --min1;
                } else {
                    sb.append(minChar2);
                    --min2;
                }
            }
            if (sum < spaceNumber) {
                sb.append(maxChar);
                if (sum < spaceNumber - 1 || max % 2 == 0)
                    sb.append(maxChar);
            }
        } else {
            int group1 = min1;
            int group2 = min2;
            for (int i = 0; i < spaceNumber; ++i) {
                sb.append(maxChar);
                if (i < spaceNumber - 1 || max % 2 == 0) {
                    sb.append(maxChar);
                }
                if (min1 > 0) {
                    if (group1 > spaceNumber) {
                        sb.append(minChar1);
                        sb.append(minChar1);
                        --group1;
                        min1 -= 2;
                    } else {
                        sb.append(minChar1);
                        --min1;
                    }
                }
                if (min2 > 0) {
                    if (group2 > spaceNumber) {
                        sb.append(minChar2);
                        sb.append(minChar2);
                        --group2;
                        min2 -= 2;
                    } else {
                        sb.append(minChar2);
                        --min2;
                    }
                }
            }
        }

        return sb.toString();
    }
}
