/**
 * Tag: Linked List
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class Lc237_Delete_Node_In_Linked_List {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

