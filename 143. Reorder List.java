/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// * Tag: LinkedList -> Combination;
// > Solution:
// > 1. Step1: Find the middle node of the LinkedList;
// > 2. Step2: reverse 2nd half;  eg: N100 -> N99 ->... -> N51;
// > 3. Step3: Merge two LinkedList;
// * Time: O(n);
// * Space: O(n);

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null; // 1st half
        
        mergeTwoLists(head, tail);
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) { // 区别
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur; // 先prev
            cur = nextNode;
        }
        return prev;
    }
    
    
    private void mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        int index = 0;
        while (l1 != null && l2 != null) {
            if (index % 2 == 0) {
                dummyHead.next = l1;
                l1 = l1.next;
            } else {
                dummyHead.next = l2;
                l2 = l2.next;
            }
            dummyHead = dummyHead.next;  // 记得dummyHead往后动
            index++;
        }
        if (l1 != null) {
            dummyHead.next = l1;
        } else {
            dummyHead.next = l2;
        }
    }
}







