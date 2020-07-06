package newquestion.day48;

import java.util.*;

/**
 * @author Heng Yu
 * @date 7/5/20 5:20 PM
 */

/**
 * leetcode 1244: Design a leaderboard
 */
public class Leaderboard {
    private static class Player {
        int id;
        int score;

        public Player(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    private Map<Integer, Player> map;
    private List<Player> list;

    public Leaderboard() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void addScore(int playerId, int score) {
        if (!map.containsKey(playerId)) {
            Player p = new Player(playerId, score);
            map.put(playerId, p);
            int index = binSearch(score);
            list.add(index, p);
        } else {
            Player p = map.get(playerId);
            list.remove(p);
            p.score += score;
            int index = binSearch(p.score);
            list.add(index, p);
        }
    }

    private int binSearch(int score) {
        List<Player> list = this.list;
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (score < list.get(mid).score) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public int top(int K) {
        int res = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            if (K == 0) break;
            res += list.get(i).score;
            K--;
        }

        return res;
    }

    public void reset(int playerId) {
        if (map.containsKey(playerId)) {
            Player p = map.get(playerId);
            map.remove(playerId);
            list.remove(p);
        }
    }
}
