/**
 * Divide&Conquer
 * Tag: Tree, DFS
 * 这种写法并不是特别标准，可以之后加上一个class：ResultType
 */

public class Lc110_Balanced_Binary_Tree {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int NOT_BALANCE = -1;

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != NOT_BALANCE;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if (left == NOT_BALANCE || right == NOT_BALANCE) {
            return NOT_BALANCE;
        }

        if (Math.abs(left - right) > 1) {
            return NOT_BALANCE;
        }

        return Math.max(left, right) + 1;
    }
}
