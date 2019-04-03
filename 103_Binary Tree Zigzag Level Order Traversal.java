// *Tag*: BFS; <br>
// *Solution*: <br>
// Difference between this question and #102: set a flag(bool), change it every time applied. <br>
// boolean falg = true; <br>
// flag = flag ? false : true; <br>

// *Time*: O(n);<br>
// *Space*: O(n);<br>



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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> levelVals = new ArrayList<Integer>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (flag) {
                    levelVals.add(cur.val);
                } else {
                    levelVals.add(0, cur.val);
                }
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            flag = flag ? false : true;
            result.add(levelVals);
        }
        return result;
    }
}









