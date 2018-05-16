/**
 * Two solution: Traverse and Divide&Conquer
 * Tag: Tree, DFS
 * 注意各种加1
 */

public class Lc104_Max_Depth_of_Binary_Tree {
}

class Traverse {
    private int depth;

    public int maxDepth(TreeNode root) {
        depth = 0;
        traverse(root, 1);
        return depth;
    }

    private void traverse(TreeNode node, int curDepth) {
        if (node == null) return;

        depth = Math.max(depth, curDepth);
        traverse(node.left, curDepth + 1);
        traverse(node.right, curDepth + 1);
    }
}

class DivideConquer{
    public int maxDepth(TreeNode root) {
        if (root == null)  return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

