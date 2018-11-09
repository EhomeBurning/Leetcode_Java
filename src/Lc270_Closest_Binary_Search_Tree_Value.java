public class Lc270_Closest_Binary_Search_Tree_Value {

/**
 * Time: O(n)
 * Space: O(1)
 * /

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;


    }
}