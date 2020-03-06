package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 3:47 PM
 */

import helper.ListNode;
import helper.TreeNode;

/**
 * leetcode 109: Convert Sorted List to Binary Search Tree
 */

public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        //edge case
        if (head == null) return null;

        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }
        return helper(head, len);
    }

    private TreeNode helper(ListNode listNode, int len) {
        //edge case
        if (len == 0) return null;

        int mid = len / 2;
        ListNode cur = listNode;
        for (int i = 0; i < mid; ++i) {
            cur = cur.next;
        }
        TreeNode treeNode = new TreeNode(cur.val);
        treeNode.left = helper(listNode, mid);
        treeNode.right = helper(cur.next, len - mid - 1);
        return treeNode;
    }
}
