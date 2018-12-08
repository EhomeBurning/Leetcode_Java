/**
 * Two Solution: Iteration and Recursive
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Lc206_Reverse_Linked_List {
}

class Iteration{
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        // 如果把 nextNode 的声明放在while之外，则还需要一个if语句
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev;
    }
}

// Recusion这个方法没有特别清楚，需要再看
class Recursion{
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;

    }
}

