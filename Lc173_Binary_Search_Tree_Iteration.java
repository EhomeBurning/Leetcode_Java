public class Lc173_Binary_Search_Tree_Iteration {

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 */

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (stack.peek().left != null)
                stack.push(stack.peek().left);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if (cur.right != null) {
            stack.push(cur.right);
            while (stack.peek().left != null)
                stack.push(stack.peek().left);
        }
        return cur.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */