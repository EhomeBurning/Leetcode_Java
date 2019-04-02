// *Solution*: Queue;  <br>
// 1. Initial: root; <br>
// 2. Generate rule: left and right; <br>
// 3. Terminate Condition: queue is empty. <br>
//  offer in root node; for each level, get the size of level nodes, expand the root node and get all child node in the queue; Until the queue is empty; <br>
//
// *Time*: O(n) <br>
// *Space*: O(n) <br>
//
// *Tips*: <br>
// 1. queue.isEmpty() <br>
// 1. for each level, get the size of this level; <br>
// 2. tree gets two iterations, graph can get three: queue, node, neighbors;


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
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelNodes);
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







