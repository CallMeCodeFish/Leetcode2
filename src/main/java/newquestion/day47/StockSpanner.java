package newquestion.day47;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 7/3/20 5:06 PM
 */

/**
 * leetcode 901: Online stock span
 * solution: skip list
 */
public class StockSpanner {
    private List<Integer> prices;
    private List<Integer> skip;

    public StockSpanner() {
        prices = new ArrayList<>();
        skip = new ArrayList<>();
        prices.add(Integer.MAX_VALUE);
        skip.add(-1);
    }

    public int next(int price) {
        int prevIndex = getPrevIndex(price);
        int curIndex = prices.size();
        prices.add(price);
        skip.add(prevIndex);
        return curIndex - prevIndex;
    }

    private int getPrevIndex(int price) {
        int index = prices.size() - 1;
        int cur = prices.get(index);

        while (cur <= price) {
            index = skip.get(index);
            cur = prices.get(index);
        }

        return index;
    }
}
