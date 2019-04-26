/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// * Tag: LinkedList;
// > Solution: slow and fast pointers.
// * Time: O(n);
// * Space: O(1);


// [3,4,5,6]
// class Solution {
//     public ListNode middleNode(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }

//         ListNode slow = head;
//         ListNode fast = head;
//         while (fast.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         return slow;
//     }
// }

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}



