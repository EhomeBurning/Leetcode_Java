// * Tag: Stack;
// > Solution:
// > 1. Stack1: To buffer new elements.   -> push(x) goes to Stack1.
// > 2. Stack2: Pop first element from Stack2.
// > case1: If Stack2 is empty, move all the element from Stack1 to Stack2. Then pop from Stack2.
// > case2:  If Stack2 is not empty, pop from Stack2.

// > Time:
// > 1. Push() -> O(1);
// > 2. Pop() -> O(1);
// > explain pop time complexity: 1st element pop: n (pop from Stack1) + n (push to Stack2) + 1 (pop from Stack1)
// > 2nd pop(): time = 1
// > ...
// > nth pop(): time = 1
// > Amortized time complexity: 2n + 1 + (n - 1) / n = 3 -> O(1)

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */





