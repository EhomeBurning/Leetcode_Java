// *Tag*: LinkedList; <br>
// *Solution*: <br>
// Set an dummy node as head prev. loop all LinkedList, if the value matches, delete the node. <br>
// *Time*: O(n) <br>
// *Space*: O(1) <br>


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
