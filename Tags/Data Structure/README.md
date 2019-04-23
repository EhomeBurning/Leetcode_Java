# Queue 
* FIFO: First in first out  
* Usage: BFS  
* Classic Problems:   
    * Tree Level order   
    * Sliding window  


# Stack  
* LIFO: Last in first out    


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












