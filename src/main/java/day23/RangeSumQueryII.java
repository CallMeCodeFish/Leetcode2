package day23;

/**
 * @author Heng Yu
 * @date 3/20/20 10:47 PM
 */

/**
 * leetcode 307: Range Sum Query - Mutable
 */

public class RangeSumQueryII {
    private class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private SegmentTreeNode root;

    public RangeSumQueryII(int[] nums) {
        if (nums != null && nums.length != 0) {
            this.root = build(nums, 0, nums.length - 1);
        }
    }

    private SegmentTreeNode build(int[] nums, int start, int end) {
        SegmentTreeNode res = new SegmentTreeNode(start, end);
        if (start == end) {
            res.sum = nums[start];
            return res;
        }

        int mid = start + (end - start) / 2;
        res.left = build(nums, start, mid);
        res.right = build(nums, mid + 1, end);
        res.sum = res.left.sum + res.right.sum;
        return res;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode node, int i, int val) {
        //edge case
        if (node.start == node.end) {
            node.sum = val;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (i <= mid) {
            update(node.left, i, val);
        } else {
            update(node.right, i, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int i, int j) {
        int res = getSum(root, j);
        if (i != 0) res -= getSum(root, i - 1);
        return res;
    }

    private int getSum(SegmentTreeNode node, int i) {
        if (i == node.end) return node.sum;

        int mid = node.start + (node.end - node.start) / 2;
        if (i <= mid) {
            return getSum(node.left, i);
        } else {
            return node.left.sum + getSum(node.right, i);
        }
    }
}
