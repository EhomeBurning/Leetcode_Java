// *Solution*: <br>
// LinkedList; HashMap; <br>
// key: origin node; value: new node; <br>
// 1. copy value and put in HashMap. <br>
// 2. copy the random pointer. <br>



/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        
        HashMap<RandomListNode, RandomListNode> newNodeMap = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        
        
        while (head != null) {
            // copy node with value
            if (!newNodeMap.containsKey(head)) {
                newNodeMap.put(head, new RandomListNode(head.label));
            }
            cur.next = newNodeMap.get(head);
            
            // copy random pointer
            if (head.random != null) {
                if (!newNodeMap.containsKey(head.random)) {
                    newNodeMap.put(head.random, new RandomListNode(head.random.label));
                }
                cur.next.random = newNodeMap.get(head.random);
            }
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }
}
