# Leetcode_Java
*Solutions of LeetCode Algorithm Problems with Java.*

## 7. Reverse Integer<br>
*Solution*:<br>
while (x > 0)<br>
123 % 10 = 3;<br>
result = 10 * result + 3;<br>
x = x / 10;<br>

*tips*:<br>
check the OVERFLOW after reversing, so the result should be long type;<br>
negative number case;<br>

## 8. String to Integer (atoi)   
* Tag: String;    
> Solution:     
> 1. firstChar as a sign;       
> 2. see if the following char is digit or not;       
> 3. if char, result = 10 * result + curNum;   
* Time: O(n);    
* Space: O(1);    
* Tips:      
1. mind MAX_VALUE and MIN_VALUE;   



## 9. Palindrome Number <br>
*Solution*: <br>
Despite the regular "reverse integer" solution, there is one brilliant solution without considering the overflow. <br>
Reverse half the integer; <br>
condition: halfRev == num || halfRev / 10 = num; <br>
tips: <br>
for the second solution, remember to check the case : num != 0 && num % 10 == 0;    


## 20. Valid Parentheses  
* Tag: Stack -> Classic;  
> Solution:   
> Stack; Left push, right pop out.   
* Time: O(n);   
* Space: O(n); 

## 21. Merge Two Sorted Lists  
* Tag: LinkedList -> dummy node;  
> Solution: dummyHead as a new LinkedList; cur loop all and add nodes following rule until all lists empty;   
> ps: 
1. add node as a **new** ListNode;   
2. move cur every time;   
* Time: O(n);   
* Space: O(n);   



## 33. Search in Rotated Sorted Array    
* Tag: Binary Search -> which half;   
> Solution:     
> 1. Step 1. classic binary search, get the mid;  
> 2. Step 2. num[left] and nums[mid]  
> case 1: num[left] <= nums[mid]; num[left] <= target < nums[mid], right = mid - 1;  
> case 2: nums[mid] <= nums[right]; nums[mid] < target <= nums[right], left = mid + 1;  
* Time: O(logn);  
* Space: O(1);  
 

## 50. Pow(x, n) <br>
*Example*:<br> 2^10 -> 2^5 -> 2^2 -> 2^1 -> 2^0 <br>

*Solution*: <br> Recursion. <br>
1. basic case: n = 0, x ^ n = 1; <br>
2. recursive rule: n odd, x * x^(n/2) * x^(n/2); n even, x^(n/2) * x^(n/2); <br>

*Tips*: <br>
1. negative <br>
eg: 2^-4 = 1 / 2^4; -> n = -n, x = 1 / x; <br><br>

*Time*: O(logx) // level of recursion tree <br>
*Space*: O(logx) // how many call_Stack <br>


## 74. Search a 2D Matrix
* Tag: Binary Search -> Matrix;  
>  Solution: midRow = mid / col; midCol = mid % col;  
* Time: O(logn);    
* Space: O(1);     


## 81. Search in Rotated Sorted Array II  
* Tag: Binary Search -> which half;  
> Solution:   
> 1. Step 1. classic binary search, get the mid;  
> 2. Step 2. num[left], nums[mid]    
> 2.1 case 1: num[left] < nums[mid]; num[left] <= target < nums[mid], right = mid - 1;    
> 2.2 case 2: nums[left] > nums[mid]; nums[mid] < target <= nums[right], left = mid + 1;   
> 2.3 case 3: nums[left] == nums[mid]; left++;   
* Time: O(logn); worst case O(n);   
* Space: O(1);   


## 86. Partition List  
* Tag: LinedList -> Dummy Node;   
> Solution:     
> 1. Step1: Two dummyHead;  
> 2. Step2: Add nodes followed by rule;   
> 3. Step3: merge two lists;     
* Time: O(n);   
* Space: O(n);   


## 101. Symmetric Tree  
* Tag: BFS;  
> Solution:   
> 1. Queue; push two root in queue;  
> 2. Generate rule: r1.left, r2.right, r1.right, r2.left;  
* Time: O(n);  
* Space: O(n);




## 102. Binary Tree Level Order Traversal
*Solution*: Queue;  <br>
1. Initial: root; <br>
2. Generate rule: left and right; <br>
3. Terminate Condition: queue is empty. <br>
offer in root node; for each level, get the size of level nodes, expand the root node and get all child node in the queue; Until the queue is empty; <br>

*Time*: O(n) <br>
*Space*: O(n) <br>

*Tips*: <br>
1. queue.isEmpty() <br>
1. for each level, get the size of this level; <br>
2. tree gets two iterations, graph can get three: queue, node, neighbors;


## 103. Binary Tree ZigZag Level Order Traversal
*Tag*: BFS; <br>
*Solution*: <br>
Difference between this question and #102: set a flag(bool), change it every time applied. <br>
boolean falg = true; <br>
flag = flag ? false : true; <br>

*Time*: O(n);<br>
*Space*: O(n);<br>



## 107. Binary Tree Level Order Traversal II
*Tag*: BFS, LinkedList; <br>
*Solution*: <br>
difference with #102. Use LinkedList as result data structure. Add each level to the index 0 of list. <br>;
*Time*: O(n); <br>
*Space*: O(n); <br>


## 114. Flatten Binary Tree to Linked List
*Tag*: DFS; <br>
*Solution*: <br>
Stack; push root in stack; For child level, push right first, then left; Set root right child as stack.peek(), left child as null; Until the stack is empty; <br>

*Time*: O(n) <br>
*Space*: O(n) <br>
*Tips*: Check the stack if it is empty. 



## 127. Word Ladder
*Tag*: BFS; <br>
*Solution*: <br>
BFS: One Queue, one HashSet. Queue stores one level of words. Each level is oneEditDistance away. HashSet stores all the words that has been visited. (1) queue is not empty. (2) every word in queue. (3) all oneEditDistance words of the beginning word. <br>
oneEditDistance: Generate rule for the word in queue to expand the next level. for 26 letters in English, change one letter of the words. If the changed word exists in the wordList, then it is oneEditDistance. <br>
*Time*:
*Space*:
*Tips*: <br>
1. Compare two ways of oneEditDistance: <br>
(1) Compare all the words in wordList to the begin word. wordList -> N, word length -> L. Time: O(N * L) <br>
(2) oneEditDistance: wordList -> N, word length -> L. Time: O(26 * L^2);




## 133. Clone Graph
*Solution*: <br>
Graph; HashMap; BFS; Queue; <br>
1. get all the nodes. One Queue and one HashSet. HashSet: This is the result.store all the unique nodes. Queue: store all the neighbors, and poll it until it is empty. <br>
2. copy the labels. One HashMap. Key: old node from HashSet. Value: new nodes with labels. <br>
3. copy the neighbors. BFS. For each of all the new nodes in HashMap, copy the neighbors of the old nodes. <br>


## 138. Copy List with Random
*Solution*: <br>
LinkedList; HashMap; <br>
key: origin node; value: new node; <br>
1. copy value and put in HashMap. <br>
2. copy the random pointer. <br>


## 141. Linked List Cycle  
* Tag: LinkedList -> Two Pointer;    
> Solution: slow and fast pointer. slow == fast then return true, or return false;    
* Time: O(n);    
* Space: O(1);     

## 143. Reorder List  
* Tag: LinkedList -> Combination;   
> Solution:     
> 1. Step1: Find the middle node of the LinkedList;   
> 2. Step2: reverse 2nd half;  eg: N100 -> N99 ->... -> N51;    
> 3. Step3: Merge two LinkedList;    
* Time: O(n);   
* Space: O(n);   



## 144. Binary Tree Preorder Traversal
* Tag: Tree;    
* Solution:  Iteration: Stack; Recursion;     


## 148. Sort List  
* Tag: LinkedList -> Combination;   
> Solution: mid + merge + merge sort            
> 1. find mid;   
> 2. merge two list based on value;   
* Time: O(nlogn);   
* Space: O(n);     


## 150. Evaluate Reverse Polish Notation  
* Tag: Stack -> Classic;   
> Solution:   
> 1. for nums, push into stack. continue;      
> 2. for operators, pop two nums from stack and apply operators to them. push the result into stack.   
* Time: O(n);    
* Space: O(n);     




## 151. Reverse Words in a String  
*Tag*: String -> StringReversal;
*Solution*:
Step1. Reverse the sentence
Step2. Reverse each word: find the start and end index of the words
Step3. Clean spaces using two pointers.
*Tips*:
1. Mind leading and trailing spaces of the input String.
2. Mind multiple spaces between two words.


## 153. Find Minimum in Rotated Sorted Array<br>
* Tag: Binary Search -> Rotated Sorted Array;    
> Time: O(logn);    
> Space: O(1);    


## 155. Min Stack   
* Tag: Stack -> two stacks;   

> Solution1:   
> 1. Stack1: Store all the nums. ||   1 3 2 4 -1     
> 2. Stack2: Store all the minVal. || 1 1 1 1 -1     

> Solution2: (Follow up: what is there are a lot of dupliacate num, how to optimize Stack2 space?)  
> 1. Stack1: Store all the nums. ||   1 3 2 4 -1       
> 2. Stack2: <minVal, sizeOfS1> || <1,1> <-1,5>     




## 167. Two Sum II - Input array is sorted

*Solution* : <br>
Two Pointers(Different direction); 和正好就返回，和大了就right变小，和小了就left变大<br>
*Time*: O(n) <br>
*Space*: O(1) <br>
*Tips*: <br>
1. new int[]{-1, -1}; <br>
2. avoid oveflow. numbers[left] == target - numbers[right]; <br>

## 186. Reverse Words in a String II
*Tag*: String -> StringReversal;  
*Solution*:   
Similar to 151. Reverse Words in a String;  


## 200. Number of Islands



## 203. Remove Linked List Elements
*Tag*: LinkedList; <br>
*Solution*: <br>
Set an dummy node as head prev. loop all LinkedList, if the value matches, delete the node. <br>
*Time*: O(n) <br>
*Space*: O(1) <br>

## 206. Reverse Linked List  
* Tag: 
> Solution1(Iteration):get three node first. Then point back. Move forward.   
> null -> 1 -> 2 -> 3 -> 4    
> prev <- cur next  
> Solution2(recursion): base case: null or one node; recursive rule: point back from left to right   
> null -> 1 -> 2 -> 3 -> 4     
>                      newHead = Node4    
> Difference: Iteration left to right; Recursion right to left;   

* Time: O(n);    
* Space: O(1);     


## 232. Implement Queue using Stacks  
* Tag: Stack;   
> Solution:       
> 1. Stack1: To buffer new elements.   -> push(x) goes to Stack1.    
> 2. Stack2: Pop first element from Stack2.  
> case1: If Stack2 is empty, move all the element from Stack1 to Stack2. Then pop from Stack2.    
> case2:  If Stack2 is not empty, pop from Stack2.     
   
> Time:  
> 1. Push() -> O(1);       
> 2. Pop() -> O(1);    
> explain pop time complexity: 1st element pop: n (pop from Stack1) + n (push to Stack2) + 1 (pop from Stack1)      
> 2nd pop(): time = 1      
> ...   
> nth pop(): time = 1    
> Amortized time complexity: 2n + 1 + (n - 1) / n = 3 -> O(1)    


## 237. Delete Node in a Linked List
*Tag*: LinkedList; <br>
*Solution*: Unlike normal deletion, this problem is using node.next replace node. <br>


## 240. Search a 2D Matrix II 
* Tag: Binary Search -> others;  
* Solution: either start with top right or bottom left; x++, y-- to locate target;  
* Time: O(m + n);  
* Space: O(1);  


## 278. First Bad Version  
* Tag: Binary Search -> left + 1 < right;  
* Solution: First true; if (nums[mid] == target) right = mid;  
* Time: O(logn);  
* Space: O(1);  
* Note: 注意起始不是0，而是1  
* why logn: 搜索区间的的变化，n,n/2,n/2^2,...,n/2^k -> n/2^k = 1 -> k = lgn = \theta(logn)  


## 283. Move Zeroes <br>
*Tag*: Array; Two Pointer; <br>
*Solution*: <br>
Two Pointer(same direction); One Pointer "zero" stays at the first zero element; The other Pointer "non -zero" find the first non-zero element; Then swap them; <br>
*Time*: O(n) <br>
*Space*: O(1) <br>
*Tips*: <br>
1. Name the two pointers as slow and fast can help understand. <br>


## 340. Longest Substring with At Most K Distinct Characters
*Tag*: String, Sliding Window; <br>
*Solution*: <br>
Sliding Window -> (i, j); <br>
Move j and update int[] count; When the numOfDistChar > k, move i, update count if count[s.charAt(i)] == 0 and i++; <br>
update result;
*Time*: O(n); <br>
*Space*: O(1); <br>

## 344. Reverse String  
*Tag*: String -> StringReversal  


## 374. Guess Number Higher or Lower
* Tag: Binary Search -> half Value;  
* Time: O(logn);  
* Space: O(1);  



## 378. Kth Smallest Element in a Sorted Matrix
*Solution*: <br>
1. initial state (start node): matrix[0][0] <br>

2. Node expansion/generation rule : <br>
generate matrix[0][1]; generate matrix[1][0]; <br>
12345<br>
23456<br>
34567<br>
45678<br>
56789<br>
p_queue(2,2) <br>

3. Termination condition: <br>
When the kth element pop out from the p_queue. <br>

4. De-duplicate: <br>
Build another matrix to store whether generate or not. <br>

*Time*: <br>
k iteration. For each iteration: <br>
1. pop an element from q_queue. max 2k elements. pq.pop() -> log(2k) = log(k); <br>
2. generate at most two neighbor elements. pq.insert(neighbor) -> 2log(k); <br>
Overall: k * 3log(k) = klog(k); <br>

*Space*: O(2k) = O(k) <br>

*Tips*: 
1. Remember to de-duplicate. <br>

* Tag: Binary Search;  
> Solution:  
> 1. Step 1: get the midVal(half of minVal and maxVal);  
> 2. Step 2: count how many numbers bigger than midVal;  
> 3. Step 3: change min or max depends on relationship between k and midVal;  
* Time: O(nlog(max - min));  
* Space: O(1);  



## 387. First Unique Character in a String
* Assumption:   
1. Only lower case;   
* Tag: String;    
* Solution:   
int[] count = new int[26];    
count[ch - 'a']++;   
* Time: O(n);   
* Space: O(1);   




## 412. Fizz Buzz<br>
one more counter solution. ++ before if condition ; <br>


## 463. Island Perimeter <br>
*Solution*: <br>
loop through all the points of the matrix. For each point which equals 1, see it is surrounded by how many 0. Each zero increases perimeter by 1. <br> <br>
*Tips*: <br>
1. Each surrounded zero should be in the matrix range. <br>
2. For those not in the range, still add perimeter one. <br>


## 540. Single Element in a Sorted Array 
> Tag: Binary Search -> Classic;  
> Solution: odd or even;  
> Time: O(logn);  
> Space: O(1);   



## 561. Array Partition I <br>
*Tag*: Array <br>
*Solution*: <br>
Sort the Array. jump two at one time.<br>

*Time*: O(nlogn) <br>
*Space*: O(1) <br>


## 643. Maximum Average Subarray I  
> Tag: Array;  
> Solution: Get the sum of k. Keep going forward for fixed window k.  
> Time: O(n);  
> Space: O(1);  


## 658. Find K Closest Elements
* Tag: Binary Search - left + 1 < right;  
* Solution:   
* 1. Step1: Find the left and right range of target;  
* 2. Step2: Middle out. 中心开花， 谁近移谁;  
* Time: O(logn + k);  
* Space: O(1);   



## 680. Valid Palindrome II
*Tag*: String;<br>
*Solution*: <br>
isValid(left + 1, right), isValid(left, right - 1); <br>
*Time*: O(n); Only delete once; <br>
*Space*: O(1);<br>

## 702. Search in a Sorted Array of Unknown Size  
> Tag: Binary Search -> Classic;
> Time: O(logn);
> Space: O(1);

## 704. Binary Search
> Tag: Binary Search - Classic; 



## 852. Peak Index in a Mountain Array
> Solution: Basic Binary Search;  
> Time: O(nlogn);  
> Space: O(1);  


## 876. Middle of the Linked List
* Tag: LinkedList;  
> Solution: slow and fast pointers.  
> Two version for odd: Node 3 or Node 4: difference -> (fast != null && fast.next != null) vs  (fast.next != null && fast.next.next != null)      
* Time: O(n);  
* Space: O(1);     

## 905. Sort Array By Parity  
* Tag: Two pointer;   
> Solution:    
> 1. i: slow pointer; j: find even num;   
> 2. condition: swap when find even num; 
* Time: O(n);   
* Space: O(1);     


## 922. Sort Array By Parity II    
* Tag: Two Pointers;    
> Assumptions: 
> 1. num of even = num of odd.     
> 2. array.length % 2 == 0.   
> Solution:   
> 1. i: even index; j: odd index;  
> 2. condition: i find odd num, j find even num, then swap;   
> Tips: 
> 1. in while loop, mind index exception every condition and put it in the first place.    
* Time: O(n);   
* Space: O(1);    



## Topological Sorting
*Solution*: <br>
getIndegree: <br>
input -> graph; output -> hashMap(key: node; value: Indegree);<br>
startNode will not be in the hashMap. <br>

bfs: <br>
input: graph, hashMap; output: topSortOrder; <br>






