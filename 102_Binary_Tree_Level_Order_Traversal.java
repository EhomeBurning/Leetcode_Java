// *Solution*: Queue;  <br>
// 1. Initial: root; <br>
// 2. Generate rule: left and right; <br>
// 3. Terminate Condition: queue is empty. <br>

// *Time*: O(n) <br>
// *Space*: O(n) <br>

// *Tips*: <br>
// 1. queue.isEmpty() <br>


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Expected Result: 
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List result = new ArrayList();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            int levelSize = nodeQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode head = nodeQueue.poll();
                if (head.left != null) {
                    nodeQueue.offer(head.left);
                }
                if (head.right != null) {
                    nodeQueue.offer(head.right);
                }
                levelResult.add(head.val);
            }
            result.add(levelResult);
        }
        return result;
    }
}

// Expected Result: 
// [3,9,20,15,7]

class Solution {
    public List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
            result.add(head.val);
        }
        return result;
    }
}







