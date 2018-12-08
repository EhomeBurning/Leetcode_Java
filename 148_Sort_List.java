/**
 * Tag: Linked List
 * Solution: Merge Sort
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Lc148_Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode leftEnd = getMidNode(head);
        ListNode right = leftEnd.next;
        leftEnd.next = null;
        return mergeTwoLists(sortList(head), sortList(right));
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode headPrev = new ListNode(0);
        ListNode tail = headPrev;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        } else{
            tail.next = head2;
        }
        // 这里有点不清楚
        return headPrev.next;
    }

}



