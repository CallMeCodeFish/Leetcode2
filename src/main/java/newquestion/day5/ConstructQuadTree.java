package newquestion.day5;

/**
 * @author Heng Yu
 * @date 4/29/20 5:37 PM
 */


public class ConstructQuadTree {
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        int len = grid.length;

        return helper(grid, 0, len, 0, len);
    }

    private Node helper(int[][] grid, int xStart, int xEnd, int yStart, int yEnd) {
        int len = xEnd - xStart;
        //edge case
        if (len == 1) {
            boolean val = grid[xStart][yStart] != 0;
            return new Node(val, true);
        }

        Node node = new Node();
        Node topLeft = helper(grid, xStart, xStart + len / 2, yStart, yStart + len / 2);
        Node topRight = helper(grid, xStart, xStart + len / 2, yStart + len / 2, yEnd);
        Node bottomLeft = helper(grid, xStart + len / 2, xEnd, yStart, yStart + len / 2);
        Node bottomRight = helper(grid, xStart + len / 2, xEnd, yStart + len / 2, yEnd);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            node.isLeaf = true;
            node.val = topLeft.val;
        } else {
            node.topLeft = topLeft;
            node.topRight = topRight;
            node.bottomLeft = bottomLeft;
            node.bottomRight = bottomRight;
        }

        return node;
    }
}
