// * Tag: Stack -> Classic;
// > Solution:
// > Stack; Left push, right pop out.
// * Time: O(n);
// * Space: O(n);



class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (Character ch : s.toCharArray()) {
            switch (ch) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                    
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                    
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                    
                default:
                    stack.push(ch);
            }
            
        }
        return stack.isEmpty();
    }
}
