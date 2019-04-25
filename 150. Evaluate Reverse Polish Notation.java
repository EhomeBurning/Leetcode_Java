// * Tag: Stack -> Classic;
// > Solution:
// > 1. for nums, push into stack. continue;
// > 2. for operators, pop two nums from stack and apply operators to them. push the result into stack.
// * Time: O(n);
// * Space: O(n);


class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return -1;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                    
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                    
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                    
                case "/":
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second / first);
                    break;
                    
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
