# LinkedList   
**Basic Skill**:      
* Reverse    
* Find middle     
* Dummy Node    

**key points**:     
1.  de-reference a ListNode, make sure it is NOT NULL pointer.    
2.  Never Ever lost the head pointer of LinkedList.     
3.  head and tail corner cases. (check all heads and tails)          
4. maintain tail pointer if add needed. 

## Topics
* [1. Classic ](#Classic)    
* [2. Two Pointer](#Two-Pointer)    
* [3. Dummy Node](#Dummy-Node)   
* [4. Combination](#Combination)  

## Classic    
* [Insert in sorted LinkedLIst](https://github.com/tonglyu/Algorithm_Class/blob/master/Class4_LinkedList/ExtraPractice/InsertInSortedLinkedList.java)    
> wrong example: cur.value < target && cur.next.value >= target   
> Corner case:  head and tail. 



* [206. Reverse Linked List(Easy)](https://leetcode.com/problems/reverse-linked-list/)  
> Input: 1->2->3->4->5->NULL   
> Output: 5->4->3->2->1->NULL    
> Solution1(Iteration):get three node first. Then point back. Move forward.     
> null -> 1 -> 2 -> 3 -> 4      
> prev <- cur next    
> Solution2(recursion): base case: null or one node; recursive rule: point back from left to right    
![Recursion Part](/images/ReverseLinkedList_Recursion.png)   
> null -> 1 -> 2 -> 3 -> 4       
>                      newHead = Node4      
> Difference: Iteration left to right; Recursion right to left;   


## Two Pointer      
* [876. Middle of the Linked List(Easy)](https://leetcode.com/problems/middle-of-the-linked-list/)       
> Input: [1,2,3,4,5,6]    
> Output: Node 4 from this list (Serialization: [4,5,6])    
> Solution: slow and fast pointers.   
> Two version for odd: Node 3 or Node 4: difference -> (fast != null && fast.next != null) vs  (fast.next != null && fast.next.next != null)    


* [141. Linked List Cycle(Easy)](https://leetcode.com/problems/linked-list-cycle/)   
> Input: head = [3,2,0,-4], pos = 1    
> Output: true    
> Explanation: There is a cycle in the linked list, where tail connects to the second node.     
> Solution: slow and fast pointer. slow == fast then return true, or return false;     


## Dummy Node     
Q: Why and when should we use dummy node?    
A: when we want to append new elements to an initially empty LinkedList, we do not want an initial head node.  dummyHead -> new head node.   
ps: Return **dummyHead.next** everytime!   

* [21. Merge Two Sorted Lists(Easy)](https://leetcode.com/problems/merge-two-sorted-lists/)      
> Input: 1->2->4, 1->3->4   
> Output: 1->1->2->3->4->4   
> Solution: dummyHead as a new LinkedList; cur loop all and add nodes following rule until all lists empty;   
> ps: 
> 1. add node as a **new** ListNode;   
> 2. move cur every time;     


* [86. Partition List(Medium)](https://leetcode.com/problems/partition-list/)   
> Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.    
> Input: head = 1->4->3->2->5->2, x = 3  
> Output: 1->2->2->4->3->5->null   
> Solution:     
> 1. Step1: Two dummyHead;  
> 2. Step2: Add nodes followed by rule;   
> 3. Step3: merge two lists;     




## Combination    

* [143. Reorder List(Medium)](https://leetcode.com/problems/reorder-list/)     
*Deserve to do it again*   
> Given a singly linked list L: L0→L1→…→Ln-1→Ln,    
> reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…   
> Given 1->2->3->4, reorder it to 1->4->2->3.      
> Solution:     
> 1. Step1: Find the middle node of the LinkedList;   
> 2. Step2: reverse 2nd half;  eg: N100 -> N99 ->... -> N51;    
> 3. Step3: Merge two LinkedList;    














































