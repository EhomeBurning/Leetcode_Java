/**
 * Tag: Linked List
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Solution: copy node.next to node, and jump to node.next.next; 4->5->1->9, 4->1->1->9,4->1->9;
 * Note: given the only access to the node that we wanna delete;
 */

// *Tag*: LinkedList; <br>
// *Solution*: Unlike normal deletion, this problem is using node.next replace node. <br>


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
