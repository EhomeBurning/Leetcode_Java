package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeUpsideDown
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class BinaryTreeUpsideDown {
    /**
     * 156. Binary Tree Upside Down
     * Given a binary tree where all the right nodes are either leaf nodes with a
     * sibling (a left node that shares the same parent node) or empty,
     * flip it upside down and turn it into a tree where the original right nodes
     * turned into left leaf nodes. Return the new root.

     For example:
     Given a binary tree {1,2,3,4,5},
         1
        / \
       2   3
      / \
     4   5
     return the root of the binary tree [4,5,2,#,#,3,1].
       4
      / \
     5   2
        / \
       3   1

         1         1
        / \       /
       2   3     2 - 3
      / \       /
     4   5     4 - 5

     time : O(n);
     space : O(n);
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return newRoot;
    }

}
