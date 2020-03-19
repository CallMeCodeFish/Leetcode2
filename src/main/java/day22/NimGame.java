package day22;

/**
 * @author Heng Yu
 * @date 3/19/20 6:47 PM
 */

/**
 * 解释：先手没赢就输了
 * leetcode 292: Nim Game
 */

public class NimGame {
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
