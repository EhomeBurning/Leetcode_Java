# LinkedList   
### Basic Skill:      
* Reverse: Recursion + Iteration    
* Find middle: slow and fast     
* Merge lists: Dummy Node       

### key points:     
1.  de-reference a ListNode, make sure it is NOT NULL pointer.    
2.  Never Ever lost the head pointer of LinkedList.     
3.  head and tail corner cases. (check all heads and tails)          
4. maintain tail pointer if add needed.   

### Array vs LinkedList:   
* Memory Layout      
    * Array: consecutive allocated memory space, no overhead.   
    * LinkedList: non-consecutive, overhead of multiple objects with the "next" reference.    
      
* (Random) access time     
    * Array: O(1)  
    * LinkedList: O(n) worst case    
   
* Search Time(non-sorted)   
    * Array: O(n)
    * LinkedList: O(n)
    
* Search Time(sorted)   
    * Array: O(logn) - binary search     
    * Linkedlist: O(n)   
    * Reason: random access time is different for array and list.   

### null pointer:   
* The reference is not pointed to any Object on the heap.   
* A special value for reference(default reference).    





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
> 1. Solution1(Iteration):get three node first. Then point back. Move forward.     
> null -> 1 -> 2 -> 3 -> 4      
> prev <- cur next    
> 2. Solution2(recursion): base case: null or one node; recursive rule: point back from left to right    
![Recursion Part](/images/ReverseLinkedList_Recursion.png)   
> null -> 1 -> 2 -> 3 -> 4       
>                      newHead = Node4      
> Difference: Iteration left to right; Recursion right to left;   


## Two Pointer      
* [876. Middle of the Linked List(Easy)](https://leetcode.com/problems/middle-of-the-linked-list/)       
> Solution: slow and fast pointers.    
> ps: 
> 1. Node 3 or Node 4: difference -> (fast != null && fast.next != null) vs  (fast.next != null && fast.next.next != null)    


* [141. Linked List Cycle(Easy)](https://leetcode.com/problems/linked-list-cycle/)   
> Explanation: There is a cycle in the linked list, where tail connects to the second node.     
> Solution: slow and fast pointer. slow == fast then return true, or return false;     


## Dummy Node     
**Question**: Why and when should we use dummy node?    
**Answer**: when we want to append new elements to an initially empty LinkedList, we do not want an initial head node.  dummyHead -> new head node.   
**ps**: Return **dummyHead.next** everytime!    

* [21. Merge Two Sorted Lists(Easy)](https://leetcode.com/problems/merge-two-sorted-lists/)      
> Solution: dummyHead as a new LinkedList; cur loop all and add nodes following rule until all lists empty;   
> ps: 
> 1. add node as a **new** ListNode;   
> 2. move cur every time;     


* [86. Partition List(Medium)](https://leetcode.com/problems/partition-list/)   
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














































