package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/7/20 5:24 PM
 */

/**
 * leetcode 68: Text justification
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < words.length) {
            StringBuilder sb = new StringBuilder();
            int j = i;
            int len = 0;
            while (j < words.length) {
                if (len + words[j].length() + j - i > maxWidth) {
                    break;
                }
                len += words[j].length();
                ++j;
            }

            if (j == words.length) {
                int totalLen = 0;
                while (i < j) {
                    sb.append(words[i]);
                    totalLen += words[i].length();
                    if (i < words.length - 1) {
                        sb.append(' ');
                        ++totalLen;
                    }
                    ++i;
                }
                if (maxWidth - totalLen > 0) {
                    sb.append(createBlank(maxWidth - totalLen));
                }
            } else {
                int wordCount = j - i;
                if (wordCount == 1) {
                    String blank = createBlank(maxWidth - len);
                    sb.append(words[i++]);
                    sb.append(blank);
                } else {
                    int spaceLen = (maxWidth - len) / (j - i - 1);
                    int longCount = (maxWidth - len) % (j - i - 1);
                    int shortCount = j - i - 1 - longCount;
                    String longBlank = createBlank(spaceLen + 1);
                    String shortBlank = createBlank(spaceLen);
                    while (i < j) {
                       sb.append(words[i++]);
                       if (longCount > 0) {
                           sb.append(longBlank);
                           --longCount;
                       } else if (shortCount > 0) {
                           sb.append(shortBlank);
                           --shortCount;
                       }
                    }
                }
            }
            res.add(sb.toString());
        }

        return res;
    }

    private String createBlank(int len) {
        StringBuilder sb = new StringBuilder();
        while (len > 0) {
            sb.append(' ');
            --len;
        }
        return sb.toString();
    }
}
