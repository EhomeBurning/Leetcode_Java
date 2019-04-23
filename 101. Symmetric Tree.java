/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// * Tag: BFS;
// > Solution:
// > 1. Queue; push two root in queue;
// > 2. Generate rule: r1.left, r2.right, r1.right, r2.left;
// * Time: O(n);
// * Space: O(n);

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode r1 = queue.poll();
            TreeNode r2 = queue.poll();
            if (r1 == null && r2 == null) {
                continue;
            }
            if (r1 == null || r2 == null) {
                return false;
            }
            if (r1.val != r2.val) {
                return false;
            }
            queue.offer(r1.left);
            queue.offer(r2.right);
            queue.offer(r1.right);
            queue.offer(r2.left);
        }
        return true;
    }
}

