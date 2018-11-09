import java.util.Stack;
/**
 * Tag: String, Stack
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Lc20_Valid_Parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else{
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }

        }
        return stack.isEmpty();

    }
}