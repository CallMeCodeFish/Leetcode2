package day17;

/**
 * @author Heng Yu
 * @date 3/14/20 6:11 PM
 */

/**
 * leetcode 223: Rectangle Area
 */

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = (G - E) * (H - F) + (D - B) * (C - A);
        if (H <= B || D <= F || G <= A || C <= E) return res;
        int height = 0;
        int width = 0;
        if (H < D) {
            height = H - Math.max(F, B);
        } else {
            height = D - Math.max(F, B);
        }
        if (C < G) {
            width = C - Math.max(E, A);
        } else {
            width = G - Math.max(E, A);
        }
        return res - height * width;
    }
}
