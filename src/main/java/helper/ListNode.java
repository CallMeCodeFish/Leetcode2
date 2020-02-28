package helper;

/**
 * @author Heng Yu
 * @date 2/26/20 6:11 PM
 */


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static ListNode create(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode pred = head;
        for (int num : nums) {
            pred.next = new ListNode(num);
            pred = pred.next;
        }
        return head.next;
    }

    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val);
            sb.append("->");
            cur = cur.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
