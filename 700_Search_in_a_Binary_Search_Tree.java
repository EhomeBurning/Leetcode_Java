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
    
//     // Recursion 1
//     public TreeNode searchBST(TreeNode root, int val) {
//         if (root == null || root.val == val) {
//             return root;
//         }
//         // recursive rule 
//         if (root.val > val) {
//             return searchBST(root.left, val);
//         } else {
//             return searchBST(root.right, val);
//         }
//     }
    
    
//     // Recursion 2
//     public TreeNode searchBST(TreeNode root, int val) {
//         TreeNode cur = root;
//         while (cur != null && cur.val != val) {
//             if (cur.val > val) {
//                 return searchBST(cur.left, val);
//             } else {
//                 return searchBST(cur.right, val);
//             }
//         }
//         return cur;
        
//     }
    
    
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null && cur.val != val) {   // 判断null要在前面
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }
}