# LinkedList 

key points:     
1.  de-reference a ListNode, make sure it is NOT NULL pointer.    
2.  Never Ever lost the head pointer of LinkedList.     
3. head and tail corner cases.   


* [Insert in sorted LinkedLIst](https://github.com/tonglyu/Algorithm_Class/blob/master/Class4_LinkedList/ExtraPractice/InsertInSortedLinkedList.java)  



* [206. Reverse Linked List(Easy)](https://leetcode.com/problems/reverse-linked-list/)  
> Input: 1->2->3->4->5->NULL   
> Output: 5->4->3->2->1->NULL    
> Solution1(Iteration):get three node first. Then point back. Move forward.     
> null -> 1 -> 2 -> 3 -> 4      
> prev <- cur next    
> Solution2(recursion): base case: null or one node; recursive rule: point back from left to right     
> null -> 1 -> 2 -> 3 -> 4       
>                      newHead = Node4      
> Difference: Iteration left to right; Recursion right to left;   


## Two pointer   
* [876. Middle of the Linked List(Easy)(https://leetcode.com/problems/middle-of-the-linked-list/)       
> Input: [1,2,3,4,5,6]    
> Output: Node 4 from this list (Serialization: [4,5,6])    
> Solution: slow and fast pointers.   
> Two version for odd: Node 3 or Node 4: difference -> (fast != null && fast.next != null) vs  (fast.next != null && fast.next.next != null)    


* [141. Linked List Cycle(Easy)](https://leetcode.com/problems/linked-list-cycle/)   
> Input: head = [3,2,0,-4], pos = 1    
> Output: true    
> Explanation: There is a cycle in the linked list, where tail connects to the second node.     
> Solution: slow and fast pointer. slow == fast then return true, or return false;     































