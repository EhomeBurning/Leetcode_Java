// * Tag: LinedList -> Dummy Node;
// > Solution:
// > 1. Step1: Two dummyHead;
// > 2. Step2: Add nodes followed by rule;
// > 3. Step3: merge two lists;
// * Time: O(n);
// * Space: O(n);





/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode headSmall = new ListNode(0);
        ListNode headLarge = new ListNode(0);
        ListNode small = headSmall;
        ListNode large = headLarge;
        while (head != null) {
            if (head.val < target) {
                small.next = new ListNode(head.val);
                small = small.next;
            } else {
                large.next = new ListNode(head.val);
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = headLarge.next;
        return headSmall.next;
    }
}





