import java.util.HashSet;

/**
 * Solution: Two Pointer, Hash Table
 * Time COmplexity: O(n)
 * Space Complexity: O(n)
 */


public class Lc141_Linked_LIst_Cycle {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}