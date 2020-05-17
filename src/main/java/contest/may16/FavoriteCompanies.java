package contest.may16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 5/16/20 10:41 PM
 */


public class FavoriteCompanies {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int len = favoriteCompanies.size();
        Set<String>[] sets = new Set[len];

        for (int i = 0; i < len; ++i) {
            sets[i] = new HashSet<>(favoriteCompanies.get(i));
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < len; ++i) {
            boolean canAdd = true;
            for (int j = 0; j < len; ++j) {
                if (i != j) {
                    if (sets[j].containsAll(sets[i])) {
                        canAdd = false;
                        break;
                    }
                }
            }
            if (canAdd) {
                res.add(i);
            }
        }

        return res;
    }
}
