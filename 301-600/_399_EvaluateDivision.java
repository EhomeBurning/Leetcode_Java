package leetcode_1To300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 本代码来自 Cspiration，由 @Cspiration 提供
 * 题目来源：http://leetcode.com
 * - Cspiration 致力于在 CS 领域内帮助中国人找到工作，让更多海外国人受益
 * - 现有课程：Leetcode Java 版本视频讲解（1-900题）（上）（中）（下）三部
 * - 算法基础知识（上）（下）两部；题型技巧讲解（上）（下）两部
 * - 节省刷题时间，效率提高2-3倍，初学者轻松一天10题，入门者轻松一天20题
 * - 讲师：Edward Shi
 * - 官方网站：https://cspiration.com
 * - 版权所有，转发请注明出处
 */
public class _399_EvaluateDivision {

    /**
     * 399. Evaluate Division
     * Equations are given in the format A / B = k, where A and B are variables represented as strings,
     * and k is a real number (floating point number). Given some queries, return the answers.
     * If the answer does not exist, return -1.0.

     a / b * b / c = a / c

     Example:
     Given a / b = 2.0, b / c = 3.0.
     queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
     return [6.0, 0.5, -1.0, 1.0, -1.0 ].

     The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
     where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

     According to the example above:

     equations = [ ["a", "b"], ["b", "c"] ],
     values = [2.0, 3.0],
     queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

     equation : "b", "c"

     map : "a" 'b', 2.0
           "b" 'a', 1/2.0
               'c', 3.0
           "c" 'b', 1/3.0

     time : O(V+E)
     space : O(n)


     */

    HashMap<String, List<GraphNode>> map;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!map.containsKey(equation[0])) {
                map.put(equation[0], new ArrayList<>());
            }
            map.get(equation[0]).add(new GraphNode(equation[1], values[i]));
            if (!map.containsKey(equation[1])) {
                map.put(equation[1], new ArrayList<>());
            }
            map.get(equation[1]).add(new GraphNode(equation[0], 1 / values[i]));
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = find(queries[i][0], queries[i][1], 1, new HashSet<>());
        }
        return res;
    }

    private double find(String start, String end, double value, HashSet<String> visited) {
        if (visited.contains(start)) return -1;
        if (!map.containsKey(start)) return -1;

        if (start.equals(end)) return value;
        visited.add(start);
        for (GraphNode next : map.get(start)) {
            double sub = find(next.den, end, value * next.val, visited);
            if (sub != -1.0) return sub;
        }
        visited.remove(start);
        return -1;
    }

    class GraphNode {
        String den;
        double val;
        GraphNode(String den, double val) {
            this.den = den;
            this.val = val;
        }
    }
}

