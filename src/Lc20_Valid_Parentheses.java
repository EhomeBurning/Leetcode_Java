
// Solution:Stack, 由于左右必须挨着，左边都push进去，遇到第一个右边的，pop出来一定是左边
// Time: O(n)
// space: O(n)


class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            switch (ch) {
                case '}' : 
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    } else {
                        break;
                    }
                case ')' : 
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    } else {
                        break;
                    }
                case ']' : 
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    } else {
                        break;
                    }
                default: 
                    stack.push(ch);
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}