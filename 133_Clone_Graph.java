// *Solution*: <br>
// Graph; HashMap; BFS; Queue; <br>
// 1. get all the nodes. One Queue and one HashSet. HashSet: This is the result.store all the unique nodes. Queue: store all the neighbors, and poll it until it is empty. <br>
// 2. copy the labels. One HashMap. Key: old node from HashSet. Value: new nodes with labels. <br>
// 3. copy the neighbors. BFS. For each of all the new nodes in HashMap, copy the neighbors of the old nodes. <br>


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        // get all the nodes
        ArrayList<UndirectedGraphNode> nodeList = getAllNodes(node);
        
        // copy all the labels. Key: old node; Value: new node with label;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> newNodeMap = copyLabels(nodeList);
        
        // copy all the neighbors(edges)
        connectNeighbors(nodeList, newNodeMap);
        
        return newNodeMap.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighborNode : head.neighbors) {
                if (!set.contains(neighborNode)) {
                    set.add(neighborNode);
                    queue.offer(neighborNode);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
    
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> copyLabels(ArrayList<UndirectedGraphNode> nodeList) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode node : nodeList) {
            map.put(node, new UndirectedGraphNode(node.label));
        }
        return map;
    }
    
    private void connectNeighbors(ArrayList<UndirectedGraphNode> nodeList, HashMap<UndirectedGraphNode, UndirectedGraphNode> newNodeMap) {
        for (UndirectedGraphNode oldNode : nodeList) {
            UndirectedGraphNode newNode = newNodeMap.get(oldNode);
            for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
                UndirectedGraphNode newNeighbor = newNodeMap.get(oldNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
    }
    
}

















