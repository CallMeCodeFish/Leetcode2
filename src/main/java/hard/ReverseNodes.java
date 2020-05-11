package hard;

import helper.ListNode;

/**
 * @author Heng Yu
 * @date 5/11/20 6:56 PM
 */

/**
 * leetcode 25: Reverse nodes in k-groups
 */
public class ReverseNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pred = dummy;

        while (pred.next != null) {
            head = pred.next;
            ListNode end = head;
            int count = 0;
            while (end != null) {
                end = end.next;
                ++count;
                if (count == k) break;
            }
            if (count < k) break;

            while (head.next != end) {
                ListNode cur = head.next;
                head.next = cur.next;
                cur.next = pred.next;
                pred.next = cur;
            }

            pred = head;
        }

        return dummy.next;
    }
}
