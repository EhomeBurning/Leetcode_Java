/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
* Tag: Binary Tree, Recursion
* Time: O(n)
* Space: O(height) = O(n)
* Note: LinkedList.add只加value, LinkedList.addAll将不同的LinkedList加到一起；
        用helper function的原因是不需要每次call stack的时候都会建一个新的LinkedList；
        base case记得要先写，而且tree的base case基本都是leaf node为空；
        注意helper那个是void，不需要result再加一遍；
*/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        helper(root, result);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left, result); // 注意recursion的输入条件
        helper(root.right, result); // 注意是void类型的recursion function
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            result.add(cur.val);
            
            if (cur.right != null) {
                s.push(cur.right);
            }
            
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        return result;
    }
}
