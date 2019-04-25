# Queue 
* FIFO: First in first out  
* Usage: BFS  
* Classic Problems:   
    * Tree Level order   
    * Sliding window  


# Stack  
* LIFO: Last in first out   
* Application: Linear scan array/string, need to check the right most.  
    * Histogrm most biggest square  
    * reverse polish notation.  eg: a*(b+c) -> abc+*
    * string -> repeatedly deduplacation. eg: cabba -> caa -> c    
    

## Classic   
* [20. Valid Parentheses(Easy)](https://leetcode.com/problems/valid-parentheses/)    
> Input: "()[]{}"  
> Output: true  
> Solution: Stack; Left push, right pop out.    



* [150. Evaluate Reverse Polish Notation(Medium)](https://leetcode.com/problems/evaluate-reverse-polish-notation/)   
> Input: ["2", "1", "+", "3", "*"]  
> Output: 9  
> Explanation: ((2 + 1) * 3) = 9   
> Solution:   
> 1. for nums, push into stack.    
> 2. for operators, pop two nums from stack and apply operators to them. push the result into stack.      
> ps: prefix -> ((2 + 1) * 3); postfix -> 2 1 + 3 * ;    







## Two Stacks  
* [232. Implement Queue using Stacks(Easy)](https://leetcode.com/problems/implement-queue-using-stacks/)    
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

* [155. Min Stack(Easy)](https://leetcode.com/problems/min-stack/)  
> minStack.getMin();   --> Returns -3.
> minStack.pop();
> minStack.top();      --> Returns 0.
> minStack.getMin();   --> Returns -2.  
  
> Solution1:   
> 1. Stack1: Store all the nums. ||   1 3 2 4 -1     
> 2. Stack2: Store all the minVal. || 1 1 1 1 -1     
  
> [Solution2](https://github.com/tonglyu/Algorithm_Class/blob/master/Class3_Stack_Queue/StackWithMin.java): (Follow up: what is there are a lot of dupliacate num, how to optimize Stack2 space?)  
> 1. Stack1: Store all the nums. ||   1 3 2 4 -1       
> 2. Stack2: <minVal, sizeOfS1> || <1,1> <-1,5>     

* [Sort with two stacks](https://github.com/tonglyu/Algorithm_Class/blob/master/Class3_Stack_Queue/SortWith2Stacks.java)  
> Solution:   
> 1. Stack1: all the nums.   || 3 4  3  5     global_min = 1
> 2. Stack2: sorted array.   || 1  1                   count = 1
> (1) Mehtod1: while (stack2.size() > fixSize)  
> (2) Method2: while (stack2.peek() > global_min)  keep poping   

  
>  Follow-up: what if there are a lot of duplicate numbers?   
> Answer: add count.   


## Three Stacks  
* [Multiple Stack to implement deque](https://github.com/tonglyu/Algorithm_Class/blob/master/Class3_Stack_Queue/DequeByThreeStack.java)    
> Solution: Three stacks. Stack3 is buffer for pop from both sides.   
> 1 2 3 4 5 ||Stack1  Stack2 || 6 7 8 9      
> Stack3 || (1 2 3 4 5)    
> Time: (Amortized) O(0.5n + 0.5n + 0.5n + 0.5n) / 0.5n = O(4) = O(1)     


# LinkedList
key points:     
1.  de-reference a ListNode, make sure it is NOT NULL pointer.    
2.  Never Ever lost the head pointer of LinkedList.  






















