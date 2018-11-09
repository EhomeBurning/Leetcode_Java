import java.util.List;

public class Lc257_Binary_Tree_Paths {
/**
 * Tag: DFS
 * Time: O(n)
 * Space: O(n)
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }

        for (String path : binaryTreePaths(root.left)) {
            paths.add(root.val + "->" + path);
        }

        for (String path : binaryTreePaths(root.right)) {
            paths.add(root.val + "->" + path);
        }

        return paths;
    }
}