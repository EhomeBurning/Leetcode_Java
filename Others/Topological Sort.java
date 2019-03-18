/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

// *Solution*: <br>
// getIndegree: <br>
// input -> graph; output -> hashMap(key: node; value: Indegree);<br>
// startNode will not be in the hashMap. <br>
//
// bfs: <br>
// input: graph, hashMap; output: topSortOrder; <br>





public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        
        if (graph == null) {
            return order;
        }
        // Key: GraphNode; Value: Indegree Number;
        HashMap<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        indegreeMap = getIndegree(graph);
        
        // Topological Sorting - bfs;
        order = bfs(graph, indegreeMap);
        
        return order;
    }
    
    private HashMap<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (indegreeMap.containsKey(neighbor)) {
                    indegreeMap.put(neighbor, indegreeMap.get(neighbor) + 1);
                } else {
                    indegreeMap.put(neighbor, 1);
                }
            }
        }
        return indegreeMap;
    }
    
    private ArrayList<DirectedGraphNode> bfs(ArrayList<DirectedGraphNode> graph, HashMap<DirectedGraphNode, Integer> indegreeMap) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        // start node is NOT in the map;
        for (DirectedGraphNode node : graph) {
            if (!indegreeMap.containsKey(node)) {
                result.add(node);
                queue.offer(node);
            }
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode start = queue.poll();
            for (DirectedGraphNode neighbor : start.neighbors) {
                indegreeMap.put(neighbor, indegreeMap.get(neighbor) - 1);
                if (indegreeMap.get(neighbor) == 0) {
                    result.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }
    
}
