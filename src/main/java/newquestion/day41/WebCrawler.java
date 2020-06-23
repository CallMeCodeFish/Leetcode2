package newquestion.day41;

/**
 * @author Heng Yu
 * @date 6/22/20 8:56 PM
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 1236: Web crawler
 */
interface HtmlParser {
    List<String> getUrls(String url);
}

public class WebCrawler {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> res = new ArrayList<>();

        String hostname = getHostname(startUrl);

        Set<String> seen = new HashSet<>();

        helper(startUrl, hostname, htmlParser, seen, res);

        return res;
    }

    private String getHostname(String url) {
        return url.split("//")[1].split("/")[0];
    }

    private void helper(String curUrl, String hostname, HtmlParser parser, Set<String> seen, List<String> res) {
        if (seen.contains(curUrl)) return;

        String hName = getHostname(curUrl);

        if (!hostname.equals(hName)) return;

        seen.add(curUrl);
        res.add(curUrl);

        List<String> urls = parser.getUrls(curUrl);
        for (String url : urls) {
            helper(url, hostname, parser, seen, res);
        }
    }
}
