
/**
 * Tag: Linked List
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */
public class Lc21_Merge_Two_Sorted_List {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }
}