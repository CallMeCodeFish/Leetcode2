package hard;

/**
 * @author Heng Yu
 * @date 3/2/20 7:03 PM
 */

import helper.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 23: Merge k Sorted Lists
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode header = new ListNode(-1);
        ListNode pred = header;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        while (!heap.isEmpty()) {
            ListNode list = heap.poll();
            pred.next = new ListNode(list.val);
            pred = pred.next;
            list = list.next;
            if (list != null) {
                heap.offer(list);
            }
        }
        return header.next;
    }
}
