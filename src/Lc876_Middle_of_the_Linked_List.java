public class Lc876_Middle_of_the_Linked_List {
/**
 * Tag: Linked List;
 * Time: O(n)
 * Space: O(1)
 * Solution: one step and two step;
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // 两个中点的时候，返回第二个；
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;


    }
}