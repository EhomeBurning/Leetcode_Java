/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// * Tag:
// > Solution1(Iteration):get three node first. Then point back. Move forward.
// > null -> 1 -> 2 -> 3 -> 4
// > prev <- cur next
// > Solution2(recursion): base case: null or one node; recursive rule: point back from left to right
// > null -> 1 -> 2 -> 3 -> 4
// >                      newHead = Node4
// > Difference: Iteration left to right; Recursion right to left;

// * Time: O(n);
// * Space: O(1);



// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null) {
//             return head;
//         }

//         ListNode prev = null;
//         ListNode cur = head;
//         while (cur != null) {
//             ListNode nextNode = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = nextNode;
//         }
//         return prev;
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        
        // recursive rule
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}





