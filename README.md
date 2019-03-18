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



## 9. Palindrome Number <br>
*Solution*: <br>
Despite the regular "reverse integer" solution, there is one brilliant solution without considering the overflow. <br>
Reverse half the integer; <br>
condition: halfRev == num || halfRev / 10 = num; <br>
tips: <br>
for the second solution, remember to check the case : num != 0 && num % 10 == 0;


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



## 102. Binary Tree Level Order Traversal
*Solution*: Queue;  <br>
1. Initial: root; <br>
2. Generate rule: left and right; <br>
3. Terminate Condition: queue is empty. <br>

*Time*: O(n) <br>
*Space*: O(n) <br>

*Tips*: <br>
1. queue.isEmpty() <br>
2. Follow up can be DFS. <br>



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




## 153. Find Minimum in Rotated Sorted Array<br>
*Solution*: <br>
Regular Binary Search, assume the first num is the minNum, and set it as a target. Narrow the searching range to two nums. Compare these two with the minNum. 
<br> <br>
*Time*: O(logn) <br>
*Space*: O(1) <br>


## 167. Two Sum II - Input array is sorted

*Solution* : <br>
Two Pointers(Different direction); 和正好就返回，和大了就right变小，和小了就left变大<br>
*Time*: O(n) <br>
*Space*: O(1) <br>
*Tips*: <br>
1. new int[]{-1, -1}; <br>
2. avoid oveflow. numbers[left] == target - numbers[right]; <br>


## 283. Move Zeroes <br>
*Tag*: Array; Two Pointer; <br>
*Solution*: <br>
Two Pointer(same direction); One Pointer "zero" stays at the first zero element; The other Pointer "non -zero" find the first non-zero element; Then swap them; <br>
*Time*: O(n) <br>
*Space*: O(1) <br>
*Tips*: <br>
1. Name the two pointers as slow and fast can help understand. <br>


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


## 412. Fizz Buzz<br>
one more counter solution. ++ before if condition ; <br>


## 463. Island Perimeter <br>
*Solution*: <br>
loop through all the points of the matrix. For each point which equals 1, see it is surrounded by how many 0. Each zero increases perimeter by 1. <br> <br>
*Tips*: <br>
1. Each surrounded zero should be in the matrix range. <br>
2. For those not in the range, still add perimeter one. <br>

## 561. Array Partition I <br>
*Tag*: Array <br>
*Solution*: <br>
Sort the Array. jump two at one time.<br>

*Time*: O(nlogn) <br>
*Space*: O(1) <br>


## 876. Middle of the Linked List
*Tag* : Linked List; Two Pointer; <br>
*Solution*: <br>
Slow pointer for one step, fast pointer for two steps. <br>
*Tips*: <br>
Remember to check cornner cases. Avoid Null Pointer Exception. <br>


## Topological Sorting
*Solution*: <br>
getIndegree: <br>
input -> graph; output -> hashMap(key: node; value: Indegree);<br>
startNode will not be in the hashMap. <br>

bfs: <br>
input: graph, hashMap; output: topSortOrder; <br>





