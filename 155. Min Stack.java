// * Tag: Stack -> two stacks;

// > Solution1:
// > 1. Stack1: Store all the nums. ||   1 3 2 4 -1
// > 2. Stack2: Store all the minVal. || 1 1 1 1 -1

// > Solution2: (Follow up: what is there are a lot of dupliacate num, how to optimize Stack2 space?)
// > 1. Stack1: Store all the nums. ||   1 3 2 4 -1
// > 2. Stack2: <minVal, sizeOfS1> || <1,1> <-1,5>


class MinStack {
    
    Stack<Integer> allNum;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        allNum = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        allNum.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }
    
    public void pop() {
        minStack.pop();
        allNum.pop();
    }
    
    public int top() {
        return allNum.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
