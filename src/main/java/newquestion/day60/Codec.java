package newquestion.day60;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 7/23/20 7:36 PM
 */

/**
 * leetcode 535: Encode and decode tiny url
 */
public class Codec {
    private long id;
    private Map<String, String> visited;
    private Map<String, String> mapping;
    private char[] charset;

    public Codec() {
        id = 0L;
        visited = new HashMap<>();
        mapping = new HashMap<>();
        charset = new char[62];
        for (int i = 0; i < 26; i++) {
            charset[i] = (char) ('a' + i);
        }
        for (int i = 26; i < 52; i++) {
            charset[i] = (char) ('A' + (i - 26));
        }
        for (int i = 52; i < 62; i++) {
            charset[i] = (char) ('0' + (i - 52));
        }
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (visited.containsKey(longUrl)) return visited.get(longUrl);

        StringBuilder sb = new StringBuilder();
        long id = this.id++;
        while (true) {
            int index = (int) (id % 62);
            sb.append(charset[index]);
            id /= 62;
            if (id == 0) break;
        }

        String shortUrl = sb.toString();
        mapping.put(shortUrl, longUrl);
        visited.put(longUrl, shortUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mapping.get(shortUrl);
    }
}
