/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// * Tag: LinkedList -> dummy node;
// > Solution: dummyHead as a new LinkedList; cur loop all and add nodes following rule until all lists empty;
// > ps:
// 1. add node as a **new** ListNode;
// 2. move cur every time;
// * Time: O(n);
// * Space: O(n);


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummyHead.next;
    }
}
